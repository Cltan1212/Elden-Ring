package game.actors.allyInvader;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.utils.Status;

public class Ally extends AllyOrInvaderType {
    /**
     * Constructor.
     */
    public Ally() {
        super("Ally", 'A', 0);
        this.addCapability(Status.HOSTILE_TO_INVADERS);
    }

    // no runes generated for Ally

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // allies can attack other hostile creatures
        if  (otherActor.hasCapability(Status.RESPAWNABLE) || otherActor.hasCapability(Status.HOSTILE_TO_ALLIES)){
            actions.add(new AttackAction(this, direction));
            this.behaviours.put(0, new AttackBehaviour(otherActor));
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

    // allies removed from the map ONLY if the player dies.
    // If the player rests, no removal from map
    @Override
    public String reset(GameMap map) {
        return null;
    }


}
