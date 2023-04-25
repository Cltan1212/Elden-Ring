package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;
import game.utils.Status;

public class Runes extends Item implements RuneSource{

    public Actor runeHolder;

    public Runes(Actor runeHolder){
        super("Runes", '$',false);
        this.runeHolder = runeHolder;
        RunesManager.getInstance().registerRuneSource(this);
    }

    @Override
    public int generateRunes() {
        return 0;
    }
}
