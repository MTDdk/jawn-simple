package app.controllers;

import app.models.Movie;
import net.javapla.jawn.AppController;
import net.javapla.jawn.exceptions.ParsableException;

public class SomeController extends AppController {
    
    public void getLang() {
        respond().text("language is ''{0}'' - param id: {1}", language(), param("long_id"));
    }
    
    public void postJson() {
        try {
            System.err.println(request().parseBody(Movie.class));
            respond().text("working");
        } catch (ParsableException e) {
            respond().text("didn't work");
        }
    }
}
