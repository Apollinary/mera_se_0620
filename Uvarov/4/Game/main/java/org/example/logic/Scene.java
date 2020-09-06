package org.example.logic;

import org.example.control.Printer;
import org.example.control.RandomArrayGenerator;
import org.example.exceptions.NoSuchCharacterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Scene {
    public static final int MAX_CHARACTERS_NUMBER = 10;
    public static final int MIN_CHARACTERS_NUMBER = 2;
    public static final int MAGS_NUMBER = new Random().nextInt(MAX_CHARACTERS_NUMBER / 2) + 1;
    public static final int MONSTERS_NUMBER = new Random().nextInt(MAX_CHARACTERS_NUMBER / 2 + 1);

    private ArrayList<AbstractCharacter> charactersArrayList;

    private static Scene instance;

    public int[] positionsList = new int[MAX_CHARACTERS_NUMBER];

    private Scene() {
    }

    public static Scene getInstance() {
        if (instance == null) {
            instance = new Scene();
        }
        return instance;
    }

    public void generateScene() {
        String[] magNames = Characters.getMagNames();
        String[] monsterNames = Characters.getMonsterNames();

        Random rnd = new Random();
        int numberOfCharacters = rnd.nextInt(MAX_CHARACTERS_NUMBER - MIN_CHARACTERS_NUMBER + 1) + MIN_CHARACTERS_NUMBER;

        charactersArrayList = new ArrayList<>(numberOfCharacters);

        int currentPosition = 0;
        Integer[] randomPositionsArray = RandomArrayGenerator.getRandomIndexesSet(MAX_CHARACTERS_NUMBER);

        Integer[] magsNamesSet = RandomArrayGenerator.getRandomIndexesSet(MAGS_NUMBER);
        for (int i = 0; i < MAGS_NUMBER; i++) {
            charactersArrayList.add(new Mag(magNames[magsNamesSet[i]], randomPositionsArray[currentPosition]));
            currentPosition++;
        }

        Integer[] monstersNamesSet = RandomArrayGenerator.getRandomIndexesSet(MONSTERS_NUMBER);
        for (int i = 0; i < MONSTERS_NUMBER; i++) {
            charactersArrayList.add(new Monster(monsterNames[monstersNamesSet[i]], randomPositionsArray[currentPosition]));
            currentPosition++;
        }

        recountPositionsList();
    }

    public boolean removeCharacter(String name) {
        for (int i = 0; i < charactersArrayList.size(); i++) {
            if (charactersArrayList.get(i).getName() == name) {
                positionsList[charactersArrayList.get(i).getPosition()] = 0;
                charactersArrayList.remove(charactersArrayList.get(i));
                return true;
            }
        }
        return false;
    }

    public void removeDeadCharacters() {
        for (int i = 0; i < charactersArrayList.size(); i++) {
            if (!charactersArrayList.get(i).isAlive()) {
                Printer.printCharacterDeath(charactersArrayList.get(i));
                removeCharacter(charactersArrayList.get(i).getName());
            }
        }
        recountPositionsList();
    }

    public ArrayList<AbstractCharacter> getCharactersArrayList() {
        return charactersArrayList;
    }

    public void setCharactersArrayList(ArrayList<AbstractCharacter> charactersArrayList) {
        this.charactersArrayList = charactersArrayList;
    }

    public boolean isCharacterInPosition(int position) {
        if (position >= 0 && position < MAX_CHARACTERS_NUMBER) {
            return positionsList[position] == 1;
        }
        return false;
    }

    public void recountPositionsList() {
        for (int i = 0; i < positionsList.length; i++) {
            for (AbstractCharacter character : charactersArrayList) {
                if (character.getPosition() == i) {
                    positionsList[i] = 1;
                }
            }
        }
    }

    public int[] getPositionsList() {
        return positionsList;
    }

    public void disableCharacterPosition(int position) {
        positionsList[position] = 0;
    }

    public void activateCharacterPosition(int position) {
        positionsList[position] = 1;
    }

    public AbstractCharacter getCharacterByPosition(int position) throws NoSuchCharacterException {
        for (AbstractCharacter character : charactersArrayList) {
            if (character.getPosition() == position) {
                return character;
            }
        }
        throw new NoSuchCharacterException("There is no character in position " + position);
    }


}

