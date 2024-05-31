package br.com.victor.finances_app.service;

import br.com.victor.finances_app.entity.Card;
import br.com.victor.finances_app.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    public Card create(Card card){
        return cardRepository.save(card);
    }

    public Card update(Card card){
        return cardRepository.save(card);
    }

    public List<Card> getAll(){
        return cardRepository.findAll();
    }

    public Optional<Card> getById(Long id){
        return cardRepository.findById(id);
    }

    public void delete(Long id){
        cardRepository.deleteById(id);
    }
}
