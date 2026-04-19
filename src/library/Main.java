package library;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        library.loadFromFile("library.csv");

        if (library.getTotalBooks() == 0) {
            // Add few books to start off
            library.addBook(new Book("The Hobbit", "Tolkien", 1937));
            library.addBook(new Book("1984", "Orwell", 1949));
            library.addBook(new Book("Clean Code", "Martin", 2008));
        }


        while (choice != 5) {
            System.out.println("\n-- Library Menu --");
            System.out.println("1. Display all books");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Search by author");
            System.out.println("5. Exit");
            System.out.println("Your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    library.displayAll();
                    break;
                case 2:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new Book (title, author, year));
                    break;
                case 3:
                    System.out.print("Enter title to be removed: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;
                case 4:
                    System.out.print("Enter author name: ");
                    String searchAuthor = scanner.nextLine();
                    library.searchByAuthor(searchAuthor);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            } // switch closed
        } // while closed

        library.saveToFile("library.csv");

        scanner.close();

    } // main is now closed

} // class Main is closed

/* * Key concepts used
* load
* Scanner → reads input from the keyboard
* while (choice != 5) → keeps the menu running until the user exits
* switch → cleaner than a chain of if/else for menu options
* scanner.nextLine() after nextInt() → clears the buffer, prevents input bugs
 *
 */
