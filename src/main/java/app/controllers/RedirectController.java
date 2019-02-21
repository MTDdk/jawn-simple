package app.controllers;

import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.View;
import net.javapla.jawn.core.mvc.GET;
import net.javapla.jawn.core.mvc.POST;
import net.javapla.jawn.core.mvc.Path;

@Path("redirect")
public class RedirectController /*extends Controller*/ {
    
    @GET
    public View index() {
        return Results.view()
            .path("redirect")
            .put("title", "Try to make the framework redirect")
            .put("message", "The inputted value will be sent to the framework for evaluation and it will try to redirect if possible");
    }
    
    @POST
    public Result postIndex(Context ctx) {
        
        return ctx.param("url").toOptional()
            .filter(url -> !url.isEmpty())
            .map(url -> Results.redirect(url))
            .orElse(Results
                .view()
                .put("redirect", "nothing")
                .put("error", "no url")
                .template("redirect")
                .path("redirect")
            );
        
        //return Results.redirect(ctx.param("url").orElse(""));
    }
    
 /*   
    public void index() {
        view("title", "Try to make the framework redirect");
        view("message", "The inputted value will be sent to the framework for evaluation and it will try to redirect if possible");
    }
    
    public void postIndex() {
        try {
            redirect(param("url").asURL());
            log().info("Redirecting to {}", param("url"));
        } catch (ParsableException e) {
            // failed to redirect, so we populate the view instead
            view("redirect", param("url"));
            view("error", e.getMessage());
            log().error("Malformed url: {}", e.getMessage());
            render("redirect");
        }
    }
    
*/
}
