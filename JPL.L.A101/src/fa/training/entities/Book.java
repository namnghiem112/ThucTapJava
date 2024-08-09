package fa.training.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Book extends Publication {
    private String isbn;
    private Set<String> authors;
    private String publicationPlace;

    public Book(int publicationYear, String publisher, LocalDate publicationDate, String isbn, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.authors = new HashSet<>();
        this.publicationPlace = publicationPlace;
    }

    public String getIsbn() {
        return isbn;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    @Override
    public void display() {
        System.out.println("Book: ");
        System.out.println("ISBN: " + isbn);
        System.out.println("Authors: " + authors);
        System.out.println("Publication Place: " + publicationPlace);
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Publication Date: " + getPublicationDate());
    }
}
