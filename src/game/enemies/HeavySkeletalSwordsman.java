package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.weapons.Grossmesser;

public class HeavySkeletalSwordsman extends Enemies {



    private static final String NAME = "Heavy Skeletal Swordsman";
    private static final String WEAPON_Name = "Grossmesser";
    private static final int BONES_REVIVE_TURNS = 3;
    private static final Weapon weapon = new Grossmesser();

    // Will become Pile of Bones for 3 turns if killed by other enemies or the player
    private int bonesReviveCounter; // Counter to keep track of turns for Piles of Bones

    /**
     * Constructor
     */
    public HeavySkeletalSwordsman() {

        super("Heavy Skeletal Swordsman", 'q', 153);
        this.bonesReviveCounter = 0;
    }

    /**
     * Perform Heavy Skeletal Swordsman's turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.isDead()){
            // check if need to revive to Pile Of Bones
            if (BONES_REVIVE_TURNS == bonesReviveCounter){
                display.println("Heavy Skeletal Swordsman has revived as a Pile of Bones!");
//                return new PilesOfBones();  // create a pileofbones object
            } else{
                bonesReviveCounter += 1;
            }
        } else{
            // regular actions or heavyskeletalswordsman
            // following player, attacking nearby and wonder
        }


        return null; // if no action is performed
    }

    @Override
    public void hurt(int damagePoint){
        super.hurt(damagePoint);
        bonesReviveCounter = 0; // counter become 0 when hurt
    }
}
