package game.weapons;

public class Scimitar extends CurvedSword {

    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, " ", 88);
    }
}
