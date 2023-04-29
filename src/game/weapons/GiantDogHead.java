package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.actions.actorActions.AttackAction;
import game.utils.RandomNumberGenerator;

public class GiantDogHead extends WeaponItem {

    public GiantDogHead() {
        super("Giant Dog Slam", ' ', 208, "slams", 90);
        portable = false;
    }
    @Override
    public Action getSkill(Actor target, String direction){
        return new AreaAttackAction(this);
    }

    @Override
    public Action getSkill(Actor holder) {
        return new AreaAttackAction(this);
    }
}
