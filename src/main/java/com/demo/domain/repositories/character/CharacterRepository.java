package com.demo.domain.repositories.character;

import com.demo.domain.entities.Character;

public interface CharacterRepository {
    Character save(Character character);
    Character find(Long id);
}
