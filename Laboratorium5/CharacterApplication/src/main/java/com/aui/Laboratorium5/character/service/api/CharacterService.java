package com.aui.Laboratorium5.character.service.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.aui.Laboratorium5.character.entity.Character;

public interface CharacterService {
    void update(Character character);
    void create(Character character);
    void delete(UUID id);
    void delete(String name);
    Optional<Character> find(UUID id);
    List<Character> findAll();
    Optional<List<Character>> findAllBySeries(UUID fleetId);


    List<Character> findAllByName(String name);
    Optional<Character> findByName(String name);
}
