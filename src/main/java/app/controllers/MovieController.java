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
import net.javapla.jawn.core.mvc.PUT;
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
        String title = ctx.param("title").get();
        int year = ctx.param("year").map(Integer::parseInt).orElse(2000);
        
        movies.add(new Movie(title, year));
        
        return index();
    }
    
    /**
     * Update movies
     */
    
    @PUT
    @Path("/name")
    public void putName(Context ctx) {
        Movie movie = movies.fetch(ctx.param("pk").map(Integer::parseInt).get());
        movie.name = ctx.param("value").get();
    }
    
    @PUT
    @Path("/year")
    public void putYear(Context ctx) {
        Movie movie = movies.fetch(ctx.param("pk").map(Integer::parseInt).get());
        movie.year = ctx.param("value").map(Integer::parseInt).get();
    }

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
