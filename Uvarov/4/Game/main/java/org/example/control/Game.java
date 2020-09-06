package org.example.control;

import org.example.logic.Scene;

public class Game {
    private Scene mainScene;

    private int currentRound = 0;

    public Game(Scene scene) {
        this.mainScene = scene;
    }

    public void playRound() {

        Printer.printNewLine();
        Printer.printCurrentRound(++currentRound);
        Printer.printNewLine();

        for (int i=0; i< mainScene.getCharactersArrayList().size();i++) {
            if (mainScene.getCharactersArrayList().get(i).isAlive()) {
                mainScene.getCharactersArrayList().get(i).doStep();
                Scene.getInstance().removeDeadCharacters();
            }
        }

    }

}
