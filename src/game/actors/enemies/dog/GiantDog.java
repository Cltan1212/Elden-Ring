package game.actors.enemies.dog;

import game.weapons.GiantDogHead;

public class GiantDog extends Dog {

    /**
     * Constructor.
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.addWeaponToInventory(new GiantDogHead());
    }
}
