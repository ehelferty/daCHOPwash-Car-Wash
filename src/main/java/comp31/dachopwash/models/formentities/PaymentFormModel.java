package comp31.dachopwash.models.formentities;

import lombok.Data;
import lombok.Getter;

@Data
public class PaymentFormModel {
    
    @Getter 
    Long id;

    @Getter
    Integer invoiceId;

    @Getter
    Double payment;
}
