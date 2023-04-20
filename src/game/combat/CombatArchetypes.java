package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Player;

public abstract class CombatArchetypes {
    private WeaponItem startingWeapon;
    private int startingHitRate;
    public CombatArchetypes(WeaponItem startingWeapon, int startingHitRate) {
        this.startingWeapon = startingWeapon;
        this.startingHitRate = startingHitRate;
    }
}
