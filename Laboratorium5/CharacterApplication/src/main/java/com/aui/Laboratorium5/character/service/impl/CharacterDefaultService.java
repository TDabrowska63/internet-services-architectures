package com.aui.Laboratorium5.character.service.impl;

import com.aui.Laboratorium5.character.entity.Character;
import com.aui.Laboratorium5.character.repository.api.CharacterRepository;
import com.aui.Laboratorium5.character.service.api.CharacterService;
import com.aui.Laboratorium5.series.repository.api.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterDefaultService implements CharacterService{
    private final CharacterRepository repository;
    private final SeriesRepository seriesRepository;

    @Autowired
    public CharacterDefaultService(CharacterRepository repository, SeriesRepository seriesRepository) {
        this.repository = repository;
        this.seriesRepository = seriesRepository;
    }

    @Override
    public void create(Character character) {repository.save(character);}

    @Override
    public void update(Character character) {repository.save(character);}

    @Override
    public void delete(UUID id) {repository.findById(id).ifPresent(repository::delete);}

    @Override
    public void delete(String name) {repository.findByName(name).ifPresent(repository::delete);}

    @Override
    public Optional<Character> find(UUID id) {return repository.findById(id);}

    @Override
    public List<Character> findAll() {return repository.findAll();}

    @Override
    public Optional<List<Character>> findAllBySeries(UUID seriesId) {
        return seriesRepository.findById(seriesId).map(repository::findAllBySeries);
    }

    @Override
    public List<Character> findAllByName(String name) {return  repository.findAllByName(name);}

    @Override
    public Optional<Character> findByName(String name) {return  repository.findByName(name);}
}
