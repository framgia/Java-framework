package mvs.config;

import com.google.common.io.Resources;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by quangminh on 07/07/2017.
 */
@Component
public class LoadConfig {
    @EventListener
    public void init(ContextRefreshedEvent event) {
        AppConfig.client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress("127.0.0.1", 9300));
        URL url = Resources.getResource("application.properties");
        Properties prop = new Properties();
        try {
            prop.load(url.openStream());
            AppConfig.setImageSrc(prop.getProperty("image.source"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
