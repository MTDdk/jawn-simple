package app.controllers.longerpath;

import net.javapla.jawn.core.Controller;

public class MoreController extends Controller {

    public void index() {
        view("title", "KRAAAN");
        view("message", "cookie");
        render("/system/404");
    }
}
