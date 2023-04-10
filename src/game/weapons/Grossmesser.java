package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

public class Grossmesser extends WeaponItem {

    public Grossmesser() {
        super("Grossmesser", '?',115, "", 85);
        this.addCapability(Status.SPECIAL_SKILL);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        // TODO: implement special skill
        return null;
    }
}
