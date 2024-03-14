package m4.e2_library.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime takenDate;

    private LocalDateTime broughtDate;

    public Borrow() {
    }

    public Borrow(int id, String code, Book book, User user, LocalDateTime takenDate, LocalDateTime broughtDate) {
        this.id = id;
        this.code = code;
        this.book = book;
        this.user = user;
        this.takenDate = takenDate;
        this.broughtDate = broughtDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(LocalDateTime takenDate) {
        this.takenDate = takenDate;
    }

    public LocalDateTime getBroughtDate() {
        return broughtDate;
    }

    public void setBroughtDate(LocalDateTime broughtDate) {
        this.broughtDate = broughtDate;
    }
}
