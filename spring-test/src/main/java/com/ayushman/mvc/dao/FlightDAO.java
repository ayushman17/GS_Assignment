package com.ayushman.mvc.dao;

import com.ayushman.mvc.entity.Flight;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class FlightDAO {
    private static String url = "jdbc:mysql://localhost:3306/jsp";
    public ArrayList<Flight> searchFlight(String source, String destination) {
        ArrayList<Flight> flights=new ArrayList<>();
        Flight flg = null;
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            pst = con.prepareStatement("select * from flights where source=? and destination=?");
            pst.setString(1,source);
            pst.setString(2,destination);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
                flights.add(new Flight(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getDouble(5)));
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return flights;
    }
}