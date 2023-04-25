package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class AttackBehaviour implements Behaviour {

    private final Actor targetAttack;
    public AttackBehaviour(Actor targetAttack){
        this.targetAttack = targetAttack;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        if (!map.contains(actor) || !map.contains(targetAttack)){
            return null;
        }

        // LOOK for enemies around actor
        // if more then one enemy -> AreaAttackAction (constructor of AreaAttackAction take in list of enemies to attack)
        // which loop through the list and attack each of them
        // if only one enemy -> AttackAction

        // can have a specialAttack in giantCrab and heavyskeletal, so if != null, can perform AreaAttackAction



        return null;
    }
}
