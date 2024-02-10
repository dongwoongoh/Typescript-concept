package com.demo.repositories.character;

import com.demo.domain.entities.Character;
import com.demo.domain.repositories.character.CharacterMemoryRepository;
import com.demo.domain.repositories.character.CharacterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CharacterMemoryRepositoryTest {
    private static final CharacterRepository characterRepository = new CharacterMemoryRepository();
    private static final Long id = 1L;

    @Test()
    @DisplayName("should save a new character")
    void save() {
        final Character character = new Character(id);
        characterRepository.save(character);
        final Character findCharacter = characterRepository.find(character.getId());
        Assertions.assertThat(character.getId()).isEqualTo(findCharacter.getId());
    }

    @Test()
    @DisplayName("should success find a character")
    void find() {
        final Character character = characterRepository.find(id);
        Assertions.assertThat(character.getId()).isEqualTo(id);
    }
}
