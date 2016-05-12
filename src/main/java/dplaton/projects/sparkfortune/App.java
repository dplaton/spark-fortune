package dplaton.projects.sparkfortune;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by platon on 12.05.2016.
 */
@ComponentScan({"dplaton.projects.sparkfortune"})
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        context.registerShutdownHook();
    }

}
