package edu.acc.project7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author Ryan Sprague
 */
public class BookManager extends DBManager {
    
    DataSource dataSource;

    BookManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    private Book bookFromDB(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        
        book.setID(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setReview(resultSet.getString("review"));
        book.setRating(resultSet.getInt("rating"));
        
        return book;
    }
    
    public List<Book> getBooksRatingOrder() {
        ArrayList<Book> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM books order by rating desc, title asc");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                books.add(bookFromDB(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        
        return books;
    }
    
    public List<Book> getBooksTitleOrder() {
        ArrayList<Book> books = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("SELECT * FROM books order by title asc");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                books.add(bookFromDB(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        
        return books;
    }
    
    public Book getBookById(int id) {
        Book book = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("select * from books where id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                book = bookFromDB(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        
        return book;
    }
}
