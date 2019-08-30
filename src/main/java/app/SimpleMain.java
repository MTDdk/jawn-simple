package app;

import java.util.Random;

import app.controllers.UrlController;
import app.db.DbModule;
import app.db.MoviesDB;
import app.models.Movie;
import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.Jawn;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.filters.LogRequestPropertiesFilter;
import net.javapla.jawn.core.filters.LogRequestTimingFilter;
import net.javapla.jawn.core.util.Modes;

public class SimpleMain extends Jawn {
    
    // implicit constructor
    {
        mode(Modes.DEV);
        onStartup(() -> System.out.println("My app has started up!"));
        onShutdown(() -> System.out.println("Closing down"));
        
        assets().etag(false).lastModified(true).maxAge();
        
        // Custom Routes
        controllers("app.controllers");

        controller(UrlController.class)
            .before(new LogRequestPropertiesFilter()); // Filters (Controller specific)
//        get("/else", UrlController.class);
//        get("/language/{lang}/{long_id: .*?}", context -> Results.text("language is ''{0}'' - param id: {1}", context.param("lang").orElse(null), context.param("long_id").orElse(null)));
//        get("/language/{lang}/{long_id: .*?}", UrlController.class, UrlController::getLang);
        
        
//        mvc(MovieController.class);
//        get("/movie/id/{id}", MovieController.class, MovieController::getSingle);
        
        
        get("/misc", Results.view().template("misc"));
        get("/test/{type}", (context) -> { // inline response function
            Movie m = new Movie("The Avengers",2012);
            
            Result rsp;
            
            String type = context.param("type").value("text");
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
        filter(new LogRequestTimingFilter());
        
        // Modules
        use(new DbModule());
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
