package app;

import java.util.Random;

import app.controllers.MovieController;
import app.controllers.UrlController;
import app.db.DbModule;
import app.db.MoviesDB;
import app.models.Movie;
import net.javapla.jawn.core.Jawn;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.filters.LogRequestPropertiesFilter;
import net.javapla.jawn.core.filters.LogRequestTimingFilter;
import net.javapla.jawn.core.filters.LogRequestsFilter;
import net.javapla.jawn.core.http.Context;
import net.javapla.jawn.core.util.Modes;

public class SimpleMain extends Jawn {
    
    // implicit constructor
    {
        env(Modes.DEV);
        onStartup(() -> System.out.println("My app has started up!"));
        onShutdown(() -> System.out.println("Closing down"));
        
        // Custom Routes
        get("/else", UrlController.class);
        get("/language/{lang}/{long_id: .*?}", UrlController.class, UrlController::getLang);
        get("/movie/id/{id}", MovieController.class, MovieController::getSingle);
        get("/misc", Results.html().template("/misc"));
        get("/test/{type}", (context) -> { // inline response function
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
            
            return rsp.renderable(new Movie("The Avengers",2012));
        });
        get("/random", this::random); // method signature response function
        get("/shutdown", () -> { stop(); return Results.ok(); });
        
        // Filters (Global)
        // Called in the same order as they are declared
        filter(new LogRequestsFilter());
        filter(new LogRequestTimingFilter());
        // Filters (Controller specific)
        filter(new LogRequestPropertiesFilter(), UrlController.class);
        
        // Modules
        use(new DbModule());
    }

    public static void main(String[] args) throws Exception {
        run(SimpleMain::new, args);
    }
    
    private Result random(Context ctx) {
        Random rnd = new Random();
        MoviesDB db = require(MoviesDB.class);
        return Results.text().renderable(db.fetch(rnd.nextInt(db.size())));
    }
}
