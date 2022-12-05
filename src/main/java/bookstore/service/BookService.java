package bookstore.service;



import bookstore.service.dto.BookDto;

import java.util.List;
public interface BookService {
    List<BookDto> getAll();
    BookDto createBook(BookDto book);
    BookDto getByISBN(String isbn);
    BookDto getById(Long id);
    void updateBook(String bookIsbn, BookDto book);
    void deleteBook (String bookIsbn);

}
