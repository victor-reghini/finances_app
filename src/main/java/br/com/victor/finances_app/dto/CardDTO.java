package br.com.victor.finances_app.dto;

import br.com.victor.finances_app.entity.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CardDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String accountName;
    private String userName;
    private Integer closingDate;
    private String cardType;

    public CardDTO fromCard(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.id = card.getId();
        cardDTO.name = card.getName();
        cardDTO.description = card.getDescription();
        cardDTO.accountName = card.getAccount().getName();
        cardDTO.userName = card.getUser().getName();
        cardDTO.closingDate = card.getClosingDate();
        cardDTO.cardType = card.getCardType();
        return cardDTO;
    }

    public ObjectMapper createObjectMapper() {
        return new ObjectMapper()
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
