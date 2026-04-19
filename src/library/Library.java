package library;

import  java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Library {

    // List to store books

    private List <Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Remove a book by title
    public void removeBook(String title) {
        for(Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book removed: " + title);
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    // Search books by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for author: " + author);
        }
    }

    // Display all books
    public  void displayAll() {
        if  (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        System.out.println("--- All Books ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Get number of books
    public int getTotalBooks() {
        return books.size();
    }

    // Save all books to a CSV file
    public void saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Book book : books) {
                writer.write(book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.getYear() + "," +
                        book.isAvailable() + "\n");
            }
            writer.close();
            System.out.println("Library saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load books from a CSV file
    public void loadFromFile(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("No saved library found, starting fresh.");
                return;
            }
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                Book book = new Book(parts[0], parts[1], Integer.parseInt(parts[2]));
                book.setAvailable(Boolean.parseBoolean(parts[3]));
                books.add(book);
            }
            fileScanner.close();
            System.out.println("Library loaded from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

} // class Library closed

/* * key concepts used
*
* ArrayList<Book> → our dynamic list of Book objects
* equalsIgnoreCase() → compares strings ignoring uppercase/lowercase — so "tolkien" finds "Tolkien"
* return inside removeBook() → stops the loop immediately once the book is found, avoids errors
* isEmpty() → clean check before trying to display an empty list
* */
