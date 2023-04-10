package game.enemies;

import edu.monash.fit2099.engine.actors.Actor;

public abstract class Enemies extends Actor {

    private boolean dead; // Boolean field to indicate if the enemy is dead
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemies(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.dead = false;
    }

    // to check if the enemy is dead or not
    public boolean isDead(){
        return dead;
    }

    public void hurt(int damagePoint){
        // update the hitpoint
        // check if enemy is dead
        hitPoints -= damagePoint;
        if (hitPoints <= 0){
            dead = true;
        }
    }


}
