package app.models;

import java.text.MessageFormat;

public class Movie {

    public int id;
    public String name;
    public int year;
    
    public Movie() {}
    
    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
        this.id = -1;
    }
    public Movie(String name, int year, int id) {
        this.name = name;
        this.year = year;
        this.id = id;
    }
    
    public Movie clone() {
        return clone(this.id);
    }
    public Movie clone(int id) {
        return new Movie(this.name, this.year, id);
    }
    
    @Override
    public String toString() {
        return MessageFormat.format("Movie id: {0}, name: {1}, year: {2,number,#}", id, name, year);
    }
}
