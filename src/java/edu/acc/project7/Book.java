package edu.acc.project7;

/**
 * @author Ryan Sprague
 */
public class Book {
    private int id, rating;
    private String title, author, review;
    
    // Getters and Setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public void setReview(String review) {
        this.review = review;
    }
    
    public String getReview() {
        return this.review;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return this.id;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public int getRating() {
        return this.rating;
    }
}
