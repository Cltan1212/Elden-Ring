package game.grounds.stormveilCastle;

import game.actors.enemies.Enemy;
import game.actors.enemies.dog.Dog;
import game.grounds.environments.SpawnGround;

public class Cage extends SpawnGround {
    /**
     * Constructor.
     *
     */
    public Cage() {
        super('<');
    }

    /**
     * This method returns enemies that will spawn on the ground
     * @return the enemies to be spawn based on each ground
     */
    public Enemy spawn(){
        return new Dog();
    }

}

