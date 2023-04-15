package dk.nikolaj.webbank.controllers;

import dk.nikolaj.webbank.model.CardTransaction;
import dk.nikolaj.webbank.service.interfaces.CardTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/card-transactions")
public class CardTransactionController {

    CardTransactionService cardTransactionService;

    public CardTransactionController(CardTransactionService cardTransactionService) {
        this.cardTransactionService = cardTransactionService;
    }

    @GetMapping("")
    public List<CardTransaction> list() {
        return cardTransactionService.listAllCardTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardTransaction> get(@PathVariable Long id) {
        try {
            CardTransaction cardTransaction = cardTransactionService.getCardTransaction(id);
            return new ResponseEntity<CardTransaction>(cardTransaction, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CardTransaction>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody CardTransaction cardTransaction) {
        cardTransactionService.saveCardTransaction(cardTransaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CardTransaction cardTransaction, @PathVariable Long id) {
        try {
            CardTransaction existCardTransaction = cardTransactionService.getCardTransaction(id);
            cardTransaction.setID(id);
            cardTransactionService.saveCardTransaction(cardTransaction);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        cardTransactionService.deleteCardTransaction(id);
    }
}
