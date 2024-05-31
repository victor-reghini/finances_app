package br.com.victor.finances_app.controller;

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
    PaymentType create(@RequestBody @Valid PaymentType paymentType){
        return paymentTypeService.create(paymentType);
    }

    @PutMapping
    PaymentType update(@RequestBody @Valid PaymentType paymentType){
        return paymentTypeService.update(paymentType);
    }

    @GetMapping(path = "/list")
    List<PaymentType> getAll(){
        return paymentTypeService.getAll();
    }

    @GetMapping(path = "/{id}")
    Optional<PaymentType> getUser(@PathVariable Long id){
        return paymentTypeService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        paymentTypeService.delete(id);
    }
}
