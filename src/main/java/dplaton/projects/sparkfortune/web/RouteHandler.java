package dplaton.projects.sparkfortune.web;

import spark.Request;
import spark.Response;

/**
 * Created by platon on 12.05.2016.
 */
public interface RouteHandler {

    String handleRouteGet(Request request, Response response);

    String handleRoutePost(Request request, Response response);

}
