package bookstore.controller.command;

import bookstore.data.dao.BookDao;
import bookstore.data.entity.Book;
import jakarta.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BookCommand implements Command {
    private final BookDao bookDao;
    public BookCommand(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public String execute(HttpServletRequest req) {
        String str = req.getParameter("id");
        String strPattern = "\\d+";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            Long idL = Long.parseLong(str);
            Book book = bookDao.findById(idL);
            req.setAttribute("book", book);
            if (book==null){
                 return "jsp/error.jsp";
            }
            return "jsp/book.jsp";
        }
        else {
            return "jsp/error.jsp";
        }
    }
}
