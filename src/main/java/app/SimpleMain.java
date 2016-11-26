package app;

import net.javapla.jawn.core.Jawn;
import net.javapla.jawn.core.util.Modes;

public class SimpleMain extends Jawn {
    
    // implicit constructor
    {
        env(Modes.DEV);
        onStartup(() -> System.out.println("My app has started up!"));
    }

    public static void main(String[] args) throws Exception {
        run(SimpleMain::new);
    }
}
