package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    

    @GetMapping("/{id}")
    public ResponseEntity<CashCard> findByID(@PathVariable Long id) {
        if(id != 99){
            return ResponseEntity.notFound().build();
        }
        CashCard cashCard = new CashCard(id, 123.45);
        return ResponseEntity.ok(cashCard);
    }
    
}
