package quiz.db;
import java.sql.*;
public class DbConnection 
{
    private static Connection con;
    private static String uname="root";
    private static String pass="0000";
    private static String url="jdbc:mysql:///quiz?useSSL=false&allowPublicKeyRetrieval=true";
     static
        {
          try
            {
             Class.forName("com.mysql.cj.jdbc.Driver");
            }
           catch(Exception e)
            {
                System.out.println(e);
            }
          
        }
    
    public static  Connection getConnection() 
    {
       
       
        
           
               try
               {
                con=DriverManager.getConnection(url,uname,pass);
                return con;
               }
            catch(Exception e)
            {
                System.out.println(e);
            }
        
                
            return con;
        
        
    }
    public static void closeConnection()
    {
        if(con==null)
        {
            try
            {
            con.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    
    
    
}
