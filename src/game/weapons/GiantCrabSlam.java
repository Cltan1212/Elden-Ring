package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.actorActions.UnsheatheAction;
import game.utils.Status;

public class GiantCrabSlam extends WeaponItem {



    public GiantCrabSlam() {
        super("Giant CratCrab Slam", ' ', 208 , "", 90);
        this.addCapability(Status.SLAMMING_ATTACK);
    }

    @Override
    public Action getSkill(Actor holder){
        if (this.hasCapability(Status.SLAMMING_ATTACK)){
            return null;
//            return new AreaAttackAction(this, holder);
        }else{
            return null;
        }

    }
}
