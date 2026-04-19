package library;

public class Book {

    //attributes
    private String title;
    private String author;
    private int year;
    private boolean available;

    // Constructor

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true; // every new book is available by default
    }

    // Getters
    public String getTitle()       { return title; }
    public String getAuthor()      { return author; }
    public int getYear()           { return year; }
    public boolean isAvailable()   { return available; }

    // Setter for availability only
    public void setAvailable(boolean available) {
        this.available = available;

    } // Book closed

    // Readable String representation
    @Override
    public String toString() {
        return "[" +title + "] by " + author +
                " (" + year + ") - " +
                (available ? "Available" : "Not available");
    }

}
