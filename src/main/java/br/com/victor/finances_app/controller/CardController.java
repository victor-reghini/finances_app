package br.com.victor.finances_app.controller;

import br.com.victor.finances_app.dto.CardDTO;
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
    CardDTO create(@RequestBody @Valid Card card){
        return new CardDTO().fromCard(cardService.create(card));
    }

    @PutMapping
    CardDTO update(@RequestBody @Valid Card card){
        return new CardDTO().fromCard(cardService.update(card));
    }

    @GetMapping(path = "/list")
    List<CardDTO> getAll(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long accountId){
        return cardService.getAllWithFilters(userId, accountId).stream().map(card -> new CardDTO().fromCard(card)).toList();
    }

    @GetMapping(path = "/{id}")
    Optional<CardDTO> getUser(@PathVariable Long id){
        return Optional.ofNullable(new CardDTO().fromCard(cardService.getById(id).get()));
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable Long id){
        cardService.delete(id);
    }
}
