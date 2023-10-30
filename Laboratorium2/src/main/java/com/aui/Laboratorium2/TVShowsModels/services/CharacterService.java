package com.aui.Laboratorium2.TVShowsModels.services;

import com.aui.Laboratorium2.TVShowsModels.Character;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CharacterService {
    void update(Character character);
    void create(Character character);
    void delete(UUID id);
    void delete(String name);
    Optional<Character> find(UUID id);
    List<Character> findAll();
    Optional<List<Character>> findAllBySeries(UUID seriesId);


    List<Character> findAllByName(String name);
    Optional<Character> findByName(String name);
}
