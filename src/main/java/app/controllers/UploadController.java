package app.controllers;

import java.util.Base64;

import com.google.inject.Inject;

import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.View;
import net.javapla.jawn.core.internal.image.Images;
import net.javapla.jawn.core.mvc.GET;
import net.javapla.jawn.core.mvc.POST;
import net.javapla.jawn.core.mvc.Path;
import net.javapla.jawn.core.server.FormItem;

@Path("/upload")
public class UploadController {
    
    @Inject
    Images images;
    
    @GET
    public View index() {
        return Results.view().template("upload");
    }
    
    @POST
    public View postIndex(Context.Request req) {
        // Read the uploaded image
        FormItem uploaded = req.formData().first("image");
        
        // Resize the image
        byte[] image = images.image(uploaded).resizeToWidth(400).asBytes();
        
        // Just send the image data back without saving anything on the server
        return Results.view().template("upload").put("picture", "data:image/jpg;base64," + Base64.getEncoder().encodeToString(image));
    }
}
