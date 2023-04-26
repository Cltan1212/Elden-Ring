package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.actorActions.AttackAction;
import game.actions.actorActions.UnsheatheAction;
import game.utils.Status;

public class GiantCrabSlam extends WeaponItem {



    public GiantCrabSlam() {
        super("Giant Crab Slam", ' ', 208 , "slams", 90);
        this.addCapability(Status.SLAMMING_ATTACK);
    }

    @Override
    public Action getSkill(Actor holder){
        if (this.hasCapability(Status.SLAMMING_ATTACK)){
            // holder -> attacker? (enemy)
            return new AreaAttackAction(holder, this);
        }else{
            return null;
        }

    }

    public Action getSkill(Actor target, String direction){
        return new AttackAction(target, direction, this);
    }
}
