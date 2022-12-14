package bookstore;

import bookstore.data.dao.BookDao;
import bookstore.data.dao.UserDao;
import bookstore.data.dao.impl.BookDaoImp;
import bookstore.data.dao.impl.UserDaoImp;

import bookstore.data.entity.Book;
import bookstore.data.entity.User;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        byte action =-1;
        Scanner scanner = new Scanner(System.in);
        BookDao bookDao = new BookDaoImp();
        UserDao userDao = new UserDaoImp();

//        System.out.println(bookDao.findById(2L));
//        System.out.println(bookDao.findByISBN("01234"));
//
//        System.out.println(bookDao.createBook(new Book.Book("NoName", "bookNoName", "0121212" )));
//        bookDao.updateBook("0121212",new Book.Book("NoName", "bookNoName", "445544" ));
//        System.out.println(bookDao.findByISBN("0121212"));
//        System.out.println(bookDao.findByISBN("445544"));
//        System.out.println(bookDao.findByISBN("0121212"));
//
//        bookDao.deleteBook("445544");
//        books = bookDao.findAll();
//        books.forEach(System.out::println);

        do {
            System.out.println("1-Показать список книг");
            System.out.println("2-Показать список пользователей");
            System.out.println("3-Найти книгу по ISBN");
            System.out.println("4-Найти пользователя по ID");
            System.out.println("5-Найти пользователя по email");
            System.out.println("6-Создать новую книгу");
            System.out.println("7-Создать нового пользователя");
            System.out.println("0-Завершить программу");
            System.out.println();
            System.out.print("Введите номер действия: ");
            action=scanner.nextByte();

            switch (action){
                case 1:{
                    List<Book> books = bookDao.findAll();
                    //List<Book> books = bookDao.findAll();
                    books.forEach(System.out::println);break;}

                case 2: {List<User> users = userDao.findAll();
                    users.forEach(System.out::println); break;}

                case 3:{System.out.print("Введите ISBN: ");
                    String ISBN = scanner.next();
                    System.out.println(bookDao.findByISBN(ISBN));
                    break;
                }
                case 4:{System.out.print("Введите ID пользователя: ");
                    Long userId = scanner.nextLong();
                    System.out.println(userDao.findById(userId));
                    break;
                }
                case 5: {System.out.print("Введите email пользователя: ");
                    String userEmail = scanner.next();
                    System.out.println(userDao.findByEmail(userEmail));
                    break;
                }
                case 6:{System.out.print("Введите автора книги: ");
                    String bookAuthor = scanner.next();
                    System.out.print("Введите название книги: ");
                    String bookName = scanner.next();
                    System.out.print("Введите ISBN книги: ");
                    String bookISBN = scanner.next();
                    System.out.println(bookDao.createBook(new Book(bookAuthor, bookName, bookISBN)));
                    break;
                }
                case 7: {System.out.print("Введите имя пользователя: ");
                    String userName = scanner.next();
                    System.out.print("Введите email пользователя: ");
                    String userEmail = scanner.next();
                    System.out.print("Введите возраст пользователя: ");
                    Integer userAge = scanner.nextInt();
                    System.out.print("Создайте пароль: ");
                    String userPassword = scanner.next();
                    System.out.println(userDao.createUser(new User(userName,userEmail,userAge,userPassword)));
                    break;
                }
            }

        }while (action!=0);

    }
}
