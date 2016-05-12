package dplaton.projects.playground.web;

import org.eclipse.jetty.http.MetaData;
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

    public static final String ROUTE = "/";

    public String handleRouteGet(Request req, Response res) {
        return "Hello world";

    }

    public String handleRoutePost(Request req, Response res) {
        Spark.halt(HttpServletResponse.SC_BAD_REQUEST, "POST method not allowed");
        return "";
    }

}
