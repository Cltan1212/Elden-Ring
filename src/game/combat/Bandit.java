package game.combat;
import game.weapons.GreatKnife;

/**
 * Bandit
 * One of the starting game mode
 * @author Tan Chun Ling, Wan Jack Liang, King Jean Lynn
 * @version 3.0
 */
public class Bandit extends CombatArchetypes {

    /**
     * Constructor
     *
     * Set the display character, the starting weapon and starting hit point for this game mode
     */
    public Bandit(){
        // starting weapon is Great Knife
        super('b', "Bandit", new GreatKnife(), 414);
    }
}
