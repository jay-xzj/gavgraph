package uk.ac.newcastle.redhat.gavgraph.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import uk.ac.newcastle.redhat.gavgraph.common.Constant;
import java.io.IOException;


@Configuration
public class AutoBrower {

    @Value("${server.port}")
    private String port;

    @EventListener({ApplicationReadyEvent.class})
    public void ready() {
        System.out.println("Application is almost started ... opening the browser");
        //Homepage URL link here
        String url = "http://localhost:"+port+ Constant.SLASH+"swagger-ui.html";
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}