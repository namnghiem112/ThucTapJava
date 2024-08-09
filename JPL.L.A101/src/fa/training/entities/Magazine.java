package fa.training.entities;

import java.time.LocalDate;

public class Magazine extends Publication {
    private String author;
    private int volume;
    private int edition;

    public Magazine(int publicationYear, String publisher, LocalDate publicationDate, String author, int volume, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volume = volume;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public int getVolume() {
        return volume;
    }

    public int getEdition() {
        return edition;
    }

    @Override
    public void display() {
        System.out.println("Magazine: ");
        System.out.println("Author: " + author);
        System.out.println("Volume: " + volume);
        System.out.println("Edition: " + edition);
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Publication Date: " + getPublicationDate());
    }
}
