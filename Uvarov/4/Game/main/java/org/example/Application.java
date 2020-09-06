package org.example;

import org.example.control.Game;
import org.example.control.Printer;
import org.example.logic.Scene;

import java.nio.channels.Pipe;


public class Application {

    private boolean running = true;

    public static void main(String[] args) {
        new Application().run();

    }

    public void run() {

        Printer.printNewGameText();
        Scene.getInstance().generateScene();
        for (int i = 0; i < Scene.getInstance().getCharactersArrayList().size(); i++) {
            Printer.printCharacterByPosition(i);
        }

        Game game = new Game(Scene.getInstance());

        while (running) {
            game.playRound();
            if (Scene.getInstance().getCharactersArrayList().size() == 1) {
                Printer.printVictoryText();
                running = false;
            }
        }

        System.exit(0);
    }
}
