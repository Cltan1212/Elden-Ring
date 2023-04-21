package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.runesActions.DropRunesAction;
import game.actions.runesActions.TransferRunesAction;
import game.actors.enemies.EnemyType;
import game.runes.Runes;
import game.utils.Status;

import static game.utils.RandomNumberGenerator.getRandomInt;

public class DropRunesBehaviour implements Behaviour{

    private final Actor target;

    public DropRunesBehaviour(Actor subject){
        this.target = subject;
    }
    @Override
    public Action getAction(Actor actor, GameMap map) {
        int runesValue = 0;
        if (actor.hasCapability(EnemyType.SKELETAL)){
            runesValue = getRandomInt(35,892);
        } else if (actor.hasCapability(EnemyType.DOG)) {
            runesValue = getRandomInt(55,1470);
        } else if (actor.hasCapability(EnemyType.WATER)) {
            runesValue = getRandomInt(318,4961);
        }
        return new TransferRunesAction(new Runes(runesValue), target);
    }
}
