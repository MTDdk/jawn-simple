package app.controllers;

import net.javapla.jawn.core.Controller;
import net.javapla.jawn.core.exceptions.ParsableException;

public class RedirectController extends Controller {
    
    public void index() {
        view("title", "Try to make the framework redirect");
        view("message", "The inputted value will be sent to the framework for evaluation and it will try to redirect if possible");
    }
    
    public void postIndex() {
        try {
            redirect(param("url").asURL());
            log().info("Redirecting to {}", param("url"));
        } catch (ParsableException e) {
            // failed to redirect, so we populate the view instead
            view("redirect", param("url"));
            view("error", e.getMessage());
            log().error("Malformed url: {}", e.getMessage());
            render("redirect");
        }
    }
    

}
