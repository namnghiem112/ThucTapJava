package fa.training.main;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.utils.InputValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        MagazineService magazineService = new MagazineService();

        while (true) {
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 of magazines by volume");
            System.out.println("6. Search book by (isbn, author, publisher)");
            System.out.println("Please choose function you'd like to do: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter publication year: ");
                    String yearStr = scanner.nextLine();
                    while (!InputValidator.isValidInteger(yearStr)) {
                        System.out.println("Invalid year. Enter again: ");
                        yearStr = scanner.nextLine();
                    }
                    int year = Integer.parseInt(yearStr);

                    System.out.println("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    while (!InputValidator.isValidString(publisher)) {
                        System.out.println("Invalid publisher. Enter again: ");
                        publisher = scanner.nextLine();
                    }

                    System.out.println("Enter publication date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    while (!InputValidator.isValidDate(date)) {
                        System.out.println("Invalid date. Enter again: ");
                        date = scanner.nextLine();
                    }
                    LocalDate publicationDate = LocalDate.parse(date);

                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    while (!InputValidator.isValidIsbn(isbn)) {
                        System.out.println("Invalid ISBN. Enter again: ");
                        isbn = scanner.nextLine();
                    }

                    System.out.println("Enter publication place: ");
                    String place = scanner.nextLine();
                    while (!InputValidator.isValidString(place)) {
                        System.out.println("Invalid place. Enter again: ");
                        place = scanner.nextLine();
                    }

                    Book book = new Book(year, publisher, publicationDate, isbn, place);
                    bookService.addBook(book);
                    break;

                case 2:
                    System.out.println("Enter publication year: ");
                    yearStr = scanner.nextLine();
                    while (!InputValidator.isValidInteger(yearStr)) {
                        System.out.println("Invalid year. Enter again: ");
                        yearStr = scanner.nextLine();
                    }
                    year = Integer.parseInt(yearStr);

                    System.out.println("Enter publisher: ");
                    publisher = scanner.nextLine();
                    while (!InputValidator.isValidString(publisher)) {
                        System.out.println("Invalid publisher. Enter again: ");
                        publisher = scanner.nextLine();
                    }

                    System.out.println("Enter publication date (YYYY-MM-DD): ");
                    date = scanner.nextLine();
                    while (!InputValidator.isValidDate(date)) {
                        System.out.println("Invalid date. Enter again: ");
                        date = scanner.nextLine();
                    }
                    publicationDate = LocalDate.parse(date);

                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    while (!InputValidator.isValidString(author)) {
                        System.out.println("Invalid author. Enter again: ");
                        author = scanner.nextLine();
                    }

                    System.out.println("Enter volume: ");
                    String volumeStr = scanner.nextLine();
                    while (!InputValidator.isValidInteger(volumeStr)) {
                        System.out.println("Invalid volume. Enter again: ");
                        volumeStr = scanner.nextLine();
                    }
                    int volume = Integer.parseInt(volumeStr);

                    System.out.println("Enter edition: ");
                    String editionStr = scanner.nextLine();
                    while (!InputValidator.isValidInteger(editionStr)) {
                        System.out.println("Invalid edition. Enter again: ");
                        editionStr = scanner.nextLine();
                    }
                    int edition = Integer.parseInt(editionStr);

                    Magazine magazine = new Magazine(year, publisher, publicationDate, author, volume, edition);
                    magazineService.addMagazine(magazine);
                    break;

                case 3:
                    System.out.println("Enter publication year: ");
                    yearStr = scanner.nextLine();
                    while (!InputValidator.isValidInteger(yearStr)) {
                        System.out.println("Invalid year. Enter again: ");
                        yearStr = scanner.nextLine();
                    }
                    year = Integer.parseInt(yearStr);

                    System.out.println("Enter publisher: ");
                    publisher = scanner.nextLine();
                    while (!InputValidator.isValidString(publisher)) {
                        System.out.println("Invalid publisher. Enter again: ");
                        publisher = scanner.nextLine();
                    }

                    for (Book b : bookService.getBooks()) {
                        if (b.getPublicationYear() == year && b.getPublisher().equals(publisher)) {
                            b.display();
                        }
                    }
                    for (Magazine m : magazineService.getMagazines()) {
                        if (m.getPublicationYear() == year && m.getPublisher().equals(publisher)) {
                            m.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter ISBN of the book: ");
                    isbn = scanner.nextLine();
                    while (!InputValidator.isValidIsbn(isbn)) {
                        System.out.println("Invalid ISBN. Enter again: ");
                        isbn = scanner.nextLine();
                    }

                    System.out.println("Enter author: ");
                    author = scanner.nextLine();
                    while (!InputValidator.isValidString(author)) {
                        System.out.println("Invalid author. Enter again: ");
                        author = scanner.nextLine();
                    }

                    Book b = bookService.searchBookByIsbn(isbn);
                    if (b != null) {
                        bookService.addAuthor(b, author);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.println("Top 10 Magazines by Volume:");
                    for (Magazine m : magazineService.getTop10MagazinesByVolume()) {
                        m.display();
                    }
                    break;

                case 6:
                    System.out.println("Search book by:");
                    System.out.println("1. ISBN");
                    System.out.println("2. Author");
                    System.out.println("3. Publisher");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (searchChoice) {
                        case 1:
                            System.out.println("Enter ISBN: ");
                            String searchIsbn = scanner.nextLine();
                            while (!InputValidator.isValidIsbn(searchIsbn)) {
                                System.out.println("Invalid ISBN. Enter again: ");
                                searchIsbn = scanner.nextLine();
                            }
                            Book b1 = bookService.searchBookByIsbn(searchIsbn);
                            if (b1 != null) {
                                b1.display();
                            } else {
                                System.out.println("Book not found.");
                            }
                            break;
                        case 2:
                            System.out.println("Enter author name: ");
                            String author1 = scanner.nextLine();
                            while (!InputValidator.isValidString(author1)) {
                                System.out.println("Invalid author. Enter again: ");
                                author1 = scanner.nextLine();
                            }
                            List<Book> booksByAuthor = bookService.searchBooksByAuthor(author1);
                            if (booksByAuthor.isEmpty()) {
                                System.out.println("No books found by author: " + author1);
                            } else {
                                System.out.println("Books by author: " + author1);
                                booksByAuthor.forEach(System.out::println);
                            }
                            break;
                        case 3:
                            System.out.println("Enter publisher name: ");
                            String publisherName = scanner.nextLine();
                            while (!InputValidator.isValidString(publisherName)) {
                                System.out.println("Invalid publisher. Enter again: ");
                                publisherName = scanner.nextLine();
                            }
                            List<Book> booksByPublisher = bookService.searchBooksByPublisher(publisherName);
                            if (booksByPublisher.isEmpty()) {
                                System.out.println("No books found by publisher: " + publisherName);
                            } else {
                                System.out.println("Books by publisher: " + publisherName);
                                booksByPublisher.forEach(System.out::println);
                            }
                            break;
                        default:
                            System.out.println("Invalid search type.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
