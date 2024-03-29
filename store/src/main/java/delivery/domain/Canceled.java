package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Canceled extends AbstractEvent {

    private Long id;
    private String foodId;
    private String preference;
    private Long orderId;
    private String status;

    public Canceled(StoreOrder aggregate){
        super(aggregate);
    }
    public Canceled(){
        super();
    }
}
