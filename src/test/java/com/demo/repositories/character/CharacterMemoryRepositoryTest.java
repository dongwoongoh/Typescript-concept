package com.demo.repositories.character;

import com.demo.domain.entities.Character;
import com.demo.domain.repositories.character.CharacterMemoryRepository;
import com.demo.domain.repositories.character.CharacterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CharacterMemoryRepositoryTest {

    private CharacterRepository characterRepository;
    private final Long id = 1L;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterMemoryRepository();
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
}
