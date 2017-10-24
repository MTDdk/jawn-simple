package app.controllers;

import java.util.Random;

import com.google.inject.Inject;

import app.db.MoviesDB;
import app.models.Movie;
import net.javapla.jawn.core.Controller;
import net.javapla.jawn.core.cache.Cache;

public class CacheController extends Controller {
    @Inject
    Cache cache;
    
    @Inject
    MoviesDB movies;

    public void index() {
        Random rnd = new Random();
        Integer id = rnd.nextInt(movies.size());
        String key = "movies"+id;
        
        Movie movie;
        if (cache.isSet(key)) {
            view("cache_message","Already cached");
            movie = cache.get(key);
        } else {
            // caching for 30 seconds
            movie = movies.fetch(id);
            cache.add(key, movie, 30);
            
            view("cache_message","Added the movie to cache");
        }
        view("movie",movie);
    }
}
