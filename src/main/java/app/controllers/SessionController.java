package app.controllers;

import net.javapla.jawn.core.Controller;
import net.javapla.jawn.core.http.Session;
import net.javapla.jawn.core.util.StringUtil;

public class SessionController extends Controller {

    @Override
    public void index() {
        Session session = session();
        
        String name = param("name").asString();
        String value = param("value").asString();
        log().debug("name {} + value {}", name, value);
        
        if (!StringUtil.blank(name) && !StringUtil.blank(value)) {
            session.put(name, value);
            log().debug("putting in values in the session");
        }
        
        respond().json(session.getData());
    }
}
