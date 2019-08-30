package app.controllers;

import java.io.File;

import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.MediaType;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.mvc.GET;
import net.javapla.jawn.core.mvc.Path;

@Path("/")
public class IndexController /*extends Controller*/ {
    
    
    /*
    public void getFlash() {
        flash("message","some flash message that only lives for a single web request");
        redirect(IndexController.class);
    }*/
    
    @GET
    public Result index() {
        return Results.view();
    }
    
    @GET
    @Path("/image")
    public Result image(Context ctx) {
        File file = ctx.realPath("images/pi.jpg").toFile();
        return Results.ok(file)
            .contentType(MediaType.byExtension("jpg").get())
            .header("Content-Disposition", "") // hinders the browser from downloading the image
            .header("Content-Length", String.valueOf(file.length()));
    }
}
