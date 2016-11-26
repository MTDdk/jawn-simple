package app.controllers;

import net.javapla.jawn.core.Controller;

public class CookieController extends Controller {

    public void index() {
        view("cookies", cookies());
    }
    
    public void postCookie() {
        sendCookie(param("name").asString(), param("value").asString());
        redirect(CookieController.class);
    }
}
