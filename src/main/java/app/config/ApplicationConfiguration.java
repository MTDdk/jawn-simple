package app.config;

import net.javapla.jawn.core.ApplicationConfig;
import net.javapla.jawn.core.Filters;
import net.javapla.jawn.core.Router;
import net.javapla.jawn.core.spi.ApplicationBootstrap;
import net.javapla.jawn.core.spi.ApplicationFilters;
import net.javapla.jawn.core.spi.ApplicationRoutes;
import net.javapla.jawn.core.spi.filters.LogRequestPropertiesFilter;
import net.javapla.jawn.core.spi.filters.LogRequestTimingFilter;
import net.javapla.jawn.core.spi.filters.LogRequestsFilter;
import app.controllers.MovieController;
import app.controllers.SomeController;
import app.db.DbModule;

public class ApplicationConfiguration implements ApplicationBootstrap, ApplicationRoutes, ApplicationFilters {
    
    @Override
    public void bootstrap(ApplicationConfig config) {
        config.registerModules(new DbModule());
    }
    
    @Override
    public void router(Router router) {
        router.GET().route("/movie/id/{id}").to(MovieController.class, "single");
        router.GET().route("/else").to(SomeController.class);
        router.GET().route("/language/{lang}/{long_id: .*?}").to(SomeController.class, "lang");
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
