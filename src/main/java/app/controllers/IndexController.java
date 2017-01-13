package app.controllers;

import java.io.File;

import net.javapla.jawn.core.Controller;

public class IndexController extends Controller {

    
    public void getImage() {
        respond().sendFile(new File(getRealPath("images/pi.jpg")));
    }
    
    
    public void getFlash() {
        flash("message","henning har ikke noget tøj på");
        redirect(IndexController.class);
    }
}
