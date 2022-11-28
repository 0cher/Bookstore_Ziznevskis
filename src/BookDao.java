import java.util.List;

public interface BookDao {

    List<Book> findAll();
    Book createBook(Book book);
    Book findByISBN(String isbn);
    Book findById(Long id);
    void updateBook(String bookIsbn, Book book);
    boolean deleteBook (String bookIsbn);


}
