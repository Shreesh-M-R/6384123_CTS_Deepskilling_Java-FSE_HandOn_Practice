package com.mycompany.librarysystem;

import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(bookId + " | " + title + " | " + author);
    }
}

public class LibrarySystem {
    static ArrayList<Book> bookList = new ArrayList<>();

    static void addBook(int id, String title, String author) {
        bookList.add(new Book(id, title, author));
        System.out.println("Book added.");
    }

    static void linearSearch(String title) {
        boolean found = false;
        for (Book b : bookList) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book found (Linear Search):");
                b.display();
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Book not found (Linear Search).");
    }

    static void binarySearch(String title) {
        List<Book> sortedList = new ArrayList<>(bookList);
        sortedList.sort(Comparator.comparing(b -> b.title.toLowerCase()));

        int low = 0, high = sortedList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sortedList.get(mid).title.compareToIgnoreCase(title);

            if (cmp == 0) {
                System.out.println("Book found (Binary Search):");
                sortedList.get(mid).display();
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found (Binary Search).");
    }

    static void viewBooks() {
        if (bookList.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Book List:");
        for (Book b : bookList)
            b.display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book (Linear)");
            System.out.println("4. Search Book (Binary)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    addBook(id, title, author);
                }
                case 2 -> viewBooks();

                case 3 -> {
                    System.out.print("Enter title to search : ");
                    String title = sc.nextLine();
                    linearSearch(title);
                }

                case 4 -> {
                    System.out.print("Enter title to search : ");
                    String title = sc.nextLine();
                    binarySearch(title);
                }

                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}



