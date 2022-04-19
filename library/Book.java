package JP2.library;

import java.util.Date;

public class Book {
    public Integer id;
    public String bookName;
    public String publisherName;
    public Date publishYear;
    public String author;
    public Double price;

    public Book(Integer id, String bookName, String publisherName, Date publishYear, String author, Double price){
        this.id = id;
        this.bookName = bookName;
        this.publisherName = publisherName;
        this.publishYear = publishYear;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
