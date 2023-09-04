package com.bookutil;
import com.book.Book;
import com.book.BookStore;
import com.book.InvalidBookException;
import java.util.Scanner;

public class BookUtil {

    public static void main(String[] args) throws InvalidBookException {

        BookStore store = new BookStore();
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<2; i++){
            try {
                System.out.print("Enter Book ID : ");
                String bookID = sc.nextLine();

                System.out.print("Enter Book Title : ");
                String title = sc.nextLine();

                System.out.print("Enter Author name : ");
                String author = sc.nextLine();

                System.out.print("Enter category: \"Science\", \"Fiction\", \"Technology\" or \"Others\" : ");
                String category = sc.nextLine();

                System.out.print("Enter Price : ");
                double price = sc.nextDouble();

                sc.nextLine();

                Book book = new Book(bookID, title, author, category, price);
                store.addBook(book);
            }
            catch (Exception ex){
                System.out.println("Invalid from main");
                throw new InvalidBookException("InvalidBookException");
            }
        }

        System.out.println();
        store.searchByAuthor("Steven Hawking");
        System.out.println();
        store.searchByTitle("Brief History of Time");
        System.out.println();
        System.out.println("Books Available are : ");
        store.displayAll();
    }
}