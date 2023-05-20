package game.actors.enemies.stormveilCastleEnemy;

import game.utils.RandomNumberGenerator;
import game.weapons.skeletalDropable.Grossmesser;

public class GodrickSoldier extends StormveilCastleEnemy {
    /**
     * Constructor.
     *
     * As we haven't implemented the HeavyCrossBow weapon,
     * the Godrick Soldier class is equipped with the Grossmesser as its primary weapon.
     *
     * @see Grossmesser
     */
    public GodrickSoldier() {
        super("Godrick Soldier",'p',198,37);
        this.addWeaponToInventory(new Grossmesser());
    }

    /**
     * Generate a random amount of runes.
     *
     * @return an integer that represent an amount of runes
     * @see game.runes.RuneSource
     */
    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(38,45);
    }
}
