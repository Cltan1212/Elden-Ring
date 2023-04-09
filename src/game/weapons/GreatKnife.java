package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class GreatKnife extends WeaponItem {

    public GreatKnife() {
        super("Great Knife", '/',75,"",70);
    }

    @Override
    public Action getSkill(Actor target, String direction){
        // TODO: implement special skill
        return null;
    }
}
