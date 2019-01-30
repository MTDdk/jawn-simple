package app;

import java.util.Random;

import app.db.MoviesDB;
import app.models.Movie;
import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.Jawn;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.filters.LogRequestTimingFilter;
import net.javapla.jawn.core.util.Modes;

public class SimpleMain extends Jawn {
    
    //TODO
    // Create a AssetRouter (like the MvcRouter) that finds folders in webapp to serve
    
    // implicit constructor
    {
        mode(Modes.DEV);
        onStartup(() -> System.out.println("My app has started up!"));
        onShutdown(() -> System.out.println("Closing down"));
        
        // Custom Routes
//        get("/else", UrlController.class);
//        get("/language/{lang}/{long_id: .*?}", UrlController.class, UrlController::getLang);
//        get("/movie/id/{id}", MovieController.class, MovieController::getSingle);
        get("/misc", Results.html().template("/misc"));
        get("/test/{type}", (context) -> { // inline response function
            Movie m = new Movie("The Avengers",2012);
            
            Result rsp;
            
            String type = context.param("type").orElse("text");
            switch(type) {
                case "json":
                    rsp = Results.json(m);
                    break;
                case "xml":
                    rsp = Results.xml(m);
                    break;
                default:
                    rsp = Results.text(m);
            }
            
            return rsp;
        });
        get("/random", this::random); // method signature response function
        get("/shutdown", () -> { stop(); return Results.ok(); });
        
        // Filters (Global)
        // Called in the same order as they are declared
//        filter(new LogRequestsFilter());
        filter(new LogRequestTimingFilter());
        // Filters (Controller specific)
//        filter(new LogRequestPropertiesFilter(), UrlController.class);
        
        // Modules
//        use(new DbModule());
    }

    public static void main(String[] args) throws Exception {
        run(SimpleMain.class, args);
    }
    
    private Result random(Context ctx) {
        Random rnd = new Random();
        MoviesDB db = require(MoviesDB.class);
        return Results.json(db.fetch(rnd.nextInt(db.size())));
    }
}
