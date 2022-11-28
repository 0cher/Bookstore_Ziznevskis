
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookDao bookDao = new BookDaoImp();
        List<Book> books = bookDao.findAll();
        books.forEach(System.out::println);

        System.out.println(bookDao.findById(2L));
        System.out.println(bookDao.findByISBN("01234"));

        System.out.println(bookDao.createBook(new Book("NoName", "bookNoName", "0121212" )));
        bookDao.updateBook("0121212",new Book("NoName", "bookNoName", "445544" ));
        System.out.println(bookDao.findByISBN("0121212"));
        System.out.println(bookDao.findByISBN("445544"));
        System.out.println(bookDao.findByISBN("0121212"));

        bookDao.deleteBook("445544");
        books = bookDao.findAll();
        books.forEach(System.out::println);

    }
}
