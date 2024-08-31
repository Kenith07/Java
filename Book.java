import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: $" + price;
    }
}

class BookStore {
    private List<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author, double price) {
        try {
            if (title == null || author == null || price < 0) {
                throw new IllegalArgumentException("Invalid book details provided.");
            }
            Book newBook = new Book(title, author, price);
            books.add(newBook);
            System.out.println("Book added successfully: " + newBook);
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding book: " + e.getMessage());
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the store.");
        } else {
            System.out.println("Available books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class OnlineBookStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore bookStore = new BookStore();

        while (true) {
            System.out.println("Welcome to the Online Book Store!");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book price: ");
                    double price;
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid price. Please enter a valid number.");
                        continue;
                    }
                    bookStore.addBook(title, author, price);
                    break;
                case 2:
                    bookStore.listBooks();
                    break;
                case 3:
                    System.out.println("Exiting the application. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.err.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
