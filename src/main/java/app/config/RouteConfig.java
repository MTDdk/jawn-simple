package app.config;

import app.controllers.MovieController;
import net.javapla.jawn.AbstractRouteConfig;
import net.javapla.jawn.AppContext;

public class RouteConfig extends AbstractRouteConfig {

    @Override
    public void init(AppContext appContext) {
        route("/movie/{id}").action("single").to(MovieController.class);
    }

}
