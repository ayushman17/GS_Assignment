package org.example;

import java.sql.*;
import java.util.ArrayList;

class OrderedProductsDAO {
    private static String url = "jdbc:mysql://localhost:3306/java_test";

    public void displayOrderedProductById(int productId) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            pst = con.prepareStatement("SELECT p.prod_name, p.prod_price, o.order_date FROM product p JOIN ordered_products op ON p.prod_id = op.prod_id JOIN orders o ON op.order_id = o.order_id where p.prod_id =?;");
            pst.setInt(1, productId);
            rs = pst.executeQuery();
            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void displayOrderedProductsByOrderDate(String orderDate) {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            pst = con.prepareStatement("SELECT p.prod_name, p.prod_price, o.order_date FROM product p JOIN ordered_products op ON p.prod_id = op.prod_id JOIN orders o ON op.order_id = o.order_id where o.order_date=?");
            pst.setString(1, orderDate);
            rs = pst.executeQuery();
            while (rs.next())
                System.out.println("prod_name:"+rs.getString(1) + " " +"prod_price :"+ rs.getString(2) + " order_date :" + rs.getString(3));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
}}}

