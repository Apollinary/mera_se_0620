package org.example.spells;

import org.example.logic.Mag;
import org.example.logic.Scene;

public class HealingSpell extends Spell {
    private final int ADDITION_HEALTH = 20;

    public HealingSpell() {
        this.spellName = "Исцеление";
    }

    @Override
    public void cast(Scene scene, Mag mag) {
        System.out.println(super.getCommonSpellText(mag.getName(), this.spellName));
        mag.setHealth(mag.getHealth() + ADDITION_HEALTH);
        System.out.println("Маг " + mag.getName() + " исцелен на " + ADDITION_HEALTH + " Теперь у него " + mag.getHealth() + " здоровья");
    }

}
