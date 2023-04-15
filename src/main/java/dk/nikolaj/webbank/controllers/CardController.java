package dk.nikolaj.webbank.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {
    // TODO implement missing CRUD operations
//
//    CardService cardService;
//
//    public CardController(CardService cardService) {
//        this.cardService = cardService;
//    }
//
//    @GetMapping("")
//    public List<Card> list() {
//        return cardService.listAllCards();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Card> get(@PathVariable Long id) {
//        try {
//            Card card = cardService.getCard(id);
//            return new ResponseEntity<Card>(card, HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Card>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/")
//    public void add(@RequestBody Card card) {
//        cardService.saveCard(card);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update(@RequestBody Card card, @PathVariable Long id) {
//        try {
//            Card existCard = cardService.getCard(id);
//            card.setID(id);
//            cardService.saveCard(card);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//
//        cardService.deleteCard(id);
//    }
}
