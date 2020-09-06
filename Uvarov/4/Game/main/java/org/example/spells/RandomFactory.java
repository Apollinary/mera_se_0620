package org.example.spells;

import java.util.Random;

public class RandomFactory implements SpellFactory{
    SpellFactory[] factories;
    Random random = new Random();

    public RandomFactory(SpellFactory[] factories) {
        this.factories = factories;
    }

    @Override
    public Spell create() {
        int ind = random.nextInt(factories.length);
        return factories[ind].create();
    }
}
