package com.ayushman.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.ayushman.mvc.entity.Flight;
import com.ayushman.mvc.entity.Passengers;
import org.springframework.stereotype.Repository;

@Repository
public class BookingsDAO
{
    private static String url ="jdbc:mysql://localhost:3306/testing";

    public boolean bookTicket(String bookingId, String flightId, String passengerId)
    {

        Connection con = null;
        PreparedStatement pst = null;
        int count = 0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","rootuser1");
            pst = con.prepareStatement(" insert into bookings values(?,?,?,sysdate())");
            pst.setString(1, bookingId);
            pst.setString(2, flightId);
            pst.setString(3, passengerId);
            count = pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return count == 1;
    }

    public boolean addPassenger(String passengerId, String firstName, String lastName, long mobile,String email)
    {

        Connection con = null;
        PreparedStatement pst = null;
        int count = 0;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            pst = con.prepareStatement(" insert into passengers values(?,?,?,?,?)");
            pst.setString(1, passengerId);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setLong(4, mobile);
            pst.setString(5, email);

            count = pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return count == 1;
    }

    public Flight searchFlightById(String flightId)
    {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs =  null;
        Flight f = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            pst = con.prepareStatement("select * from flights where flight_id=?");
            pst.setString(1, flightId);
            rs = pst.executeQuery();
            if(rs.next())
            {
                f =new Flight(rs.getString(1), rs.getInt(5), rs.getString(2), rs.getString(3), rs.getDouble(4));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs!=null) rs.close();
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return f;
    }

    public Passengers searchPassengerById(String passengerId)
    {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs =  null;
        Passengers p = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            pst = con.prepareStatement("select * from passengers where passenger_id=?");
            pst.setString(1, passengerId);
            rs = pst.executeQuery();
            if(rs.next())
            {
                p =new Passengers(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs!=null) rs.close();
                if(pst!=null) pst.close();
                if(con!=null) con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return p;
    }

    public boolean checkSeatsAvailable(String flightId)
    {

        Connection con = null;
        PreparedStatement pst = null;
        int count = 0;
        int value = 0;
        ResultSet rs =null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            pst = con.prepareStatement(" select seats_available from flights where flight_id=?");
            pst.setString(1, flightId);
            rs = pst.executeQuery();
            if(rs.next())
                value = rs.getInt(1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
                if(rs!=null) con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return value > 0;
    }

    public boolean updateSeats(String flightId)
    {

        Connection con = null;
        PreparedStatement pst = null;
        int count = 0;
        ResultSet rs =null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            pst = con.prepareStatement(" update flights set seats_available=seats_available-1 where flight_id=?");
            pst.setString(1, flightId);
            count = pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(pst!=null) pst.close();
                if(con!=null) con.close();
                if(rs!=null) con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return count == 1;
    }
}