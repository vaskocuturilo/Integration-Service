package webconfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

/**
 * An interface web configuration..
 */
@Config.Sources({"classpath:${env}.properties"})
public interface WebConfig extends Config {

    /**
     * Value BASE_CONFIG.
     */
    WebConfig BASE_CONFIG = ConfigFactory.create(WebConfig.class, System.getenv(), System.getProperties());

    /**
     * Value service.url.
     *
     * @return url.
     */
    @Key("service.url")
    String getUrl();

    /**
     * Value mock.url.
     *
     * @return url.
     */
    @Key("mock.url")
    String getMockUrl();
}
