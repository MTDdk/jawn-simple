package app.config;

import net.javapla.jawn.AppContext;
import net.javapla.jawn.Bootstrap;
import net.javapla.jawn.PropertiesImpl;
import app.db.DbModule;

public class AppBootstrap extends Bootstrap {
    
    @Override
    public void init(PropertiesImpl properties) {
        putModules(new DbModule());
    }
    
    @Override
    public void destroy(AppContext context) {
        System.err.println("Closing down");
    }
}
