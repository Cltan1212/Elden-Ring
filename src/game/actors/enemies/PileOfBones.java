package game.actors.enemies;

public class PileOfBones{
    private int remainingDeath;

    public PileOfBones(){
        setRemainingDeath(3);
    }


    public int getRemainingDeath() {
        return remainingDeath;
    }

    public void setRemainingDeath(int remainingDeath) {
        this.remainingDeath = remainingDeath;
    }

    public void successAttack(){
        remainingDeath -= 1;
        if (remainingDeath == 0){
            // do something (get location and spawn heavy skeletal swordsman again)
        }
    }
}
