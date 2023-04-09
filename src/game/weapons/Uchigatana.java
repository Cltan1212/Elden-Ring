package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;

public class Uchigatana extends WeaponItem {

    public Uchigatana() {
        super("Uchigatana",')',115, "", 80);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        // TODO: implement special skill
        return null;
    }
}
