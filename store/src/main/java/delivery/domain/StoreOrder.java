package delivery.domain;

import delivery.domain.Cooked;
import delivery.domain.Accepted;
import delivery.domain.Canceled;
import delivery.domain.Started;
import delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="StoreOrder_table")
@Data

public class StoreOrder  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String preference;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String test;

    @PostPersist
    public void onPostPersist(){


        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();



        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();



        Started started = new Started(this);
        started.publishAfterCommit();

    }

    public static StoreOrderRepository repository(){
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(StoreOrderRepository.class);
        return storeOrderRepository;
    }



    public void finishCook(){
    }
    public void accept(){
    }
    public void reject(){
    }
    public void startCook(){
    }

    public static void storeUpdateStatus(Paid paid){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        // Example 2:  finding and process
        
        repository().findById(paid.getId()).ifPresent(storeOrder->{
            
            storeOrder.orderId = paid.getOrderId();
            storeOrder.status = "paid";
            repository().save(storeOrder);


         });

        
    }
    public static void storeUpdateStatus(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        // Example 2:  finding and process
        
        StoreOrder st = repository().findByOrderId((orderCanceled.getId())); 
        if(st.status == "paid"){
            st.status = "orderCanceled";
            repository().save(st);
        }
        else{
            return;
        }


        
    }
    public static void storeUpdateStatus(Delivered delivered){

        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        // Example 2:  finding and process
        
        repository().findById(delivered.getId()).ifPresent(storeOrder->{
            
            storeOrder.orderId = delivered.getOrderId();
            storeOrder.status = "delivered";
            repository().save(storeOrder);


         });

        
    }


}
