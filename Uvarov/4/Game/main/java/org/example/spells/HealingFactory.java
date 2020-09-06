package org.example.spells;

public class HealingFactory implements SpellFactory{
    @Override
    public Spell create() {
        return new HealingSpell();
    }
}
