package org.example.logic;

public class Characters {
    private static String[] magNames = {"Dumbledore", "Potter", "Houdini", "Mag80lvl", "RealMag2007", "Goodwin", "Voldemort", "Azazello", "Mag1", "Mag2", "Mag3"};
    private static String[] monsterNames = {"Necromorph", "Chupacabra", "Bloodsucker", "Ksenomorf", "Monster1", "Monster2", "Monster3", "Monster4", "Monster5", "SkeletonKing"};

    public static String[] getMagNames() {
        return magNames;
    }

    public static void setMagNames(String[] magNames) {
        Characters.magNames = magNames;
    }

    public static String[] getMonsterNames() {
        return monsterNames;
    }

    public static void setMonsterNames(String[] monsterNames) {
        Characters.monsterNames = monsterNames;
    }
}
