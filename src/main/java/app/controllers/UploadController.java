package app.controllers;

import java.util.Base64;

import net.javapla.jawn.core.Controller;
import net.javapla.jawn.core.uploads.FormItem;

public class UploadController extends Controller {

    public void postIndex() {
        System.out.println("params   " + params());
        System.out.println("uploads   " + multipartFormItems());
        FormItem uploaded = multipartFormItems().first("image");
        byte[] image = image(uploaded).resizeToWidth(400).asBytes();
        view("picture","data:image/jpg;base64,"+Base64.getEncoder().encodeToString(image));
        //render("upload");
    }
}
