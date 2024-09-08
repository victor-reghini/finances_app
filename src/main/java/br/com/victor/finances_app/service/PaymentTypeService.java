package br.com.victor.finances_app.service;

import br.com.victor.finances_app.entity.PaymentType;
import br.com.victor.finances_app.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository){
        this.paymentTypeRepository = paymentTypeRepository;
    }

    public PaymentType create(PaymentType paymentType){
        return paymentTypeRepository.save(paymentType);
    }

    public PaymentType update(PaymentType paymentType){
        return paymentTypeRepository.save(paymentType);
    }

    public List<PaymentType> getAll(Long userId){
        return paymentTypeRepository.findPaymentTypeByUserId(userId);
    }

    public Optional<PaymentType> getById(Long id){
        return paymentTypeRepository.findById(id);
    }

    public void delete(Long id){
        paymentTypeRepository.deleteById(id);
    }
}
