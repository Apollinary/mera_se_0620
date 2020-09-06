package org.example.logic;

import org.example.control.Printer;
import org.example.exceptions.NoSuchCharacterException;

public class Monster extends AbstractCharacter {
    private final int SIMPLE_ATTACK_DAMAGE = 40;
    private final int RAGE_ATTACK_DAMAGE = 60;

    public Monster() {
        this(100, "Monster");
    }

    public Monster(String name) {
        super(name);
    }

    public Monster(String name, int position) {
        super(name, position);
    }

    public Monster(int health, String name) {
        super(health, name);
    }

    @Override
    public void doStep() {
        if (isAlive()) {
            if (isCharacterInLeftPosition() && isCharacterInRightPosition()) {
                rageAttack();
            } else if (isCharacterInLeftPosition()) {
                simpleAttack(position - 1);
            } else if (isCharacterInRightPosition()) {
                simpleAttack(position + 1);
            } else {
                setPosition(findPositionCloseToOpponent());
            }

            Scene.getInstance().recountPositionsList();
        }
    }

    public void simpleAttack(int position) {
        try {
            Scene.getInstance().getCharacterByPosition(position).getDamage(SIMPLE_ATTACK_DAMAGE);
            Printer.printMonsterAttackMessage(getName(), Scene.getInstance().getCharacterByPosition(position), SIMPLE_ATTACK_DAMAGE);
        } catch (NoSuchCharacterException e) {
            e.printStackTrace();
        }
    }

    public void rageAttack() {
        try {
            Scene.getInstance().getCharacterByPosition(position - 1).getDamage(RAGE_ATTACK_DAMAGE);
            Scene.getInstance().getCharacterByPosition(position + 1).getDamage(RAGE_ATTACK_DAMAGE);
            Printer.printMonsterAttackMessage(getName(), Scene.getInstance().getCharacterByPosition(position - 1), RAGE_ATTACK_DAMAGE);
            Printer.printMonsterAttackMessage(getName(), Scene.getInstance().getCharacterByPosition(position + 1), RAGE_ATTACK_DAMAGE);
        } catch (NoSuchCharacterException e) {
            e.printStackTrace();
        }
    }


    public boolean isCharacterInLeftPosition() {
        return Scene.getInstance().isCharacterInPosition(position - 1);
    }

    public boolean isCharacterInRightPosition() {
        return Scene.getInstance().isCharacterInPosition(position + 1);
    }

    public int findPositionCloseToOpponent() {
        int closestRightOpponentPosition = position;
        int closestLeftOpponentPosition = position;

        while (closestLeftOpponentPosition > 0 && !Scene.getInstance().isCharacterInPosition(closestLeftOpponentPosition - 1)) {
            closestLeftOpponentPosition--;
        }
        if (closestLeftOpponentPosition == 0) {
            closestLeftOpponentPosition = Integer.MIN_VALUE / 2;
        }
        while (closestRightOpponentPosition < Scene.getInstance().getPositionsList().length - 1 && !Scene.getInstance().isCharacterInPosition(closestRightOpponentPosition + 1)) {
            closestRightOpponentPosition++;
        }
        if (closestRightOpponentPosition == 10) {
            closestRightOpponentPosition = Integer.MAX_VALUE / 2;
        }

        return Math.abs(position - closestLeftOpponentPosition) < Math.abs(position - closestRightOpponentPosition) ? closestLeftOpponentPosition : closestRightOpponentPosition;
    }

    @Override
    public String toString() {
        return "Monster:" + super.toString();
    }
}
