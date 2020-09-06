package org.example.spells;

public class MigraineSpellFactory implements SpellFactory{
    @Override
    public Spell create() {
        return new MigraineSpell();
    }
}
