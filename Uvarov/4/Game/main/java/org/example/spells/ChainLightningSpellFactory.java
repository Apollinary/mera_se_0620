package org.example.spells;

public class ChainLightningSpellFactory implements SpellFactory{
    @Override
    public Spell create() {
        return new ChainLightningSpell();
    }
}
