package game.actors.allyInvader;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.attackActions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.combat.CombatArchetypes;
import game.runes.RuneSource;
import game.runes.RunesManager;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

public class Invader extends AllyOrInvaderType implements RuneSource {


    /**
     * The status to indicate if invader is following the player.
     */
    public boolean following = false;

    public CombatArchetypes role;


    /**
     * Constructor.
     */
    public Invader() {
        super("Invader", 'ඞ', 0);
        RunesManager.getInstance().registerRuneSource(this);
        this.addCapability(Status.HOSTILE_TO_ALLIES);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            following = true;
            this.behaviours.put(0, new AttackBehaviour(otherActor));
            this.behaviours.put(1, new FollowBehaviour(otherActor));  // invader will follow the player
        }

        // invader can attack player, also other hostile creatures
        if (otherActor.hasCapability(Status.RESPAWNABLE) || otherActor.hasCapability(Status.HOSTILE_TO_INVADERS)){
            actions.add(new AttackAction(this, direction));
            this.behaviours.put(3, new AttackBehaviour(otherActor));
            for (WeaponItem weaponItem: otherActor.getWeaponInventory()){

                // attack action for normal weapon
                actions.add(new AttackAction(this, direction, weaponItem));
                // special skill for area attack
                actions.add(weaponItem.getSkill(otherActor));
                // special skill for target attack
                actions.add(weaponItem.getSkill(this, direction));
            }
        }
        return actions;

    }

    @Override
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(1358,5578);
    }
}
