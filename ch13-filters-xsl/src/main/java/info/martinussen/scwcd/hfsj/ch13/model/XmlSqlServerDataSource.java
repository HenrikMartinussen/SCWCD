package info.martinussen.scwcd.hfsj.ch13.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class XmlSqlServerDataSource implements XmlDataSource {
  
  private static Logger log = Logger.getLogger(XmlSqlServerDataSource.class);
  
  private String db_connect_string = "jdbc:jtds:sqlserver://localhost:1433/myDatabase";
  private String db_userid = "JamesBond";
  private String db_password = "mi$$moneypenny";
  
  static {
    log.trace("XmlSqlServerDataSource loaded");
    try {
      Class.forName("net.sourceforge.jtds.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      String message = "JDBC driver class not found";
      log.fatal(message);
      throw new IllegalStateException(e);
    }
  }

  public XmlSqlServerDataSource(){
    log.trace("XmlSqlServerDataSource constructed");
  }

  public String getXmlData() {
    String query = "select \n" + 
        "b.Category as \"@category\",\n" +
        "b.Title as title\n," +
        "b.Author as author\n," +
        "b.Year as year,\n" +
        "b.Price as price\n" +
        "from Book b\n" + 
        "for xml path ('book'), root ('bookstore');";
    String returnValue = null;
    
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    
    try {
      conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
      st = conn.createStatement();
      rs = st.executeQuery(query);
      if (rs.next()){
        returnValue = rs.getString(1);
      }
    } catch (SQLException e) {
      String message = "Exception caught while trying to connect to database";
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
