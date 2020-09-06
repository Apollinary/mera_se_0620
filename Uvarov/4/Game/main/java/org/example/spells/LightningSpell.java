package org.example.spells;

import org.example.logic.Mag;
import org.example.logic.Scene;

import java.util.Random;

public class LightningSpell extends Spell {
    private final int ADDITION_DAMAGE = 55;

    public LightningSpell() {
        this.spellName = "Молния";
    }

    @Override
    public void cast(Scene scene, Mag mag) {
        System.out.println(super.getCommonSpellText(mag.getName(), this.spellName));
        Random random = new Random();
        int spellTarget;

        do {
            spellTarget = random.nextInt(scene.getCharactersArrayList().size());
        } while (scene.getCharactersArrayList().get(spellTarget).getPosition() == mag.getPosition());
        scene.getCharactersArrayList().get(spellTarget).getDamage(ADDITION_DAMAGE);
        System.out.println("Молния ударяет по " + scene.getCharactersArrayList().get(spellTarget).getName() + ". Он получает " + ADDITION_DAMAGE + " урона, теперь у него " + scene.getCharactersArrayList().get(spellTarget).getHealth() + " здоровья.");
    }
}
