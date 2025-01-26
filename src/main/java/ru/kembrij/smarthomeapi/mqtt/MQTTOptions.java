package ru.kembrij.smarthomeapi.mqtt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class MQTTOptions {

     public String publisherId;

     public String serverURI;

    public Boolean hasUpdates() {
        return false;
    }
    public Boolean setOptionsUpdated(boolean updated) {
        return false;
    }
}
