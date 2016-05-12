package dplaton.projects.playground.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spark.Spark;

import javax.annotation.PostConstruct;

/**
 * Created by platon on 12.05.2016.
 */
@Component
public class WebConfig {

    private static final Logger LOG = LoggerFactory.getLogger(WebConfig.class);

    @Autowired
    private RootRouteHandler rootRouteHandler;

    @Autowired
    private EchoServiceRouteHandler echoServiceRouteHandler;

    @PostConstruct
    public void postContruct() {
        LOG.info("Running post construct");
        Spark.port(8080);
        setupRoutes();
    }

    private final void setupRoutes() {
        Spark.get(RootRouteHandler.ROUTE, (rootRouteHandler::handleRouteGet));
        Spark.post(RootRouteHandler.ROUTE, (rootRouteHandler::handleRoutePost));

        Spark.get(EchoServiceRouteHandler.ROUTE_NAME, (echoServiceRouteHandler::handleRouteGet));
        Spark.post(EchoServiceRouteHandler.ROUTE_NAME, (echoServiceRouteHandler::handleRoutePost));
    }

}
