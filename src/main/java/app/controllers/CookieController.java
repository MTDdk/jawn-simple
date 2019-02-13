package app.controllers;

import net.javapla.jawn.core.Context;
import net.javapla.jawn.core.Result;
import net.javapla.jawn.core.Results;
import net.javapla.jawn.core.View;
import net.javapla.jawn.core.mvc.DELETE;
import net.javapla.jawn.core.mvc.GET;
import net.javapla.jawn.core.mvc.POST;
import net.javapla.jawn.core.mvc.Path;

@Path("/cookie")
public class CookieController {
    
    @GET
    public View cookie(Context ctx) {
        return Results.view().template("cookie").put("cookies", ctx.req().cookies().values());
    }
    
    @POST
    public Result postCookie(Context ctx) {
        ctx.param("name").ifPresent(name -> {
            ctx.param("value").ifPresent(value -> ctx.resp().cookie(name, value));
        });
        
        return Results.redirect("/cookie");
    }
    
    @DELETE
    public Result deleteCookie(Context ctx) {
        // delete all cookies
        ctx.req().cookies().keySet().forEach(ctx.resp()::clearCookie);
        return Results.redirect("/cookie");
    }
}
