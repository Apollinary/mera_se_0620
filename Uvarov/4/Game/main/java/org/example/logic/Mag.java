package org.example.logic;

import org.example.spells.Spell;
import org.example.spells.SpellsGenerator;

import java.util.ArrayList;
import java.util.Random;

public class Mag extends AbstractCharacter {
    private final int SPELL_LIST_MAX_LENGTH = 2;

    private int spellListLength = new Random().nextInt(SPELL_LIST_MAX_LENGTH) + 1;

    ArrayList<Spell> spellList;

    public Mag(String name) {
        super(name);
        spellList = SpellsGenerator.generateSpellList(spellListLength);
    }

    public Mag(String name, int position) {
        super(name, position);
        spellList = SpellsGenerator.generateSpellList(spellListLength);
    }

    public Mag(int health, String name) {
        super(health, name);
    }

    @Override
    public void doStep() {
        if (isAlive()) {
            Random random = new Random();
            int spellIndex = random.nextInt(spellList.size());
            spellList.get(spellIndex).cast(Scene.getInstance(), this);
            Scene.getInstance().recountPositionsList();
        }
    }

    @Override
    public String toString() {
        return "Mag:" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Mag mag = (Mag) o;

        if (SPELL_LIST_MAX_LENGTH != mag.SPELL_LIST_MAX_LENGTH) return false;
        if (spellListLength != mag.spellListLength) return false; if (getHealth() != mag.getHealth()) return false;
        if (getPosition() != mag.getPosition()) return false;
        if (spellList != mag.spellList) return false;
        return getName() != null ? getName().equals(mag.getName()) : mag.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + SPELL_LIST_MAX_LENGTH;
        result = 31 * result + spellListLength;
        result = 31 * result + (spellList != null ? spellList.hashCode() : 0);
        return result;
    }
}
