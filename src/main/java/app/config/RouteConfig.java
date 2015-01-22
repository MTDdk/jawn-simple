package app.config;

import net.javapla.jawn.AbstractRouteConfig;
import net.javapla.jawn.AppContext;
import app.controllers.MovieController;
import app.controllers.SomeController;

public class RouteConfig extends AbstractRouteConfig {
    @Override
    public void init(AppContext appContext) {
        route("/movie/id/{id}").action("single").to(MovieController.class);
        route("/else").to(SomeController.class);
        route("/language/{lang}/*long_id").get().action("lang").to(SomeController.class);
    }
}
