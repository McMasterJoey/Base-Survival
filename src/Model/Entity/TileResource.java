package Model.Entity;

import Model.MC;

public class TileResource extends Entity {

    protected String name;
    public TileResource(int pos_x, int pos_y, int tile_size, String name) {
        super(pos_x, pos_y, tile_size);
        this.UNIQUE_TYPE_ID = MC.OBJECT_ID_TILE_RESOURCE;
        this.name = name;
    }
}
