package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    
    private final CashCardRepository cashCardRepository;
                     
    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }

    public CashCardController(){
        this.cashCardRepository = null;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById(@PathVariable("requestedId") Long requestedId) {
        // Long id = requestedId;
        if (requestedId.equals(99L)) {
            CashCard cashCard = new CashCard(99L, 123.45);
            return ResponseEntity.ok(cashCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}