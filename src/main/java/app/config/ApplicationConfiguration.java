package app.config;

import app.controllers.MovieController;
import app.controllers.SomeController;
import app.db.DbModule;
import net.javapla.jawn.core.ApplicationConfig;
import net.javapla.jawn.core.api.ApplicationBootstrap;
import net.javapla.jawn.core.api.ApplicationRoutes;
import net.javapla.jawn.core.api.Filters;
import net.javapla.jawn.core.api.Router;
import net.javapla.jawn.core.filters.LogRequestPropertiesFilter;
import net.javapla.jawn.core.filters.LogRequestTimingFilter;
import net.javapla.jawn.core.filters.LogRequestsFilter;

public class ApplicationConfiguration implements ApplicationBootstrap, ApplicationRoutes, net.javapla.jawn.core.api.ApplicationFilters {
    
    @Override
    public void bootstrap(ApplicationConfig config) {
        config.registerModules(new DbModule());
    }
    
    @Override
    public void router(Router routes) {
        routes.GET().route("/movie/id/{id}").to(MovieController.class, "single");
        routes.GET().route("/else").to(SomeController.class);
        routes.GET().route("/language/{lang}/{long_id: .*?}").to(SomeController.class, "lang");
    }
    
    @Override
    public void filters(Filters filters) {
        // Global
        filters.add(new LogRequestsFilter());
        filters.add(new LogRequestTimingFilter());
        
        // Action specific
        filters.add(new LogRequestPropertiesFilter()).to(SomeController.class).forActions("getLang");
//        filters.add(new SystemoutFilter()).to(IndexController.class).forActions("getTest");
    }
    
    @Override
    public void destroy() {
        System.err.println("Closing down");
    }

}
