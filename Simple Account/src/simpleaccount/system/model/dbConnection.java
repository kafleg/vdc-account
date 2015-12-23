
package simpleaccount.system.model;
import java.sql.*;
public class dbConnection {
  static Connection conn = null;
  static Statement stmt = null;
    
  
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/simple_acc";

  
   static final String USER = "root";
   static final String PASS = "";
    public static  void connectionOpen()
    {
        try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception ex)
        {
        System.out.println(ex.toString());
        }
    
    
    }
    public static ResultSet getData(String txtSql)
    {
        try{
            connectionOpen();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(txtSql);
        return rs;
         }
        catch(Exception ex)
        {
        System.out.println(ex.toString());
        return null;
        }
    }
    public static void runQuery(String txtSql)
    {
    try{
        connectionOpen();
        stmt = conn.createStatement();
        stmt.executeUpdate(txtSql);
         }
        catch(Exception ex)
        {
        System.out.println(ex.toString());
        
        }
    }
    public static int getRowCount(String txtSql)
    {
     try{
        connectionOpen();
        stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery(txtSql);
        int count=0;
        while(rs.next())
        {
        count++;
        }
        return count;
         }
        catch(Exception ex)
        {
        System.out.println(ex.toString());
        return 0;
        }
    
    }
   
}
