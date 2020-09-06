package org.example.spells;

import org.example.logic.AbstractCharacter;
import org.example.logic.Mag;
import org.example.logic.Monster;
import org.example.logic.Scene;

public class MigraineSpell extends Spell{
    private final int ADDITION_DAMAGE = 20;

    public MigraineSpell() {
        this.spellName = "Мигрень";
    }

    @Override
    public void cast(Scene scene, Mag mag) {
        System.out.println(super.getCommonSpellText(mag.getName(), this.spellName));

        for (AbstractCharacter character : scene.getCharactersArrayList()){
            if ((character instanceof Monster) || (character.equals(mag))){
                continue;
            }else {
                character.getDamage(ADDITION_DAMAGE);
                System.out.println("У персонажа " + character.getName() + " наступает мигрень. Он получает " + ADDITION_DAMAGE + " урона, теперь у него " + character.getHealth() + " здоровья.");
            }
        }
    }
}
