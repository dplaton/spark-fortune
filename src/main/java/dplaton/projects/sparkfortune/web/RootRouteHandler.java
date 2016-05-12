package dplaton.projects.sparkfortune.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Spark;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by platon on 12.05.2016.
 */
@Component
public class RootRouteHandler implements RouteHandler{

    private static final Logger LOG = LoggerFactory.getLogger(RootRouteHandler.class);

    public static final String ROUTE = "/";

    public String handleRouteGet(Request req, Response res) {
        return "Hello world";
    }

    public String handleRoutePost(Request req, Response res) {
        Spark.halt(HttpServletResponse.SC_BAD_REQUEST, "POST method not allowed");
        return null;
    }

}
