package dplaton.projects.sparkfortune.web;

import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;
import org.springframework.stereotype.Component;
import spark.Request;
import spark.Response;
import spark.Spark;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by platon on 12.05.2016.
 */
@Component
public class EchoServiceRouteHandler implements RouteHandler{

    public static final String ROUTE ="/echo";

    @Override
    public String handleRouteGet(Request request, Response response) {
        Spark.halt(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "This endpoint doesn't support GET method");
        return null;
    }

    @Override
    public String handleRoutePost(Request request, Response response) {
        MultiMap<String> params = new MultiMap<>();
        UrlEncoded.decodeTo(request.body(), params, "UTF-8");

        if (!params.containsKey("message")) {
            Spark.halt(HttpServletResponse.SC_BAD_REQUEST,"Required parameter 'message' not found.");
            return null;
        }

        return params.getString("message");
    }
}
