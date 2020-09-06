package org.example.control;

import org.example.logic.AbstractCharacter;
import org.example.logic.Scene;

public class Printer {

    public static void printNewGameText() {
        System.out.println("Игра начинается! \nСписок участников:");
    }

    public static void printCurrentRound(int roundNumber) {
        System.out.println("ROUND  " + roundNumber);
    }

    public static void printNewLine(){
        System.out.println();
    }

    public static void printCharacterByPosition(int position){
        System.out.println(Scene.getInstance().getCharactersArrayList().get(position));
    }

    public static void printVictoryText(){
        System.out.println("\n!!!WINNER WINNER CHICKEN DINNER!!! \n"+ Scene.getInstance().getCharactersArrayList().get(0));
    }

    public static void printCharacterChangePositionText(String characterName, int newPosition){
        System.out.println("Персонаж " + characterName + " меняет позицию. Теперь он на позиции " + newPosition);
    }

    public static void printMonsterAttackMessage(String name, AbstractCharacter character, int damage){
        System.out.println("Монстр " + name + " атакует " + character.getName() + " на " + damage
                + " единиц урона. Теперь у него " + character.getHealth() + " здоровья.");
    }

    public static void printCharacterDeath (AbstractCharacter character){
        System.out.println("Персонаж " + character.getName() + " умирает.");
    }

}
