package org.example.spells;

public class MonstersBanishingSpellFactory implements SpellFactory{
    @Override
    public Spell create() {
        return new MonstersBanishingSpell();
    }
}
