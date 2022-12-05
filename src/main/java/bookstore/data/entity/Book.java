package bookstore.data.entity;

import java.util.Objects;
public class Book {
    Long id;
    private String bookAuthor;
    private String bookName;
    private String isbn;
    private Money price;

    public Book() {
    }
    public Book(String bookAuthor, String bookName, String isbn) {
        this.bookAuthor = bookAuthor;
        this.bookName = bookName;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book.Book{" +
                "id=" + id +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(bookAuthor, book.bookAuthor) && Objects.equals(bookName, book.bookName) && Objects.equals(isbn, book.isbn);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, bookAuthor, bookName, isbn);
    }
}
