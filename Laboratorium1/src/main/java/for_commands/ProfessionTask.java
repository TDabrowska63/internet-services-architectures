package for_commands;

import model.TVSeries;

import java.util.List;

public class ProfessionTask implements Runnable {

    private final List<TVSeries> professions;

    public ProfessionTask(List<TVSeries> professions) {
        this.professions = professions;
    }

    @Override
    public void run() {
        professions.forEach(profession -> {
            System.out.println("Processing profession: " + profession.getName());
            profession.getCharacters().forEach(character -> {
                System.out.println("\tProcessing character: " + character.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}
