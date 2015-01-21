package app.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.inject.Singleton;

import app.models.Movie;

@Singleton
class ArrayMoviesDB implements MoviesDB {
    
    private List<Movie> movies = new ArrayList<>();
    
    ArrayMoviesDB() {
        Collections.addAll( movies,
            new Movie("Guardians of the Galaxy", 2014),
            new Movie("Taken", 2008),
            new Movie("The Matrix", 1999)
         );
    }

    @Override
    public List<Movie> listMovies() {
        return Collections.unmodifiableList(movies);
    }

    @Override
    public Movie fetch(int id) {
        return movies.get(id);
    }
}
