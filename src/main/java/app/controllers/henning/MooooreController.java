package app.controllers.henning;

import net.javapla.jawn.core.Controller;

public class MooooreController extends Controller {

    public void index() {
        view("title", "KRAAAN");
        view("message", "cookie");
        render("/system/404");
    }
}
