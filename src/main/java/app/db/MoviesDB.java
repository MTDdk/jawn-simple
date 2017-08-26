package app.db;

import java.util.List;

import app.models.Movie;

public interface MoviesDB {

    public List<Movie> listMovies();
    public Movie fetch(int id);
    public boolean add(Movie m);
    public Movie find(String name);
    int size();
}
