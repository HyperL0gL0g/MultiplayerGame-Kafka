package Basic;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;


public class KafkaEventProducer {
     static Properties props = new Properties();
     static  void init()
    {
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    }

    public static void main(String[] args) throws InterruptedException {

    }
    void createNewPlayer()
    {
            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("new-player", "my-key", "Hello there , new Player has joined, ID = " + UUID.randomUUID().toString());
            producer.send(record);
            System.out.println("Pushed new Player to waiting room......");
            producer.flush();
    }
}
