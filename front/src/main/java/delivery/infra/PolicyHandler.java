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
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_OrderUpdateStatus(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener OrderUpdateStatus : " + accepted + "\n\n");


        

        // Sample Logic //
        Order.orderUpdateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Canceled'")
    public void wheneverCanceled_OrderUpdateStatus(@Payload Canceled canceled){

        Canceled event = canceled;
        System.out.println("\n\n##### listener OrderUpdateStatus : " + canceled + "\n\n");


        

        // Sample Logic //
        Order.orderUpdateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_OrderUpdateStatus(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener OrderUpdateStatus : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Order.orderUpdateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_OrderUpdateStatus(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener OrderUpdateStatus : " + delivered + "\n\n");


        

        // Sample Logic //
        Order.orderUpdateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Started'")
    public void wheneverStarted_OrderUpdateStatus(@Payload Started started){

        Started event = started;
        System.out.println("\n\n##### listener OrderUpdateStatus : " + started + "\n\n");


        

        // Sample Logic //
        Order.orderUpdateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_OrderUpdateStatus(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener OrderUpdateStatus : " + cooked + "\n\n");


        

        // Sample Logic //
        Order.orderUpdateStatus(event);
        

        

    }

}


