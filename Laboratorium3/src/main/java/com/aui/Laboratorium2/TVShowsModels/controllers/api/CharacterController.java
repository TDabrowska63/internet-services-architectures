package com.aui.Laboratorium2.TVShowsModels.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.aui.Laboratorium2.TVShowsModels.DTO.*;

import java.util.UUID;

public interface CharacterController {
    @GetMapping("api/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharactersResponse getMultipleCharacters();

    @GetMapping("api/series/{seriesId}/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharacterResponse getSeriesCharacters(
            @PathVariable("seriesId")
            UUID fleetId
    );

    @GetMapping("api/characters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharacterResponse getCharacter(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("api/series/{seriesId}/characters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharacterResponse getSeriesCharacter(
            @PathVariable("seriesId")
            UUID fleetId,
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/characters/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void putCharacter(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutCharacterRequest request
    );

    @PatchMapping("api/characters/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void updateCharacter(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchCharacterRequest request
    );


    @DeleteMapping("api/characters/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    void deleteCharacter(
            @PathVariable("id")
            UUID id
    );
}
