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
    List<Character> findAllBySeries(TVSeries series);
    List<Character> findAllByName(String name);
    Optional<Character> findByName(String name);
}
