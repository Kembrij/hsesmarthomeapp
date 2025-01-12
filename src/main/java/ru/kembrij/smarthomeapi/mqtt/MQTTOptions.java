package ru.kembrij.smarthomeapi.mqtt;

import org.springframework.stereotype.Component;

@Component
public class MQTTOptions {

    public Boolean hasUpdates() {
        return false;
    }

    public Boolean setOptionsUpdated(boolean updated) {
        return false;
    }
}
