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
    @Autowired StoreOrderRepository storeOrderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_StoreUpdateStatus(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener StoreUpdateStatus : " + paid + "\n\n");


        

        // Sample Logic //
        StoreOrder.storeUpdateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_StoreUpdateStatus(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener StoreUpdateStatus : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        StoreOrder.storeUpdateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Delivered'")
    public void wheneverDelivered_StoreUpdateStatus(@Payload Delivered delivered){

        Delivered event = delivered;
        System.out.println("\n\n##### listener StoreUpdateStatus : " + delivered + "\n\n");


        

        // Sample Logic //
        StoreOrder.storeUpdateStatus(event);
        

        

    }

}


