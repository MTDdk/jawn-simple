package app.controllers;

import net.javapla.jawn.AppController;

public class SomeController extends AppController {

    public void getLang() {
        respond().text("language is ''{0}'' - param id: {1}", language(), param("long_id"));
    }
}
