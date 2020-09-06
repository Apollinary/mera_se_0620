package org.example.spells;

import org.example.logic.Mag;
import org.example.logic.Scene;

public abstract class Spell {

    protected String spellName = "General Spell";
    protected String spellText = "Маг: %s  читает заклинание: %s \n";

    public Spell() {
    }

    public String getCommonSpellText(String magName, String spellName) {
        return "Маг " + magName + " читает заклинание " + spellName;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public abstract void cast(Scene scene, Mag mag);
}
