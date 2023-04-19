package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.actorActions.AreaAttackAction;
import game.utils.Status;

public class Grossmesser extends WeaponItem {
    public Grossmesser() {
        super("Grossmesser", '?',115, "", 85);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        return new AreaAttackAction();
    }

}
