package com.aui.Laboratorium2.TVShowsModels.repositories;

import com.aui.Laboratorium2.TVShowsModels.TVSeries;
import com.aui.Laboratorium2.TVShowsModels.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {

    // ************ EX 2 ************
    //quering by category
    List<Character> findAllBySeries(TVSeries series);
    //quering by name
    List<Character> findAllByName(String name);
    Optional<Character> findByName(String name);
}
