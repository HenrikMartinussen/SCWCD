package info.martinussen.scwcd.hfsj.ch13.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

public class XmlSqlServerDataSource implements XmlDataSource {
  
  private static final String JDBC_DRIVER_NAME = "net.sourceforge.jtds.jdbc.Driver";

  private static Logger log = Logger.getLogger(XmlSqlServerDataSource.class);
  
  private ServletContext servletContext;
  private boolean initialized = false;
  
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
  }

  public void setServletContext(ServletContext servletContext) {
    this.servletContext = servletContext;
  }
  
  public boolean isInitialized() {
    return this.initialized;
  }
  
  public void init() {
    if (!initialized) {
      String message = "";
      if (servletContext == null){
        message = "init cannot run when servletContext is null";
        log.fatal(message);
        throw new IllegalStateException(message);
      }
      dbUserId = servletContext.getInitParameter("dbUserId");
      if (dbUserId == null){
        message = "Failed to get dbUserId from the servletContext";
        log.fatal(message);
        throw new IllegalStateException(message);
      }
      dbPassword = servletContext.getInitParameter("dbPassword");
      if (dbPassword == null){
        message = "Failed to get dbPassword from the servletContext";
        log.fatal(message);
        throw new IllegalStateException(message);
      }
      dbConnectString = servletContext.getInitParameter("dbConnectString");
      if (dbConnectString == null){
        message = "Failed to get dbConnectString from the servletContext";
        log.fatal(message);
        throw new IllegalStateException(message);
      }
      initialized = true;
    } else{
      log.warn("init was called on already initialized XmlSqlServerDataSource");
    }
  }


  public String getXmlData() {
    if (!initialized){
      String message = "Cannot call getXmlData on a not initialized XmlSqlServerDataSource";
      log.fatal(message);
      throw new IllegalStateException(message );
    }
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
        try {rs.close();} catch (SQLException se){}
        try {st.close();} catch (SQLException se){} 
        try {conn.close();} catch (SQLException se){}
        
    }
    return returnValue;
  }


}
