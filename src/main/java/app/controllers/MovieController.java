package app.controllers;

import java.util.Arrays;

import com.google.inject.Inject;

import app.db.MoviesDB;
import app.models.Movie;
import net.javapla.jawn.core.Controller;

public class MovieController extends Controller {
    
    @Inject
    MoviesDB movies;

    public void index() {
        view("movies", movies.listMovies());
        render("list");
    }
    
    public void getSingle() {
        Movie movie = movies.fetch(getId().asInt());
        
        view("movies", Arrays.asList(movie));
        render("list");
    }
    
    public void postMovie() {
        String title = param("title").asString();
        Integer year = param("year").asInt(2000); // default value
        
        movies.add(new Movie(title, year));
        redirect(); // redirect to index() of this Controller
    }
    
    /**
     * Update movies
     */
    public void putName() {
        Movie movie = movies.fetch(param("pk").asInt());
        movie.name = param("value").asString();
        respond().status().ok();
    }
    public void putYear() {
        Movie movie = movies.fetch(param("pk").asInt());
        movie.year = param("value").asInt();
        respond().status().ok();
    }
    
    /* 
     * **********************************
     * Get the list in a different format
     * **********************************
     */
    
    public void getXml() {
        respond().xml(movies.listMovies());
    }
    
    public void getJson() {
        respond().json(movies.listMovies());
    }
    
}
