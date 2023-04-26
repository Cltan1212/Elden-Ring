package game.actors.enemies.skeletal;

import game.weapons.Scimitar;

public class SkeletalBandit extends Undead{
    public SkeletalBandit() {
        super("Skeletal Bandit",'b',184);
        this.addWeaponToInventory(new Scimitar());
    }

}
