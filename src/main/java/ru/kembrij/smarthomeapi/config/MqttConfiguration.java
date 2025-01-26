package ru.kembrij.smarthomeapi.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import ru.kembrij.smarthomeapi.mqtt.MQTTModule;
import ru.kembrij.smarthomeapi.mqtt.MQTTOptions;

@Configuration
@PropertySource("classpath:application.properties")
public class MqttConfiguration {

    @Value("${mqtt.publisher_id}")
    private String publisherId;

    @Value("${mqtt.server_adress}")
    private String serverURI;

    @Bean
    public MQTTOptions mqttOptions () {
        return new MQTTOptions(publisherId, serverURI);
    }


}
