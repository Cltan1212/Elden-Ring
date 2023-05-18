package game.maps;

import java.util.List;

public abstract class MapInitialize {

    List<String> map;

    public MapInitialize(List<String> map) {
        this.map = map;
    }

    public List<String> getMap() {
        return map;
    }
}
