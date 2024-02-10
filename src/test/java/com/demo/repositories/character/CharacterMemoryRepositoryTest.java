package com.demo.repositories.character;

import com.demo.domain.entities.Character;
import com.demo.domain.repositories.character.CharacterMemoryRepository;
import com.demo.domain.repositories.character.CharacterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterMemoryRepositoryTest {

    private CharacterRepository characterRepository;
    private final Long id = 1L;
    long paginateId = 2;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterMemoryRepository();
        for (long i = paginateId; i <= 6; i++) {
            characterRepository.save(new Character(i));
        }
    }

    @Test
    @DisplayName("should save a new character")
    void save_success() {
        final Character character = new Character(id);
        characterRepository.save(character);
        final Character findCharacter = characterRepository.find(character.getId());
        Assertions.assertThat(findCharacter).isNotNull();
        Assertions.assertThat(character.getId()).isEqualTo(findCharacter.getId());
    }

    @Test
    @DisplayName("should throw exception when saving a character with existing id")
    void save_duplicateId_throwsException() {
        final Character character = new Character(id);
        characterRepository.save(character);
        Assertions.assertThatThrownBy(() -> characterRepository.save(character))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("already exists");
    }

    @Test
    @DisplayName("should success find a character")
    void find() {
        final Character character = new Character(id);
        characterRepository.save(character);
        final Character foundCharacter = characterRepository.find(id);
        Assertions.assertThat(foundCharacter).isNotNull();
        Assertions.assertThat(foundCharacter.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("should return the correct pages of characters")
    void findAllPagination() {
        int pageSize = 2;
        int totalPages = (int) Math.ceil(5.0 / pageSize);
        for (int page = 0; page < totalPages; page++) {
            int expectedSize = (page < totalPages - 1) ? pageSize : 1;
            List<Character> pageContent = characterRepository.findAll(page, pageSize);
            Assertions.assertThat(pageContent).hasSize(expectedSize);
            for (int i = 0; i < pageContent.size(); i++) {
                Assertions.assertThat(pageContent.get(i).getId()).isEqualTo((long) page * pageSize + i + paginateId);
            }
        }
    }
}
