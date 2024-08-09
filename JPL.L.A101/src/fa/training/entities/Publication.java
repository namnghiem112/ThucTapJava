package fa.training.entities;

import java.time.LocalDate;

public abstract class Publication {
    private int publicationYear;
    private String publisher;
    private LocalDate publicationDate;

    public Publication(int publicationYear, String publisher, LocalDate publicationDate) {
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public abstract void display();
}
