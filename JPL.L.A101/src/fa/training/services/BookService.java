package fa.training.services;

import fa.training.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addAuthor(Book book, String author) {
        if (book.getAuthors().contains(author)) {
            System.out.println("Author existed");
        } else {
            book.getAuthors().add(author);
            System.out.println("Add successfully");
        }
    }

    public Book searchBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    // Search books by author
    public List<Book> searchBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthors().contains(author))
                .collect(Collectors.toList());
    }

    // Search books by publisher
    public List<Book> searchBooksByPublisher(String publisher) {
        return books.stream()
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }
}
