package game.combatArchetypes;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public class CombatArchetypes {
    private WeaponItem startingWeapon;
    private int startingHitPoint;


    public CombatArchetypes(WeaponItem startingWeapon, int startingHitPoint){
        setStartingWeapon(startingWeapon);
        setStartingHitPoint(startingHitPoint);
    }

    public WeaponItem getStartingWeapon() {
        return startingWeapon;
    }

    public void setStartingWeapon(WeaponItem startingWeapon) {
        this.startingWeapon = startingWeapon;
    }

    public void setStartingHitPoint(int startingHitPoint) {
        this.startingHitPoint = startingHitPoint;
    }

    public int getStartingHitPoint() {
        return startingHitPoint;
    }
}
