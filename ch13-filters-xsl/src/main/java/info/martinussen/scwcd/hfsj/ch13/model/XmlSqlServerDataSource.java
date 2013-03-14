package info.martinussen.scwcd.hfsj.ch13.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class XmlSqlServerDataSource implements XmlDataSource {
  
  private static final String JDBC_DRIVER_NAME = "net.sourceforge.jtds.jdbc.Driver";

  private static Logger log = Logger.getLogger(XmlSqlServerDataSource.class);
  
  private Properties prop = null;
  
  private String dbConnectString;
  private String dbUserId;
  private String dbPassword;
  
  static {
    log.trace("XmlSqlServerDataSource loaded");
    try {
      Class.forName(JDBC_DRIVER_NAME);
    } catch (ClassNotFoundException e) {
      String message = "JDBC driver class not found";
      log.fatal(message);
      throw new IllegalStateException(e);
    }
  }

  public XmlSqlServerDataSource(){
    log.trace("XmlSqlServerDataSource constructed");
    prop = new Properties();
    try {
      prop.load(XmlSqlServerDataSource.class.getClassLoader().getResourceAsStream("/db.properties"));
      dbUserId = prop.getProperty("dbUserId");
      String message = null;
      if (dbUserId == null){
        message = "Failed to get dbUserId from db.properties";
        log.fatal(message);
        throw new IllegalStateException(message);
      }
      dbPassword = prop.getProperty("dbPassword");
      if (dbPassword == null){
        message = "Failed to get dbPassword from db.properties";
        log.fatal(message);
        throw new IllegalStateException(message);
      }
      dbConnectString = prop.getProperty("dbConnectString");
      if (dbConnectString == null){
        message = "Failed to get dbConnectString from db.properties";
        log.fatal(message);
        throw new IllegalStateException(message);
      }
    } catch (IOException e) {
      String message = "Error reading db.properties";
      log.fatal(message);
      throw new IllegalStateException(message);
    }
    log.debug("dbUserId = " + dbUserId);
    log.debug("dbPassword = " + dbPassword);
    log.debug("dbConnectString = " + dbConnectString);
  }

  public String getXmlData() {
    log.debug("XmlSqlServerDataSource.getXmlData() runs");
    String query = "exec Bookstore_asXml";
    String returnValue = null;
    
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    try {
      conn = DriverManager.getConnection(dbConnectString, dbUserId, dbPassword);
      st = conn.createStatement();
      rs = st.executeQuery(query);
      if (rs.next()){
        returnValue = rs.getString(1);
      }
    } catch (SQLException e) {
      String message = "Exception caught while trying to connect to - or query - the database";
      log.fatal(message);
      throw new RuntimeException(e);
    } finally {
        try {rs.close();}   catch (SQLException se){}
        try {st.close();}   catch (SQLException se){} 
        try {conn.close();} catch (SQLException se){}
    }
    return returnValue;
  }

  public void cleanUp() { //TODO driver doesn't seem to be deregistered...
    log.debug("XmlSqlServerDataSource.cleanUp() runs");
    try {
      java.sql.Driver driver = DriverManager.getDriver(dbConnectString);
      DriverManager.deregisterDriver(driver);
    } catch (SQLException e) {
      String message = "SQLException was caught while trying to deregister driver" + e.getMessage();
      log.error(message);
      throw new RuntimeException(e);
    }
  }
}
