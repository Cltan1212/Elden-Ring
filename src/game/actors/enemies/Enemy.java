package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;
import game.utils.Status;

public abstract class Enemy extends Actor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.RESPAWNABLE);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // enemy attack player and other enemies
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) || otherActor.hasCapability(Status.RESPAWNABLE)) {
            actions.add(new AttackAction(this, direction));
            for (WeaponItem weaponItem: otherActor.getWeaponInventory()){

                // skill for area attack
                actions.add(weaponItem.getSkill(otherActor));

                // skill for target attack
                actions.add(weaponItem.getSkill(otherActor, direction));
            }
        }

        return actions;
    }


}
