package game.actors.enemies.stormveilCastleEnemy;

import game.utils.RandomNumberGenerator;
import game.weapons.Grossmesser;

public class GodrickSoldier extends StormveilCastleEnemy {
    /**
     * Constructor.
     *
     */
    public GodrickSoldier() {
        super("Godrick Soldier",'p',198,37);
        this.addWeaponToInventory(new Grossmesser());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(38,45);
    }
}
