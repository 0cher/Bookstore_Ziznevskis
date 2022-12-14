package bookstore.controller.command;

import bookstore.data.dao.BookDao;
import bookstore.data.entity.Book;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class BooksCommand implements Command {
    private final BookDao bookDao;
    public BooksCommand(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public String execute(HttpServletRequest req){
        List <Book> books = bookDao.findAll();
        req.setAttribute("books", books);
        return "jsp/books.jsp";

    }

}
