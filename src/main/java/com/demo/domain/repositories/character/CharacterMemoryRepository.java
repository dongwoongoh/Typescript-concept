package com.demo.domain.repositories.character;

import com.demo.domain.entities.Character;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterMemoryRepository implements CharacterRepository {

    private final LinkedHashMap<Long, Character> store = new LinkedHashMap<>();

    @Override
    public synchronized void save(Character character) {
        if (store.containsKey(character.getId())) {
            throw new IllegalArgumentException(character.getId() + " already exists.");
        } else {
            store.put(character.getId(), character);
        }
    }

    @Override
    public Character find(Long id) {
        return store.get(id);
    }

    @Override
    public List<Character> findAll(int page, int size) {
        int start = page * size;
        return store.values().stream()
                .skip(start)
                .limit(size)
                .collect(Collectors.toList());
    }
}
