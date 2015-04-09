package app.config;

import app.controllers.MovieController;
import app.controllers.SomeController;
import net.javapla.jawn.Router;
import net.javapla.jawn.application.IRouteConfig;

public class RouteConfig implements IRouteConfig {

    @Override
    public void init(Router router) {
        router.GET().route("/movie/id/{id}").to(MovieController.class, "single");
        router.GET().route("/else").to(SomeController.class);
        router.GET().route("/language/{lang}/{long_id: .*?}").to(SomeController.class, "lang");
        
    }

}
