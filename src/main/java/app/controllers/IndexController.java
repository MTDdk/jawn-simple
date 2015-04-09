package app.controllers;

import net.javapla.jawn.AppController;
import net.javapla.jawn.exceptions.ParsableException;

public class IndexController extends AppController {

    public void index() {
        view("title", "Try to make the framework redirect");
        view("message", "The inputted value will be sent to the framework for evaluation and it will try to redirect if possible");
    }
    
    public void getRedirect() {
        try {
            redirect(param("url").asURL());
            log().info("Redirecting to {}", param("url"));
        } catch (ParsableException e) {
            // failed to redirect, so we populate the view instead
            view("redirect", param("url"));
            view("error", e.getMessage());
            log().error("Malformed url: {}", e.getMessage());
        }
    }
    
    public void getKage() {
        respond().text("kagerrrr");
    }
    
    public void getTest() {
        respond().text("testteeeer");
    }
}
