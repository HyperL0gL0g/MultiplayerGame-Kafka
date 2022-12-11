package Basic;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;



public class KafkaEventConsumer extends    Thread {
    static Properties props = new Properties();
   static KafkaConsumer<String,String> consumer;

    static void init()
    {
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // Set the group ID for the Kafka consumer
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
        // Set the deserializer for the key
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // Set the deserializer for the value
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumer = new KafkaConsumer<String,String>(props);
        consumer.subscribe(Collections.singleton("new-player"));

    }
    @Override
    public void run() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(5000);
            if(!records.isEmpty())
            {
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("Received new record = " + record.value());
                }
            }
        }
    }
}
