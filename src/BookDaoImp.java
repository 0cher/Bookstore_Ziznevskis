import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class BookDaoImp implements BookDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/bookstore_bh";
    private static final String useName = "postgres";
    private static final String PASSWORD = "root";
    private static final String FIND_ALL = "SELECT * FROM books";
    private static final String FIND_ByIsbn = "SELECT * FROM books WHERE isbn = ?";
    private static final String FIND_ById = "SELECT * FROM books WHERE id = ?";
    private static final String CREATE_BOOK = "INSERT INTO books (bookAuthor, bookName, isbn) VALUES(?, ?, ?);";
    private static final String UPDATE_BOOK = "UPDATE books SET bookAuthor = ?, bookName = ?, isbn = ? WHERE isbn = ?";
    private static final String DELETE_ByISBN = "DELETE FROM books WHERE isbn = ?";
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL,useName, PASSWORD);) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                Book book = new Book();
                book.setBookAuthor(resultSet.getString("bookAuthor"));
                book.setBookName(resultSet.getString("bookName"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setId(resultSet.getLong("id"));
                books.add(book);
            }
        }catch (SQLException e){
            // e.printStackTrace();
            System.out.println(e);
        }
        return books;
    }
    @Override
    public Book createBook(Book book) {
        boolean check = false;
        if (findByISBN(book.getIsbn())==null){
        try (Connection connection = DriverManager.getConnection(URL,useName, PASSWORD);) {
            PreparedStatement statement = connection.prepareStatement(CREATE_BOOK);
            statement.setString(1,book.getBookAuthor());
            statement.setString(2,book.getBookName());
            statement.setString(3,book.getIsbn());
            statement.executeUpdate();

            book.setId(findByISBN(book.getIsbn()).getId());
            check = true;

        }catch (SQLException e){
            // e.printStackTrace();
            System.out.println(e);
        }
        }if (!check){
            System.out.println("Такой раздел с книгами уже существует");
            book.setId(findByISBN(book.getIsbn()).getId());
        }
        return book;
    }
    @Override
    public Book findByISBN(String isbn) {
        Book book = null;
        try (Connection connection = DriverManager.getConnection(URL,useName, PASSWORD);) {
            PreparedStatement statement = connection.prepareStatement(FIND_ByIsbn);
            statement.setString(1,isbn);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                book = new Book();
                book.setBookAuthor(resultSet.getString("bookAuthor"));
                book.setBookName(resultSet.getString("bookName"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setId(resultSet.getLong("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return book;
    }
    @Override
    public Book findById(Long id) {
        Book book = null;
        try (Connection connection = DriverManager.getConnection(URL,useName, PASSWORD);) {
            PreparedStatement statement = connection.prepareStatement(FIND_ById);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                book = new Book();
                book.setBookAuthor(resultSet.getString("bookAuthor"));
                book.setBookName(resultSet.getString("bookName"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setId(resultSet.getLong("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }
        return book;
    }
    @Override
    public void updateBook(String bookIsbn, Book book) {
        if (findByISBN(bookIsbn)!=null&&Objects.equals(bookIsbn, book.getIsbn())){
            try (Connection connection = DriverManager.getConnection(URL,useName, PASSWORD);) {
                PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
                statement.setString(1,book.getBookAuthor());
                statement.setString(2,book.getBookName());
                statement.setString(3,book.getIsbn());
                statement.setString(4,bookIsbn);
                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println(e);
            }
        }
        if (findByISBN(bookIsbn)!=null&&!Objects.equals(bookIsbn, book.getIsbn())&&findByISBN(book.getIsbn())==null){
            try (Connection connection = DriverManager.getConnection(URL,useName, PASSWORD);) {
                PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
                statement.setString(1,book.getBookAuthor());
                statement.setString(2,book.getBookName());
                statement.setString(3,book.getIsbn());
                statement.setString(4,bookIsbn);
                statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println(e);
            }
        }
    }
    @Override
    public boolean deleteBook(String bookIsbn) {
        boolean remove = false;
        if (findByISBN(bookIsbn)!=null){
            try (Connection connection = DriverManager.getConnection(URL,useName, PASSWORD);) {
                PreparedStatement statement = connection.prepareStatement(DELETE_ByISBN);
                statement.setString(1,bookIsbn);
                remove = !statement.execute();
                System.out.println("Запись удалена");
            }catch (SQLException e){
                e.printStackTrace();
                // System.out.println(e);
            }
        }
        return remove;
    }
}
