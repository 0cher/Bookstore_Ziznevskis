package bookstore.controller;

import bookstore.controller.command.Command;
import bookstore.controller.command.CommandFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/controller") // /controller?command=
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("command");

        CommandFactory commandFactory = CommandFactory.INSTANCE;

        Command command = commandFactory.getCommand(action);

        String page = command.execute(req);

        req.getRequestDispatcher(page).forward(req,resp);

    }
}
