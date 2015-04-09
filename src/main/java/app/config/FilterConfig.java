package app.config;

import app.controllers.SomeController;
import net.javapla.jawn.Filters;
import net.javapla.jawn.application.IFilterConfig;
import net.javapla.jawn.filters.LogRequestPropertiesFilter;
import net.javapla.jawn.filters.LogRequestTimingFilter;
import net.javapla.jawn.filters.LogRequestsFilter;

public class FilterConfig implements IFilterConfig {

    @Override
    public void init(Filters filters) {
        
        // Global
        filters.add(new LogRequestsFilter());
        filters.add(new LogRequestTimingFilter());
        
        // Action specific
        filters.add(new LogRequestPropertiesFilter()).to(SomeController.class).forActions("getLang");
//        filters.add(new SystemoutFilter()).to(IndexController.class).forActions("getTest");
    }

}
