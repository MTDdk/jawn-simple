package app.controllers;

import app.models.Movie;
import net.javapla.jawn.core.AppController;
import net.javapla.jawn.core.exceptions.ParsableException;

public class SomeController extends AppController {
    
    public void getLang() {
        respond().text("language is ''{0}'' - param id: {1}", language(), param("long_id"));
    }
    
    public void getKage() {
        respond().text("language   " + language());
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
