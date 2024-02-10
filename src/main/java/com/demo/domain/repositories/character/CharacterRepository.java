package com.demo.domain.repositories.character;

import com.demo.domain.entities.Character;

import java.util.List;

public interface CharacterRepository {
    void save(Character character);
    Character find(Long id);
    List<Character> findAll(int page, int size);
}
