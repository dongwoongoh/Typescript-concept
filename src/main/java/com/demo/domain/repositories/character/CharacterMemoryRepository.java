package com.demo.domain.repositories.character;

import com.demo.domain.entities.Character;

import java.util.LinkedHashMap;

public class CharacterMemoryRepository implements CharacterRepository {

    private static final LinkedHashMap<Long, Character> store = new LinkedHashMap<>();

    @Override
    public void save(Character character) {
        store.put(character.getId(), character);

    }

    @Override
    public Character find(Long id) {
        return store.get(id);
    }

    @Override
    public Character[] findAll() {
        return store.values().toArray(new Character[0]);
    }
}
