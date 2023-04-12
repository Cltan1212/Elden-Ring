package game.actors.enemies;

public class PilesOfBones {

    // represented by 'X'

    private int turnsRemaining;
    private int maxTurns;
    private boolean isRevived;
    public PilesOfBones(){
        turnsRemaining = 3;
        maxTurns = 3;
        isRevived = false;
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }

    public void tick(){

        if (!isRevived){
            turnsRemaining--;

            if (turnsRemaining == 0){
                HeavySkeletalSwordsman revivedSwordsman = new HeavySkeletalSwordsman(); // create a new skeletal with full health

                // add back to map ??? HOW lol
                // I want to add revived swordman back and remove pile of bones
//                int x = 20;
//                int y = 20;
//                map.locationOf(actor).addActor()

            }

        }


    }
}
