package app.controllers;

import java.net.MalformedURLException;
import java.net.URL;

import net.javapla.jawn.AppController;

public class IndexController extends AppController {

    public void index() {
        view("title", "Try to make the framework redirect");
        view("message", "The inputted value will be sent to the framework for evaluation and it will try to redirect if possible");
    }
    
    public void getRedirect() {
        try {
            redirect(new URL(param("url")));
            log().info("Redirecting to {}", param("url"));
        } catch (MalformedURLException e) {
            // failed to redirect, so we populate the view instead
            view("redirect", param("url"));
            view("error", e.getMessage());
            log().error("Malformed url: {}", e.getMessage());
        }
    }
}
