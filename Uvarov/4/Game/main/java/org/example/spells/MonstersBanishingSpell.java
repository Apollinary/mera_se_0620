package org.example.spells;

import org.example.logic.AbstractCharacter;
import org.example.logic.Mag;
import org.example.logic.Scene;

public class MonstersBanishingSpell extends Spell{
    private final int ADDITION_DAMAGE = 20;

    public MonstersBanishingSpell() {
        this.spellName = "Изгнание монстров";
    }

    @Override
    public void cast(Scene scene, Mag mag) {
        System.out.println(super.getCommonSpellText(mag.getName(), this.spellName));

        for (AbstractCharacter character : scene.getCharactersArrayList()){
            if (character instanceof Mag){
                continue;
            }else {
                character.getDamage(ADDITION_DAMAGE);
                System.out.println("Изгнание монстров попадает в " + character.getName() + ". Он получает " + ADDITION_DAMAGE + " урона, теперь у него " + character.getHealth() + " здоровья.");
            }
        }
    }
}
