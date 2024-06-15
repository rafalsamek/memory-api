package pl.wszib.memoryapi.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wszib.memoryapi.data.entities.CardEntity;
import pl.wszib.memoryapi.data.entities.CategoryEntity;
import pl.wszib.memoryapi.data.repositories.CardRepository;
import pl.wszib.memoryapi.data.repositories.CategoryRepository;
import pl.wszib.memoryapi.web.models.CardRequest;
import pl.wszib.memoryapi.web.models.CardResponse;

@Service
public class CardService {

    private final CategoryRepository categoryRepository;
    private final CardRepository cardRepository;

    public CardService(CategoryRepository categoryRepository, CardRepository cardRepository) {
        this.categoryRepository = categoryRepository;
        this.cardRepository = cardRepository;
    }

    @Transactional
    public CardResponse createCard(Long categoryId, CardRequest request) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId).orElseThrow(NotFoundException::new);

        CardEntity cardEntity = new CardEntity(request.term(), request.definition());

        CardEntity savedCard = cardRepository.save(cardEntity);

        categoryEntity.addCard(savedCard);

        return new CardResponse(categoryId, savedCard);
    }
}
