package app.controllers;

import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.mvc.GET;
import net.javapla.jawn.core.mvc.Path;

@Path("/else")
@Path("/url")
public class UrlController /*extends Controller*/ {
 /*   
    public void getLang() {
        respond().text("language is ''{0}'' - param id: {1}", param("lang"), param("long_id"));
    }
    
    public void postJson() {
        try {
            System.err.println(parseBody(Movie.class));
            respond().text("working");
        } catch (ParsableException e) {
            respond().text("didn't work");
        }
    }*/
    
    @GET
    public Result index() {
        return Results.view().template("url");
    }
    
    @GET
    @Path("/language/{lang}/{long_id: .*?}")
    public Result lang(Context context) {
        return Results.text("language is ''{0}'' - param id: {1}", context.param("lang").value(null), context.param("long_id").value(null));
    }
}
