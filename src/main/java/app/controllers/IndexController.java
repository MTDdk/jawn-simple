package app.controllers;

import java.io.File;

import net.javapla.jawn.core.Controller;
import net.javapla.jawn.core.http.Cookie;

public class IndexController extends Controller {

    
    public void getImage() {
        respond().sendFile(new File(getRealPath("images/pi.jpg")));
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
