package com.demo.domain.repositories.character;

import com.demo.domain.entities.Character;

public interface CharacterRepository {
    void save(Character character);
    Character find(Long id);

    Character[] findAll();
}
