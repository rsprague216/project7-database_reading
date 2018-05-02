package edu.acc.project7;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "BooksServlet", urlPatterns = {"/books"})
public class BooksServlet extends HttpServlet {
    
//    @Inject
//    BookManager manager;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookManager manager = (BookManager)getServletContext().getAttribute("manager");
        System.out.println("manager is " + manager);
        request.setAttribute("books", manager.getBooksRatingOrder());
        
        request.getRequestDispatcher("/WEB-INF/books.jsp").forward(request, response);
    }
}
