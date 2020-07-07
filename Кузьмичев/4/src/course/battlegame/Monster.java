package course.battlegame;

import java.util.Random;

public class Monster extends Character {
    private Integer power;
    private static Integer MIN_POWER;
    private static Integer MAX_POWER;

    {
      Monster.MIN_POWER = 5;
      Monster.MAX_POWER = 20;
    }

    public Monster(String name, Integer maxHeatPoint) {
        super(name, maxHeatPoint);
        this.power = new Random().nextInt(Monster.MAX_POWER - Monster.MIN_POWER) + Monster.MIN_POWER;
    }

    private void heatCharacter(Character character) {
        System.out.println("Monster \"" + this.getName() + "\" attack \"" + character.getName() + "\" on " + this.power + " hp");
        character.changeHitPoints(this, -this.power);
    }

    void step(Position[] positions) {
        Integer randomCharacter;

        while (true) {
            randomCharacter = new Random().nextInt(positions.length);
            if (positions[randomCharacter].getCharacter() != this) {
                break;
            }
        }

        heatCharacter(positions[randomCharacter].getCharacter());
    }

    protected void changeHitPoints(Character character, Integer hitPoints)
    {
        this.hitPoints += hitPoints;

        if (this.hitPoints > this.maxHitPoint) {
            this.hitPoints = this.maxHitPoint;
            return;
        }

        if (this.hitPoints < 0) {
            this.hitPoints = 0;
        }
    }
}
