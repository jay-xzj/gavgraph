package uk.ac.newcastle.redhat.gavgraph;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages="uk.ac.newcastle.redhat.gavgraph.neo4j")
@SpringBootApplication(scanBasePackages = "uk.ac.newcastle.redhat.gavgraph")
public class GavgraphApplication {
    private static Logger logger = LogManager.getLogger(GavgraphApplication.class.getName());
    private static final Marker SERVER_START_MARKER = MarkerManager.getMarker("SERVER_START");


    public static void main(String[] args) {
        logger.info(SERVER_START_MARKER,"===========GAVGraphApplication is starting!===========");
        SpringApplication.run(GavgraphApplication.class, args);
        logger.info(SERVER_START_MARKER,"=============GAVGraphApplication started!=============");
    }

}
