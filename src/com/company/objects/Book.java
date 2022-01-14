package com.company.objects;

public class Book {
    // The Maze Runner, 978-1908435132, James Dashner, Science Fiction
    private String title;
    private String ISBN;
    private String author;
    private String genre;

    public Book(String title, String ISBN, String author, String genre) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
