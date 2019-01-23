package entity.attack;

import entity.Entity;
import entity.hitbox.Element;

import java.util.*;

/**
 * Static Class which attribute the damage
 */
public abstract class DamageCalculation {


    /**
     * 
     */
    private final static float strong = 1.5f;

    /**
     * 
     */
    private final static float medium = 1f;

    /**
     * 
     */
    private final static float weak = 0.5f;

    /**
     * Attribute the damage correctly and the side effects
     * @param attackState Specific AttackState which apply
     * @param victim Entity victim of the Attack
     */
    public static void attributeDamage(AttackState attackState, Entity victim) {
        Entity launcher = attackState.getAttackProperty().getEntity();
        if (attackState.getHitboxes().get(0).getAllegency() != victim.getHitbox().getAllegency()) {
            Element e1 = attackState.getHitboxes().get(0).getElement();
            Element e2 = victim.getHitbox().getElement();
            float modifier;
            boolean applyPassif = false;
            if (isMedium(e1, e2)) {
                modifier = medium;
            } else if (isStrong(e1, e2)) {
                modifier = strong;
                applyPassif = true;
            } else {
                modifier = weak;
            }

            int damage = (int) (attackState.getDamage() * modifier);

            victim.damage(damage);

            if (applyPassif) {
                switch (e1) {
                    case Fire:      // Dot target 2dps for 3s
                        victim.addEntityState(new DotState(victim, 3, 2, 500));
                        break;
                    case Plant:     // Life steal 0.1 * damage
                        launcher.heal((int) (damage * 0.1));
                        break;
                    case Water:     // Slow target 0.5 of movement speed for 2s
                        victim.addEntityState(new SlowSate(victim, 2, 0.5));
                        break;
                }
            }
        }
    }

    /**
     * Determine if the element is Strong against the other
     * @param e1 Element 1
     * @param e2 Element 2
     * @return If e1 is strong against e2
     */
    private static boolean isStrong (Element e1, Element e2) {
        if (e1 == Element.Fire && e2 == Element.Plant ||    // Fire against Plant
            e1 == Element.Plant && e2 == Element.Water ||   // Plant against Water
            e1 == Element.Water && e2 == Element.Fire) {    // Water against Fire
            return true;
        }
        return false;
    }

    /**
     * Determine if the element is equivalent of the other
     * @param e1 Element 1
     * @param e2 Element 2
     * @return If is equivalent
     */
    private static boolean isMedium (Element e1, Element e2) {
        return e1 == e2;
    }
}