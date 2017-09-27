package app.controllers;

import java.io.File;

import net.javapla.jawn.core.Controller;

public class IndexController extends Controller {

    
    public void getImage() {
        File file = new File(getRealPath("images/pi.jpg"));
        respond()
            .sendFile(file)
            .contentType("image/jpg")
            .addHeader("mime-type","image/jpg")
            .addHeader("Content-Disposition", "") // hinders the browser from downloading the image
            .addHeader("Content-Length", String.valueOf(file.length()))
            ;
    }
    
    
    public void getFlash() {
        flash("message","some flash message that only lives for a single web request");
        redirect(IndexController.class);
    }
}
