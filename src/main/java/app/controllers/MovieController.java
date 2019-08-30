package app.controllers;

import java.util.Arrays;

import com.google.inject.Inject;

import app.db.MoviesDB;
import app.models.Movie;
import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.View;
import net.javapla.jawn.core.mvc.GET;
import net.javapla.jawn.core.mvc.POST;
import net.javapla.jawn.core.mvc.Path;

@Path("/movie")
public class MovieController {
    
    @Inject
    MoviesDB movies;
    
    @GET
    public View index() {
        return Results.view().template("list").path("movie").put("movies", movies.listMovies());
    }
    
    @GET
    @Path("single/{id}")
    public View getSingle(Context ctx) {
        return Results.view()
            .template("list")
            .path("movie")
            .put("movies", Arrays.asList(movies.fetch(ctx.param("id").map(Integer::parseInt).orElse(0))));
    }
    
    @POST
    public Result postMovie(Context ctx) {
        String title = ctx.param("title").value();
        int year = ctx.param("year").map(Integer::parseInt).orElse(2000);
        
        movies.add(new Movie(title, year));
        
        return index();
    }

/*    public void index() {
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
    }*/
    
    /**
     * Update movies
     */
/*    public void putName() {
        Movie movie = movies.fetch(param("pk").asInt());
        movie.name = param("value").asString();
        respond().status().ok();
    }
    public void putYear() {
        Movie movie = movies.fetch(param("pk").asInt());
        movie.year = param("value").asInt();
        respond().status().ok();
    }
    */
    /* 
     * **********************************
     * Get the list in a different format
     * **********************************
     */
/*    
    public void getXml() {
        respond().xml(movies.listMovies());
    }
    
    public void getJson() {
        respond().json(movies.listMovies());
    }*/
    
}
