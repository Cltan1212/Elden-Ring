package game.combat;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * CombatArchetypes
 * An abstract class serves as a parent class to all the game mode
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 */
public abstract class CombatArchetypes {

    /**
     * A character that represents a game role
     */
    private char key;

    /**
     * The name of the game role
     */
    private String role;

    /**
     * The starting weapon in this game mode
     */
    private WeaponItem startingWeapon;

    /**
     * The starting hit point in this game mode
     */
    private int startingHitPoint;


    /**
     * Constructor
     * @param key The character representing the mode
     * @param role The name of mode
     * @param startingWeapon The starting weapon in this game mode
     * @param startingHitPoint The starting hit point in this game mode
     */
    public CombatArchetypes(char key, String role, WeaponItem startingWeapon, int startingHitPoint) {
        this.key = key;
        this.role = role;
        this.startingWeapon = startingWeapon;
        this.startingHitPoint = startingHitPoint;
    }

    /**
     * Getter to get the starting weapon
     * @return the starting weapon
     */
    public WeaponItem getStartingWeapon() {
        return startingWeapon;
    }

    /**
     * Getter to get the starting hit point
     * @return the starting hit point
     */
    public int getStartingHitPoint() {
        return startingHitPoint;
    }

    /**
     * ToString method
     * @return the name of the game mode
     */
    @Override
    public String toString() {
        return role;
    }
}
