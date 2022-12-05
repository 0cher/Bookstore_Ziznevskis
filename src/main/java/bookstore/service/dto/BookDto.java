package bookstore.service.dto;

import bookstore.data.entity.Money;


import java.util.Objects;

public class BookDto {
    Long id;
    private String bookAuthor;
    private String bookName;
    private String isbn;
    private Money price;

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

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto bookDto)) return false;
        return Objects.equals(id, bookDto.id) && Objects.equals(bookAuthor, bookDto.bookAuthor) && Objects.equals(bookName, bookDto.bookName) && Objects.equals(isbn, bookDto.isbn) && Objects.equals(price, bookDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookAuthor, bookName, isbn, price);
    }
}


