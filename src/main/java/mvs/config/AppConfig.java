package mvs.config;

import org.elasticsearch.client.Client;

/**
 * Created by quangminh on 07/07/2017.
 */
public class AppConfig {
     static String imageSrc;
     static Client client;

    public static Client getClient() {
        return client;
    }

    public static void setClient(Client client) {
        AppConfig.client = client;
    }

    public static String getImageSrc() {
        return imageSrc;
    }

    public static void setImageSrc(String imageSrc) {
        AppConfig.imageSrc = imageSrc;
    }
}
