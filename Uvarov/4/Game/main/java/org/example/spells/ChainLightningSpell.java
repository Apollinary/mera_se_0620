package org.example.spells;

import org.example.logic.AbstractCharacter;
import org.example.logic.Mag;
import org.example.logic.Scene;


public class ChainLightningSpell extends Spell{
    private final int ADDITION_DAMAGE = 10;

    public ChainLightningSpell() {
        this.spellName = "Цепная молния";
    }

    @Override
    public void cast(Scene scene, Mag mag) {
        System.out.println(super.getCommonSpellText(mag.getName(), this.spellName));

        for (AbstractCharacter character : scene.getCharactersArrayList()){
            if (character.equals(mag)){
                continue;
            }else {
                character.getDamage(ADDITION_DAMAGE);
                System.out.println("Цепная молния ударяет по " + character.getName() + ". Он получает " + ADDITION_DAMAGE + " урона, теперь у него " + character.getHealth() + " здоровья.");
            }
        }
    }
}
