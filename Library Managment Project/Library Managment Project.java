import java.util.*;

class Book {
    String title, author, id;
    boolean isBorrowed;

    Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }
}

class User {
    String name, userId;
    List<Book> borrowedBooks = new ArrayList<>();

    User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

public class LibrarySystem {
    static Map<String, Book> books = new HashMap<>();
    static Map<String, User> users = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\\n1. Add Book\\n2. Register User\\n3. Borrow Book\\n4. Return Book\\n5. View Books\\n6. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": addBook(); break;
                case "2": registerUser(); break;
                case "3": borrowBook(); break;
                case "4": returnBook(); break;
                case "5": viewBooks(); break;
                case "6": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter book ID: "); String id = scanner.nextLine();
        System.out.print("Enter title: "); String title = scanner.nextLine();
        System.out.print("Enter author: "); String author = scanner.nextLine();
        books.put(id, new Book(id, title, author));
        System.out.println("Book added.");
    }

    static void registerUser() {
        System.out.print("Enter user ID: "); String id = scanner.nextLine();
        System.out.print("Enter name: "); String name = scanner.nextLine();
        users.put(id, new User(id, name));
        System.out.println("User registered.");
    }

    static void borrowBook() {
        System.out.print("User ID: "); String userId = scanner.nextLine();
        System.out.print("Book ID: "); String bookId = scanner.nextLine();
        if (!books.containsKey(bookId) || books.get(bookId).isBorrowed) {
            System.out.println("Book unavailable.");
            return;
        }
        users.get(userId).borrowedBooks.add(books.get(bookId));
        books.get(bookId).isBorrowed = true;
        System.out.println("Book borrowed.");
    }

    static void returnBook() {
        System.out.print("User ID: "); String userId = scanner.nextLine();
        System.out.print("Book ID: "); String bookId = scanner.nextLine();
        if (users.containsKey(userId)) {
            users.get(userId).borrowedBooks.removeIf(b -> b.id.equals(bookId));
            books.get(bookId).isBorrowed = false;
            System.out.println("Book returned.");
        }
    }

    static void viewBooks() {
        for (Book b : books.values()) {
            System.out.printf("%s: %s by %s [%s]\\n", b.id, b.title, b.author, b.isBorrowed ? "Borrowed" : "Available");
        }
    }
}
