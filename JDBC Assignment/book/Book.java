package com.book;
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private double price;
    public Book(){}
    public Book(String bookId, String title, String author, String category, double price){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}