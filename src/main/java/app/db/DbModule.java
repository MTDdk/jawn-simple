package app.db;

import net.javapla.jawn.core.spi.ApplicationConfig;
import net.javapla.jawn.core.spi.ModuleBootstrap;

public class DbModule implements ModuleBootstrap {
    
    @Override
    public void bootstrap(ApplicationConfig config) {
        config.binder().bind(MoviesDB.class).to(ArrayMoviesDB.class);
    }
}
