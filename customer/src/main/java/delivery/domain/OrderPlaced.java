package delivery.domain;

import delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private String customerId;
    private String preference;
}
