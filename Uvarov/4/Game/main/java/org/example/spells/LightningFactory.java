package org.example.spells;

public class LightningFactory implements SpellFactory{
    @Override
    public Spell create() {
        return new LightningSpell();
    }
}
