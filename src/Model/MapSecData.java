package Model;

import Model.Entity.Entity;

import java.util.HashSet;

public class MapSecData {

    // The main data array that stores the number of various resources preset.
    int[] data;
    HashSet<Entity> entities;
    int level;
    public MapSecData(int level) {
        data = new int[MC.MAT_MIN_RAW_QUANTITY];
        entities = new HashSet<Entity>();
        this.level = level;
    }

    public HashSet<Entity> getEntities() {
        return this.entities;
    }
    public Entity getDisplayEntity() {
        if (this.entities.isEmpty()) {
            return null;
        }
        // TODO: Properly Implement this, For now just grabs the first thing it sees.
        Entity e = entities.iterator().next();
        if (e.isNothing()) {
            return null;
        } else {
            return e;
        }
    }
    public void generateData() {
        // True random Generation

    }
}
