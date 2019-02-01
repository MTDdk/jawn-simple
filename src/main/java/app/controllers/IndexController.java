package app.controllers;

import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.mvc.GET;
import net.javapla.jawn.core.mvc.Path;

@Path("/")
public class IndexController /*extends Controller*/ {
    
    
/*
    
    public void getimage() {
        file file = new file(getrealpath("images/pi.jpg"));
        respond()
            .sendfile(file)
            .contenttype("image/jpg")
            .addheader("mime-type","image/jpg")
            .addheader("content-disposition", "") // hinders the browser from downloading the image
            .addheader("content-length", string.valueof(file.length()))
            ;
    }*/
    
    /*
    public void getFlash() {
        flash("message","some flash message that only lives for a single web request");
        redirect(IndexController.class);
    }*/
    
    @GET
    public Result index() {
        return Results.html();
    }
    
    @GET
    @Path("/image")
    public void image() {
        
    }
}
