package app.controllers;

import java.util.Base64;

import net.javapla.jawn.core.Controller;
import net.javapla.jawn.core.http.FormItem;

public class UploadController extends Controller {
    
    //implicitly stated
    //public void index()

    public void postIndex() {
        // Read the uploaded image
        FormItem uploaded = multipartFormItems().first("image");
        
        // Resize the image
        byte[] image = image(uploaded).resizeToWidth(400).asBytes();
        
        // Just send the image data back without saving anything on the server
        view("picture","data:image/jpg;base64,"+Base64.getEncoder().encodeToString(image));
    }
}
