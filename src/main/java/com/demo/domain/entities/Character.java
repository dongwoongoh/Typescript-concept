package com.demo.domain.entities;

public class Character {
    private Long id;

    public Character(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
