package game.utils;

import java.util.Random;

/**
 * A random number generator
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class RandomNumberGenerator {

    /**
     * Static method to generate random number between the bound
     * @param bound
     * @return the random integer generated
     */
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    /**
     * Static method to generate random number between lowerBound and upperBound
     * @param lowerBound the lower bound range for generated int
     * @param upperBound the upper bound range for generated int
     * @return the random integer generated
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
