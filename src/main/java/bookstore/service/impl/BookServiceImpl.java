package bookstore.service.impl;

import bookstore.data.dao.BookDao;
import bookstore.data.entity.Book;
import bookstore.service.BookService;
import bookstore.service.dto.BookDto;


import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookDto> getAll() {
        return bookDao.findAll().stream().map(this::toDto).toList();
//        List<Book> books = bookDao.findAll();
//        List<BookDto> bookDto = new ArrayList<>();
//        for (Book book : books) {
//            BookDto dto = toDto(book);
//            bookDto.add(dto);
//        }
    }

    @Override
    public BookDto createBook(BookDto book) {

        validate(book);

        Book toCreate = toEntity(book);
        Book created = bookDao.createBook(toCreate);

        return toDto(created);
    }

    private void validate(BookDto book) {
        if (book.getIsbn().length()>13){
            throw new RuntimeException("Максимальная длинна 13 символов");
        }
    }

    @Override
    public BookDto getByISBN(String isbn) {
        return null;
    }

    @Override
    public BookDto getById(Long id) {
        Book book = bookDao.findById(id);
        if (book==null){
            throw new RuntimeException("Not found.");
        }
        return toDto(book);
    }

    @Override
    public void updateBook(String bookIsbn, BookDto book) {

    }

    @Override
    public void deleteBook(String bookIsbn) {
        boolean check = bookDao.deleteBook(bookIsbn);
        if (!check){
            throw new RuntimeException("Не удалось удалить");
        }
    }
    private BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookAuthor(book.getBookAuthor());
        bookDto.setBookName(book.getBookName());
        bookDto.setIsbn(book.getIsbn());
        return bookDto;
    }
    private Book toEntity(BookDto dto){



        return new Book();
    }
}
