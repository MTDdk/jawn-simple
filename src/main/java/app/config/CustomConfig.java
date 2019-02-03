package app.config;

import java.util.Locale;

import org.stringtemplate.v4.AttributeRenderer;

import app.models.Movie;
import net.javapla.jawn.core.templates.config.TemplateConfig;
import net.javapla.jawn.templates.stringtemplate.StringTemplateConfiguration;

public class CustomConfig /*implements TemplateConfig<StringTemplateConfiguration>*/ {

    public void init(Movie config) {
    }
    
    public void init(StringTemplateConfiguration t) {
        t.registerRenderer(Movie.class, new AttributeRenderer() {
            
            @Override
            public String toString(Object o, String formatString, Locale locale) {
                return "kage";
            }
        });
    }

}
