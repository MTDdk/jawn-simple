package app.controllers;

import java.util.Arrays;

import net.javapla.jawn.AppController;
import app.db.MoviesDB;
import app.models.Movie;

import com.google.inject.Inject;

public class MovieController extends AppController {
    
    @Inject
    MoviesDB movies;

    public void index() {
        view("movies", movies.listMovies());
        render("list");
    }
    
    public void getSingle() {
        Movie movie = movies.fetch(getIdInt());
        
        view("movies", Arrays.asList(movie));
        render("list");
    }
    
    public void getXml() {
        respond().xml(movies.listMovies());
    }
    
    public void getJson() {
        respond().json(movies.listMovies());
    }
}
