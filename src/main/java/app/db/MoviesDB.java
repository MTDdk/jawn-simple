package app.db;

import java.util.List;

import com.google.inject.ImplementedBy;

import app.models.Movie;

@ImplementedBy(ArrayMoviesDB.class)
public interface MoviesDB {

    public List<Movie> listMovies();
    public Movie fetch(int id);
    public boolean add(Movie m);
    void insert(Movie m);
    public Movie find(String name);
    int size();
}
