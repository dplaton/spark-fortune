package dplaton.projects.playground.web;

import spark.Request;
import spark.Response;

/**
 * Created by platon on 12.05.2016.
 */
public class FortuneServiceRouteHandler implements RouteHandler{

    public static final String ROUTE_NAME="/fortune";

    @Override
    public String handleRouteGet(Request request, Response response) {
        return null;
    }

    @Override
    public String handleRoutePost(Request request, Response response) {
        return null;
    }
}
