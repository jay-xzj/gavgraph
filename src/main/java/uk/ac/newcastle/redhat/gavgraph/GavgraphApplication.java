package uk.ac.newcastle.redhat.gavgraph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages = "uk.ac.newcastle.redhat.gavgraph")
// Import tomcat autoconfig to avoid starting Jetty, which is on classpath because of neo4j dependencies
// EmbeddedServletContainerAutoConfiguration在springboot 2.0 has already been removed
// @Import(EmbeddedServletContainerAutoConfiguration.EmbeddedTomcat.class)
public class GavgraphApplication {
    private static Logger logger = LogManager.getLogger(GavgraphApplication.class.getName());
    private static final Marker SERVER_START_MARKER = MarkerManager.getMarker("SERVER_START");


    public static void main(String[] args) {
        logger.info(SERVER_START_MARKER,"===========GAVGraphApplication is starting!===========");
        SpringApplication.run(GavgraphApplication.class, args);
        logger.info(SERVER_START_MARKER,"=============GAVGraphApplication started!=============");
    }

}
