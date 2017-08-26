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
    
    public void deleteCookies() {
        log().info("Deleting all cookies");
        cookies().forEach(cookie -> sendExpireCookie(cookie.getName()));
        redirect(CookieController.class);
    }
}
