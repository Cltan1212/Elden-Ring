package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.utils.Status;

public class Uchigatana extends WeaponItem {

    public Uchigatana() {
        super("Uchigatana",')',115, "", 80);
        this.addCapability(Status.SPECIAL_SKILL);
        this.addCapability(Status.SELLABLE);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        // TODO: implement special skill
        return null;
    }
}
