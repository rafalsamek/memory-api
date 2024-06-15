package pl.wszib.memoryapi.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wszib.memoryapi.services.CardService;
import pl.wszib.memoryapi.web.models.CardRequest;
import pl.wszib.memoryapi.web.models.CardResponse;

@RestController
@RequestMapping("categories/{categoryId}/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<CardResponse> createCard(@PathVariable Long categoryId, @RequestBody CardRequest request) {
        CardResponse  createdCard = cardService.createCard(categoryId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
    }
}
