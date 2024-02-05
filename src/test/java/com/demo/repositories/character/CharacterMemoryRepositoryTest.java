package com.demo.repositories.character;

import com.demo.domain.entities.Character;
import com.demo.domain.repositories.character.CharacterMemoryRepository;
import com.demo.domain.repositories.character.CharacterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CharacterMemoryRepositoryTest {
    private static final CharacterRepository characterRepository = new CharacterMemoryRepository();

    @Test()
    @DisplayName("should save a new character")
    void save() {
        final Character character = new Character(1L);
        characterRepository.save(character);
        final Character findCharacter = characterRepository.find(character.getId());
        Assertions.assertThat(character.getId()).isEqualTo(findCharacter.getId());
    }
}
