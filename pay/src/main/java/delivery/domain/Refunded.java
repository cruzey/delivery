package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Refunded extends AbstractEvent {

    private Long id;
    private Long orderId;

    public Refunded(Payment aggregate){
        super(aggregate);
    }
    public Refunded(){
        super();
    }
}
