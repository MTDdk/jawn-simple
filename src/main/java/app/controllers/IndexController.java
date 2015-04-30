package app.controllers;

import java.io.File;

import net.javapla.jawn.core.AppController;
import net.javapla.jawn.core.exceptions.ParsableException;
import net.javapla.jawn.core.http.Cookie;

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
        respond().sendFile(new File(getRealPath("images/test.jpg")));
    }
    
    public void getTest() {
        Cookie cookie = cookie("henning");
        if (cookie == null) {
            System.err.println("................... cookie not set ......");
            sendCookie("henning","tester");
        } else {
            System.err.println("-------------------- cookie set to " + cookie.getValue());
        }
    }
    public void getFlash() {
        flash("message","henning har ikke noget tøj på");
        redirect(IndexController.class);
    }
}
