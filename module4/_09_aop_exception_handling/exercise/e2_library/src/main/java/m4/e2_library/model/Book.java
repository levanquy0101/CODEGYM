package m4.e2_library.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition="CHAR(150)", nullable = false)
    private String title;

    @Column(columnDefinition="TEXT")
    private String preface;

    private String author;

    @Column(name = "published_on")
    private LocalDate publishedOn;

    @Column(name = "img_url")
    private String imgUrl;

    private int quantity = 1;


    public Book() {
    }

    public Book(int id, String title, String preface, String author, LocalDate publishedOn, String imgUrl, int quantity) {
        this.id = id;
        this.title = title;
        this.preface = preface;
        this.author = author;
        this.publishedOn = publishedOn;
        this.imgUrl = imgUrl;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
