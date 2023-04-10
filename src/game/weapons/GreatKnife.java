package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class GreatKnife extends WeaponItem {

    public GreatKnife() {
        super("Great Knife", '/',75,"",70);
        this.addCapability(Status.SPECIAL_SKILL);
        this.addCapability(Status.SELLABLE);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        // TODO: implement special skill
        return null;
    }
}
