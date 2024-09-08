package br.com.victor.finances_app.dto;

import br.com.victor.finances_app.entity.PaymentType;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class PaymentTypeDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String user;

    public PaymentTypeDTO fromPaymentType(PaymentType paymentType) {
        PaymentTypeDTO paymentTypeDTO = new PaymentTypeDTO();
        paymentTypeDTO.id = paymentType.getId();
        paymentTypeDTO.name = paymentType.getName();
        paymentTypeDTO.description = paymentType.getDescription();
        paymentTypeDTO.user = paymentType.getUser().getName();
        return paymentTypeDTO;
    }
}
