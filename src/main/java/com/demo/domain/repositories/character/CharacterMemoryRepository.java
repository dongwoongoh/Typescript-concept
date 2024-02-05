package com.demo.domain.repositories.character;

import com.demo.domain.entities.Character;

import java.util.LinkedHashMap;

public class CharacterMemoryRepository implements CharacterRepository {

    private static final LinkedHashMap<Long, Character> store = new LinkedHashMap<>();

    @Override
    public Character save(Character character) {
        store.put(character.getId(), character);
        return character;

    }

    @Override
    public Character find(Long id) {
        return store.get(id);
    }
}
