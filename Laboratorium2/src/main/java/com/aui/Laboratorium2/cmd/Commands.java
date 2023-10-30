package com.aui.Laboratorium2.cmd;

import com.aui.Laboratorium2.TVShowsModels.services.CharacterService;
import com.aui.Laboratorium2.TVShowsModels.services.TVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.aui.Laboratorium2.ShutdownManager;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class Commands implements CommandLineRunner{
    // ************ EX 5 ************
    private final TVSeriesService seriesService;
    private final CharacterService characterService;

    @Autowired
    public Commands(TVSeriesService seriesService, CharacterService characterService) {
        this.seriesService = seriesService;
        this.characterService = characterService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Commands:\n--> help\n--> get_characters\n--> get_series\n--> add_character\n--> delete_character\n--> end");
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");;
        String command;
        main_loop:
        while (true){
            command = scanner.next();
            switch (command){
                case "help":
                    System.out.println("Commands:\n--> help\n--> get_characters\n--> get_series\n--> add_character\n--> delete_character\n--> end");
                    break;
                case "get_series":
                    System.out.println(seriesService.findAll());
                    break;
                case "get_characters":
                    System.out.println(characterService.findAll());
                    break;
                case "delete_character":
                    System.out.println("Enter name: ");
                    try{
                        command = scanner.next();
                        characterService.delete(command);
                        System.out.println("Character deleted");
                    }catch (IllegalArgumentException ex){
                        System.out.println("Incorrect character name");
                    }
                    break;
                case "add_character":
                    UUID id = UUID.randomUUID();
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.println("Enter series name: ");
                    String seriesName = scanner.next();
                    Optional<com.aui.Laboratorium2.TVShowsModels.TVSeries> series = seriesService.findByName(seriesName);
                    if (series.isPresent()){
                        com.aui.Laboratorium2.TVShowsModels.Character character = com.aui.Laboratorium2.TVShowsModels.Character.builder().id(id).name(name).age(age).series(series.get()).build();
                        characterService.create(character);
                        System.out.println("Character added");
                    }
                    else{
                        System.out.println("Wrong series name");
                    }
                    break;
                case "end":
                    ShutdownManager shutdownManager= new ShutdownManager();
                    shutdownManager.initiateShutdown(0);
                    break main_loop;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}
