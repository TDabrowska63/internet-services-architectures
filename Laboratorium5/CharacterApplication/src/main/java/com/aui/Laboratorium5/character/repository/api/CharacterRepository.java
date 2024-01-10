package com.aui.Laboratorium5.character.repository.api;

import com.aui.Laboratorium5.series.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aui.Laboratorium5.character.entity.Character;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {
    List<Character> findAllBySeries(Series series);
    List<Character> findAllByName(String name);
    Optional<Character> findByName(String name);
}

