package edu.acc.project7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "BookDetailsServlet", urlPatterns = {"/books/info"})
public class BookDetailsServlet extends HttpServlet {

    
    protected int idParameter(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("id"));
    }
    
    protected Book findBook(HttpServletRequest request, BookManager manager) {
        try {
            return manager.getBookById(idParameter(request));
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookManager manager = (BookManager)getServletContext().getAttribute("manager");
    
        //BookManager manager = (BookManager)getServletContext().getAttribute("manager");
        System.out.println("manager in details is " + manager);
        
        Book book = findBook(request, manager);
        System.out.println("book is " + book);
        if (book == null) {
            response.sendError(404, "Not Found");
        } else {
            request.setAttribute("book", book);
            request.getRequestDispatcher("/WEB-INF/bookDetails.jsp").forward(request, response);
        }   
    }
}
