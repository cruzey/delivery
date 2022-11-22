package delivery.domain;

import delivery.domain.OrderPlaced;
import delivery.domain.OrderCanceled;
import delivery.FrontApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private String options;
    
    
    
    @Embedded
    
    private Address address;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        delivery.external.Payment payment = new delivery.external.Payment();
        // mappings goes here
        FrontApplication.applicationContext.getBean(delivery.external.PaymentService.class)
            .pay(payment);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostRemove
    public void onPostRemove(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
    }
    @PreRemove
    public void onPreRemove(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void orderUpdateStatus(Accepted accepted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        // Example 2:  finding and process
        
        repository().findById(accepted.getId()).ifPresent(order->{
            
            order.status = "order success";
            repository().save(order);


         });

        
    }
    public static void orderUpdateStatus(Canceled canceled){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(canceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderUpdateStatus(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderUpdateStatus(Delivered delivered){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderUpdateStatus(Started started){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(started.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void orderUpdateStatus(Cooked cooked){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(cooked.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
