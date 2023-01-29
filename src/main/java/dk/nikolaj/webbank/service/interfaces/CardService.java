package dk.nikolaj.webbank.service.interfaces;

import dk.nikolaj.webbank.model.Card;

import java.util.List;

public interface CardService {

    List<Card> listAllCards();

    Card getCard(Long id);

    void saveCard(Card card);

    void deleteCard(Long id);
}
