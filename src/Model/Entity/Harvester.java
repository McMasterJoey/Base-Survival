package Model.Entity;

import Model.MC;

public class Harvester extends Building {
    public Harvester(int pos_x, int pos_y, int tile_size, String building_type, int max_levels) {
        super(pos_x, pos_y, tile_size, building_type, max_levels);
        UNIQUE_TYPE_ID = MC.OBJECT_ID_HARVESTER;
    }
}
