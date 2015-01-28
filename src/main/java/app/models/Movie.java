package app.models;

public class Movie {

    public int id;
    public String name;
    public int year;
    
    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }
    public Movie(String name, int year, int id) {
        this.name = name;
        this.year = year;
        this.id = id;
    }
}
