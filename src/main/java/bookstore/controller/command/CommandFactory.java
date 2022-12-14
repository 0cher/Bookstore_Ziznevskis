package bookstore.controller.command;

import bookstore.data.dao.impl.BookDaoImp;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<String, Command> commands;
    public  static  final CommandFactory INSTANCE = new CommandFactory();
    private CommandFactory() {
        BookDaoImp bookDaoImp = new BookDaoImp();
        commands =new HashMap<>();
        commands.put("book", new BookCommand(bookDaoImp));
        commands.put("books", new BooksCommand(bookDaoImp));
        commands.put("error", new ErrorCommand());

    }
    public Command getCommand (String command){
        if (commands.get(command)==null){
            return commands.get("error");
        }

        return commands.get(command);
    }
}
