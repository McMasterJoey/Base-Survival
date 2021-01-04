package Model.Entity;


import Model.MC;

public class Unit extends Entity {
    public Unit(int pos_x, int pos_y, int tile_size) {
        super(pos_x, pos_y, tile_size);
        UNIQUE_TYPE_ID = MC.OBJECT_ID_UNIT;
    }
}
