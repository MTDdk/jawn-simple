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
            new Movie("Guardians of the Galaxy", 2014, 0),
            new Movie("Taken", 2008, 1),
            new Movie("The Matrix", 1999, 2)
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
    
    @Override
    public boolean add(Movie m) {
        int largestId = movies.get(movies.size()-1).id;
        return movies.add(m.clone(largestId+1));
    }
    
    @Override
    public void insert(Movie m) {
        movies.set(m.id, m);
    }
    
    @Override
    public Movie find(String name) {
        for (Movie movie : movies) {
            if (movie.name.equals(name))
                return movie;
        }
        return null;
    }
    
    @Override
    public int size() {
        return movies.size();
    }
}
