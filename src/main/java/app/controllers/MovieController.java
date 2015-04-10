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
    }
    public void putYear() {
        Movie movie = movies.fetch(param("pk").asInt());
        movie.year = param("value").asInt();
    }
    
    public void getKage() {
        respond().text("henning11333333333333");
    }
    public void getHenning() {
        respond().json(new Movie("Movie name",555,10));
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
