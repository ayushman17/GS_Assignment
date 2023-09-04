package com.book;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BookStore {

    private static String url = "jdbc:mysql://localhost:3306/assignment";

    //    To add a new book object into books table
    public boolean addBook(Book b) throws InvalidBookException {
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "");
             PreparedStatement pst = con.prepareStatement("insert into books values(?,?,?,?,?)") ){
            pst.setString(1, b.getBookId());
            pst.setString(2,b.getTitle());
            pst.setString(3,b.getAuthor());
            pst.setString(4,b.getCategory());
            pst.setDouble(5,b.getPrice());
            count = pst.executeUpdate();
        }
        catch (Exception ex){
            System.out.println("Invalid from addBook");
            throw new InvalidBookException("InvalidBookException");
        }
        return count==1;
    }

    //    Search a book based onn title
    public Book searchByTitle(String title) throws InvalidBookException {
        Book book = null;
        try (Connection con = DriverManager.getConnection(url,"root","");
             PreparedStatement pst = con.prepareStatement("select * from books where title = ?")){
            pst.setString(1,title);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                book = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
        }
        catch (Exception ex){
            System.out.println("Invalid from searchByTitle");
            throw new InvalidBookException("InvalidBookException");
        }
        return book;
    }

    //    Search book based on author
    public ArrayList<Book> searchByAuthor(String author) throws InvalidBookException {
        ArrayList<Book> bookList = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,"root","");
            PreparedStatement pst = con.prepareStatement("select * from books where author = ?")){
            pst.setString(1,author);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                bookList.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
        }catch(Exception ex){
            System.out.println("Invalid from searchByAuthor");
            throw new InvalidBookException("InvalidBookException");
        }
        return bookList;
    }

    //    To print the details of the book
    public void displayAll() throws InvalidBookException {

        try (Connection con = DriverManager.getConnection(url, "root", "");
             PreparedStatement pst = con.prepareStatement("select * from books");) {
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                System.out.println(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
        }
        catch (Exception ex){
            System.out.println("Invalid from displayAll");
            throw new InvalidBookException("InvalidBookException");
        }

    }

}
