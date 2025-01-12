package ru.kembrij.smarthomeapi.mqtt;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;


@Service
public class MQTTService implements MQTTServiceInterface, AutoCloseable {

    private MqttClient mqttClient;
    private MqttManagerListener mqttManagerListener;
    private MQTTOptions mqttOptions;
    private Boolean mReady = Boolean.FALSE;
    private CompositeDisposable disposable = new CompositeDisposable();

    MQTTService(MQTTOptions mqttOptions, MqttManagerListener mqttManagerListener) {
        this.mqttOptions = mqttOptions;
        this.mqttManagerListener = mqttManagerListener;
    }



    public void сlose() {

    }


    @Override
    public void publishCommand(String command, String payload) {

    }

    @Override
    public void reconfigure(MQTTOptions newOptions, MqttManagerListener listener) {

    }

    @Override
    public void close() throws MqttException {

    }
}
