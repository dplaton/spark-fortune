package dplaton.projects.sparkfortune.web;

import dplaton.projects.sparkfortune.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * Created by platon on 12.05.2016.
 */
@Component
public class FortuneServiceRouteHandler implements RouteHandler{

    public static final String ROUTE ="/fortune/*";

    private static final String OFFENSIVE_PARAM = "offensive";

    @Autowired
    private FortuneService fortuneService;

    @Override
    public String handleRouteGet(Request request, Response response) {
        String[] parameters = request.splat();
        return fortuneService.getFortune(
                    parameters.length > 0 && parameters[0].equals(OFFENSIVE_PARAM));
    }

    @Override
    public String handleRoutePost(Request request, Response response) {
        return null;
    }
}
