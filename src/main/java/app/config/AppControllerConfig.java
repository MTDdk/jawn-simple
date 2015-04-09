package app.config;

import net.javapla.jawn.AbstractControllerConfig;
import net.javapla.jawn.PropertiesImpl;
import net.javapla.jawn.trash.controller_filters.TimingFilter;
import app.controllers.MovieController;

public class AppControllerConfig extends AbstractControllerConfig {

    
    @Override
    public void init(PropertiesImpl properties) {
        add(new TimingFilter()).to(MovieController.class).forActions("getXml", "getJson");
    }
}
