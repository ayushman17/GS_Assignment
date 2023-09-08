package com.ayushman.mvc.dao;
import com.ayushman.mvc.entity.User;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserDAO {
    private static String url = "jdbc:mysql://localhost:3306/jsp";
    public boolean validateUser(User user)
    {
        int count=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement pst = con.prepareStatement("select count(*) from users where username = ? and password = ?");

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                count = rs.getInt(1);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return count==1;
    }
}