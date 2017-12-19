package io.pivotal.spring.mqtt.boot.demo

import org.apache.commons.lang3.RandomUtils
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import static org.assertj.core.api.Assertions.assertThat

/**
 * Created by wlund on 12/19/17.
 */
@RunWith(SpringRunner)
@SpringBootTest
class MqttConnectionTest {
    static String brokerIp  = "localhost";
    static String username  = "guest";
    static String password  = "guest";
    static int    qos       = 1;
    static int    nbClients = 100;

    @Test
    void testMqttCon() {
        String broker = "tcp://" + brokerIp + ":1883";
        MemoryPersistence persistence = new MemoryPersistence();
        try {
            for (int i = 0; i < nbClients; i++) {
                int id = RandomUtils.nextInt();
                MqttClient sampleClient = new MqttClient(broker, String.valueOf(id), persistence);
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setUserName(username);
                connOpts.setPassword(password.toCharArray());
                connOpts.setCleanSession(true); //remove MQTT session objects, like queue created by RabbitMQ
                sampleClient.connect(connOpts); //just connect, don't subscribe
                assertThat(sampleClient.isConnected(), true)
            }

            System.out.println("done connecting");
            try {
                Thread.sleep(20000);
            } catch (Exception e) { }
        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

}
