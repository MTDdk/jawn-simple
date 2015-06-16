package app.controllers.henning;

import net.javapla.jawn.core.ApplicationController;

public class MooooreController extends ApplicationController {

    public void index() {
        view("title", "KRAAAN");
        view("message", "cookie");
        render("/system/404");
    }
}
