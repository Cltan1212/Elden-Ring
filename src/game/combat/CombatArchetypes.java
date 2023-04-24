package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public abstract class CombatArchetypes {

    private char key;
    private String role;
    private WeaponItem startingWeapon;
    private int startingHitPoint;

    public CombatArchetypes(char key, String role, WeaponItem startingWeapon, int startingHitPoint) {
        this.key = key;
        this.role = role;
        this.startingWeapon = startingWeapon;
        this.startingHitPoint = startingHitPoint;


    }

    public WeaponItem getStartingWeapon() {
        return startingWeapon;
    }

    public int getStartingHitPoint() {
        return startingHitPoint;
    }

    @Override
    public String toString() {
        return role;
    }
}
