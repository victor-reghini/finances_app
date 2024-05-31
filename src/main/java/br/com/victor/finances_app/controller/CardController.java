package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.entity.Card;
import br.com.victor.finances_app.service.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    Card create(@RequestBody @Valid Card card){
        return cardService.create(card);
    }

    @PutMapping
    Card update(@RequestBody @Valid Card card){
        return cardService.update(card);
    }

    @GetMapping(path = "/list")
    List<Card> getAll(){
        return cardService.getAll();
    }

    @GetMapping(path = "/{id}")
    Optional<Card> getUser(@PathVariable Long id){
        return cardService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        cardService.delete(id);
    }
}
