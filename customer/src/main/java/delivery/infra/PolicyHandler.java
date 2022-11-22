package delivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import delivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import delivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationLogRepository notificationLogRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Refunded'")
    public void wheneverRefunded_AlertProcess(@Payload Refunded refunded){

        Refunded event = refunded;
        System.out.println("\n\n##### listener AlertProcess : " + refunded + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertProcess(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_AlertProcess(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener AlertProcess : " + accepted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertProcess(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Canceled'")
    public void wheneverCanceled_AlertProcess(@Payload Canceled canceled){

        Canceled event = canceled;
        System.out.println("\n\n##### listener AlertProcess : " + canceled + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertProcess(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_AlertProcess(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener AlertProcess : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertProcess(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_AlertProcess(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener AlertProcess : " + delivered + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertProcess(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_AlertProcess(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener AlertProcess : " + cooked + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertProcess(event);
        

        

    }

}


