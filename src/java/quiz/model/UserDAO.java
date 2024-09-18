package quiz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quiz.db.DbConnection;
import quiz.pojo.UserPojo;

public class UserDAO {

    public static boolean registerUser(UserPojo user) {
        Connection con = DbConnection.getConnection();
        PreparedStatement ps = null;
        boolean status = false;

        try {
            String query = "INSERT INTO regis  VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            
            // Set the parameters for the prepared statement
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUpass());
       
            ps.setString(3, user.getEmail());
            
            // Execute the update
            int rowsAffected = ps.executeUpdate();
            
            // If at least one row is inserted, registration is successful
            if (rowsAffected != 0) {
                status = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) ps.close();
                DbConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return status;
    }
     public static boolean validateUser(UserPojo user) 
     {
         Connection con = DbConnection.getConnection();
        PreparedStatement ps = null;
        boolean status = false;

        try {
            String query = "select * from regis where UNAME=? and  UPASS=?";
            ps = con.prepareStatement(query);
            
            // Set the parameters for the prepared statement
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUpass());
       
           
            
            // Execute the update
            ResultSet rs = ps.executeQuery();
            
            // If at least one row is inserted, registration is successful
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (ps != null) ps.close();
                DbConnection.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return status;
     }
     
}
