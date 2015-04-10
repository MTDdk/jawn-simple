package app.controllers.henning;

import net.javapla.jawn.AppController;

public class MooooreController extends AppController {

    public void index() {
        view("title", "KRAAAN");
        view("message", "cookie");
        render("/system/404");
    }
}
