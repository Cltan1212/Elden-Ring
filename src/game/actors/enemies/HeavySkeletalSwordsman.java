package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.behaviour.Behaviour;
import game.reset.Resettable;
import game.weapons.Grossmesser;

import java.util.HashMap;
import java.util.Map;

public class HeavySkeletalSwordsman extends Enemies {


    // can become a Pile of Bone represented by X for 2 turns if killed by other enemies or the player
    // if the pile of bone is not hit within the 2 turns, the Heavy SKeleton Swordsman will be revived with full health
    // can drop any amount of runes between 35, 892

    private static final String NAME = "Heavy Skeletal Swordsman";
    private static final String WEAPON_Name = "Grossmesser";
    private static final int BONES_REVIVE_TURNS = 3;
    private static final Weapon weapon = new Grossmesser();

    // Will become Pile of Bones for 3 turns if killed by other enemies or the player
    private int bonesReviveCounter; // Counter to keep track of turns for Piles of Bones

    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor
     */
    public HeavySkeletalSwordsman() {

        super("Heavy Skeletal Swordsman", 'q', 153);
        this.bonesReviveCounter = 0;
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Perform Heavy Skeletal Swordsman's turn
     */
//    @Override
//    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
//        if (this.isDead()){
//            // check if need to revive to Pile Of Bones
//            if (BONES_REVIVE_TURNS == bonesReviveCounter){
//                display.println("Heavy Skeletal Swordsman has revived as a Pile of Bones!");
////                return new PilesOfBones();  // create a pileofbones object
//            } else{
//                bonesReviveCounter += 1;
//            }
//        } else{
//            // regular actions or heavyskeletalswordsman
//            // following player, attacking nearby and wonder
//        }
//
//
//        return null; // if no action is performed
//    }

    @Override
    public void hurt(int damagePoint){
        super.hurt(damagePoint);
        bonesReviveCounter = 0; // counter become 0 when hurt
    }

    @Override
    public void reset() {

    }
}
