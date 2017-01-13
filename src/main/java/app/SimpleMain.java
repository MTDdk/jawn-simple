package app;

import app.controllers.MovieController;
import app.controllers.UrlController;
import app.db.DbModule;
import app.models.Movie;
import net.javapla.jawn.core.Jawn;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.filters.LogRequestPropertiesFilter;
import net.javapla.jawn.core.filters.LogRequestTimingFilter;
import net.javapla.jawn.core.filters.LogRequestsFilter;
import net.javapla.jawn.core.util.Modes;

public class SimpleMain extends Jawn {
    
    // implicit constructor
    {
        env(Modes.DEV);
        onStartup(() -> System.out.println("My app has started up!"));
        onShutdown(() -> System.out.println("Closing down"));
        
        // Custom Routes
        get("/else", UrlController.class);
        get("/language/{lang}/{long_id: .*?}", UrlController.class, "lang");
        get("/movie/id/{id}", MovieController.class, "single");
        get("/test/{type}", (context) -> {
            Result rsp;
            switch(context.param("type")) {
                case "json":
                    rsp = Results.json();
                    break;
                case "xml":
                    rsp = Results.xml();
                    break;
                default:
                    rsp = Results.text();
            }
            
            return rsp.renderable(new Movie("henning",1007));
        });
        
        // Filters (Global)
        // Called in the same order as they are declared
        filter(new LogRequestsFilter());
        filter(new LogRequestTimingFilter());
        // Filters (Action specific)
        filter(new LogRequestPropertiesFilter(), UrlController.class, "getLang");
        
        // Modules
        use(new DbModule());
    }

    public static void main(String[] args) throws Exception {
        run(SimpleMain::new, args);
    }
}
