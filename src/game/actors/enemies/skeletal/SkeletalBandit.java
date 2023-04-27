package game.actors.enemies.skeletal;

import game.utils.RandomNumberGenerator;
import game.weapons.Scimitar;

public class SkeletalBandit extends Undead{
    public SkeletalBandit() {
        super("Skeletal Bandit",'b',184);
        this.addWeaponToInventory(new Scimitar());
    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(35,892);
    }
}
