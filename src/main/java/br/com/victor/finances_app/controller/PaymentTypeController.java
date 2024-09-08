package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.dto.PaymentTypeDTO;
import br.com.victor.finances_app.entity.PaymentType;
import br.com.victor.finances_app.service.PaymentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paymentType")
public class PaymentTypeController {
    @Autowired
    private PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @PostMapping
    PaymentTypeDTO create(@RequestBody @Valid PaymentType paymentType){
        return new PaymentTypeDTO().fromPaymentType(paymentTypeService.create(paymentType));
    }

    @PutMapping
    PaymentTypeDTO update(@RequestBody @Valid PaymentType paymentType){
        return new PaymentTypeDTO().fromPaymentType(paymentTypeService.update(paymentType));
    }

    @GetMapping(path = "/list")
    List<PaymentTypeDTO> getAll(@RequestParam Long userId){
        return paymentTypeService.getAll(userId).stream().map(paymentType -> new PaymentTypeDTO().fromPaymentType(paymentType)).toList();
    }

    @GetMapping(path = "/{id}")
    Optional<PaymentTypeDTO> getUser(@PathVariable Long id){
        return Optional.ofNullable(new PaymentTypeDTO().fromPaymentType(paymentTypeService.getById(id).get()));
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        paymentTypeService.delete(id);
    }
}
