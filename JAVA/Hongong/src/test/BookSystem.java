package test;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

public class BookSystem {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Management System");
            System.out.println("1. Add a book");
            System.out.println("2. List all books");
            System.out.println("3. Search for a book");
            System.out.println("4. Remove a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author's name: ");
                    String author = scanner.nextLine();
                    library.add(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("List of Books:");
                    for (Book book : library) {
                        System.out.println(book);
                    }
                    break;

                case 3:
                    System.out.print("Enter the title to search for: ");
                    String searchTitle = scanner.nextLine();
                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                            System.out.println("Book found: " + book);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = scanner.nextLine();
                    for (Book book : library) {
                        if (book.getTitle().equalsIgnoreCase(removeTitle)) {
                            library.remove(book);
                            System.out.println("Book removed successfully!");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
