package Basic;

import java.util.Scanner;

public class Entry {
    public static void main(String[] args) {
        KafkaEventProducer kp = new KafkaEventProducer();
        KafkaEventProducer.init();
        KafkaEventConsumer.init();
        KafkaEventConsumer t = new KafkaEventConsumer();
        t.start();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter players");
        while(sc.hasNext()) {
            String i = sc.nextLine();
            if(i.equals("X"))
                break;
            else
            kp.createNewPlayer();
        }
    }
}
