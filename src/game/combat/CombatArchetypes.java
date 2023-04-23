package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public abstract class CombatArchetypes {
    private WeaponItem startingWeapon;
    private int startingHitPoint;

    public CombatArchetypes(WeaponItem startingWeapon, int startingHitPoint) {
        this.startingWeapon = startingWeapon;
        this.startingHitPoint = startingHitPoint;


    }

    public WeaponItem getStartingWeapon() {
        return startingWeapon;
    }

    public int getStartingHitPoint() {
        return startingHitPoint;
    }
}
