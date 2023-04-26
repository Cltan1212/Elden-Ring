package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AttackAction;

public class GiantCrabSlam extends WeaponItem {
    public GiantCrabSlam() {
        super("Giant Crab Slam", ' ', 208 , "slams", 90);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        return new AttackAction(target, direction, this);
    }

}
