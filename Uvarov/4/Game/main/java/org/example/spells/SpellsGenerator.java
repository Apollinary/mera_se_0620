package org.example.spells;

import org.example.logic.Mag;

import java.util.ArrayList;

public class SpellsGenerator {

    public static ArrayList<Spell> generateSpellList(int spellListLength) {
        ArrayList<Spell> spellList = new ArrayList<>(spellListLength);

        RandomFactory randomFactory = new RandomFactory(new SpellFactory[]{
                new HealingFactory(),
                new LightningFactory(),
                new ChainLightningSpellFactory(),
                new MigraineSpellFactory(),
                new MonstersBanishingSpellFactory()
        });

        for (int i = 0; i < spellListLength; i++) {
            spellList.add(randomFactory.create());
        }

        return spellList;
    }
}
