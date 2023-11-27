package com.aui.Laboratorium2.TVShowsModels.controllers.implement;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.aui.Laboratorium2.TVShowsModels.DTO.*;
import com.aui.Laboratorium2.TVShowsModels.controllers.api.CharacterController;
import com.aui.Laboratorium2.TVShowsModels.functions.*;
import com.aui.Laboratorium2.TVShowsModels.services.TVSeriesService;
import com.aui.Laboratorium2.TVShowsModels.services.CharacterService;
import com.aui.Laboratorium2.TVShowsModels.Character;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class CharacterDefaultController implements CharacterController{
    private final CharacterService service;
    private final TVSeriesService seriesService;
    private final CharacterToResponseFunc characterToResponse;
    private final CharactersToResponseFunc charactersToResponse;
    private final RequestToCharacterFunc requestToCharacter;
    private final UpdateCharacterWithRequestFunc updateCharacterWithRequest;

    @Autowired
    public CharacterDefaultController(
            CharacterService service,
            TVSeriesService seriesService,
            CharacterToResponseFunc characterToResponse,
            CharactersToResponseFunc charactersToResponse,
            RequestToCharacterFunc requestToCharacter,
            UpdateCharacterWithRequestFunc updateCharacterWithRequest
    ) {
        this.service = service;
        this.seriesService = seriesService;
        this.characterToResponse = characterToResponse;
        this.charactersToResponse = charactersToResponse;
        this.requestToCharacter = requestToCharacter;
        this.updateCharacterWithRequest = updateCharacterWithRequest;
    }


    @Override
    public GetCharactersResponse getCharacters() {
        return charactersToResponse.apply(service.findAll());
    }

    @Override
    public GetCharactersResponse getSeriesCharacters(UUID seriesId) {
        GetCharactersResponse charactersResponse = service.findAllBySeries(seriesId)
                .map(charactersToResponse)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
        if (charactersResponse.getCharacters().isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return charactersResponse;
    }

    @Override
    public GetCharacterResponse getCharacter(UUID id) {
        return service.find(id)
                .map(characterToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetCharacterResponse getSeriesCharacter(UUID seriesId, UUID id) {
        List<Character> characters = service.findAllBySeries(seriesId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return characters.stream()
                .filter(character -> character.getId().equals(id))
                .findFirst().map(characterToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putCharacter(UUID id, PutCharacterRequest request) {
        seriesService.find(request.getSeriesId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        service.create(requestToCharacter.apply(id,request));
    }

    @Override
    public void updateCharacter(UUID id, PatchCharacterRequest request) {
        service.update(updateCharacterWithRequest.apply(service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),request));
    }

    @Override
    public void deleteCharacter(UUID id) {
        Optional<Character> character = service.find(id);
        if (character.isPresent())
        {
            service.delete(id);
        }else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
