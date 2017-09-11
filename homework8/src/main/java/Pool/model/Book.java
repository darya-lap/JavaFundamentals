package Pool.model;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String author;
    private String name;
    private Integer year;

    public Book(){

    }

    public Book(String name){
        this.author = null;
        this.name = name;
        this.year = null;
    }

    public  Book (String name, String author){
        this.author = author;
        this.name = name;
        this.year = null;
    }

    public  Book (String name, Integer year){
        this.author = null;
        this.name = name;
        this.year = year;
    }

    public  Book (String name, String author, Integer year){
        this.author = author;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", name=" + name +
                ", year=" + year +
                '}';
    }
}
