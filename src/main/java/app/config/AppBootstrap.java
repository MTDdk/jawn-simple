package app.config;

import app.db.DbModule;

import com.google.inject.Guice;

import net.javapla.jawn.AppContext;
import net.javapla.jawn.Bootstrap;

public class AppBootstrap extends Bootstrap {
    
    @Override
    public void init(AppContext context) {
        setInjector(Guice.createInjector(new DbModule()));
    }
    
    @Override
    public void destroy(AppContext context) {
        System.err.println("Closing down");
    }
}
