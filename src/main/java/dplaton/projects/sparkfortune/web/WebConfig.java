package dplaton.projects.sparkfortune.web;

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

    @Autowired
    private FortuneServiceRouteHandler fortuneServiceRouteHandler;

    @PostConstruct
    public void postContruct() {
        LOG.debug("Running post construct");
        Spark.port(8080);
        setupRoutes();
    }

    private final void setupRoutes() {
        Spark.get(RootRouteHandler.ROUTE, (rootRouteHandler::handleRouteGet));
        Spark.post(RootRouteHandler.ROUTE, (rootRouteHandler::handleRoutePost));

        Spark.get(EchoServiceRouteHandler.ROUTE, (echoServiceRouteHandler::handleRouteGet));
        Spark.post(EchoServiceRouteHandler.ROUTE, (echoServiceRouteHandler::handleRoutePost));

        Spark.get(FortuneServiceRouteHandler.ROUTE, (fortuneServiceRouteHandler::handleRouteGet));
        Spark.post(FortuneServiceRouteHandler.ROUTE, (fortuneServiceRouteHandler::handleRoutePost));
    }

}
