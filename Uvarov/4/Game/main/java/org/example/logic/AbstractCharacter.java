package org.example.logic;

import org.example.control.Printer;

public abstract class AbstractCharacter {
    protected final int DEFAULT_CHARACTER_HEALTH = 100;
    protected int health;
    protected String name;
    protected int position;

    public AbstractCharacter(String name) {
        this.health = DEFAULT_CHARACTER_HEALTH;
        this.name = name;
    }

    public AbstractCharacter(String name, int position) {
        this.health = DEFAULT_CHARACTER_HEALTH;
        this.name = name;
        this.position = position;
    }

    public AbstractCharacter(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public abstract void doStep();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        Scene.getInstance().disableCharacterPosition(this.position);
        this.position = position;
        Scene.getInstance().activateCharacterPosition(position);
        Printer.printCharacterChangePositionText(getName(), getPosition());
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void getDamage(int damagePoints) {
        setHealth(getHealth() - damagePoints);
    }

    @Override
    public String toString() {
        return "name=" + name + ", health='" + health + ", position=" + position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCharacter character = (AbstractCharacter) o;

        if (DEFAULT_CHARACTER_HEALTH != character.DEFAULT_CHARACTER_HEALTH) return false;
        if (getHealth() != character.getHealth()) return false;
        if (getPosition() != character.getPosition()) return false;
        return getName() != null ? getName().equals(character.getName()) : character.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = DEFAULT_CHARACTER_HEALTH;
        result = 31 * result + getHealth();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getPosition();
        return result;
    }
}
