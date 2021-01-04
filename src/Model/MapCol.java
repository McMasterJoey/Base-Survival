package Model;

import Model.Entity.Entity;

/**
 * Each Map col will have 5 slices.
 *
 * 0 = High elevation, Will be air unless its occupied by a mountain tile.
 * 1 = Mid elevation, Will be air unless is occupied by a mountain or hill tile.
 * -----(Ground)------------------------------------------------------------------
 * 2 = Underground. Will contain surface raw resources unless its a river or water tile.
 * 3 = Deeper Underground. Will contain deeper raw resources. Only deep water tiles that aren't.
 * 4 = Very deep underground. Every tile contains raw resources.
 *
 * Each map col will have 1 spot for the occupied surface slot. These can be occupied by buildings.
 */
public class MapCol {
    private int x_pos;
    private int y_pos;
    private int tile_type;
    private MapSecData[] content;

    public MapCol(int type, int x, int y) {
        content = new MapSecData[5];
        tile_type = type;
        x_pos = x;
        y_pos = y;
    }

    public MapCol(int x, int y) {
        content = new MapSecData[5];
        tile_type = MC.TILE_TYPE_PLANES;
        x_pos = x;
        y_pos = y;
        for(int i = 0; i < content.length; i++) {
            content[i] = new MapSecData(i);
        }
    }
    public int getTerrainHeight() {
        if (tile_type == MC.TILE_TYPE_MOUNTAIN) {
            return 0;
        } else if (tile_type == MC.TILE_TYPE_HILL) {
            return 1;
        } else if (tile_type == MC.TILE_TYPE_RIVER || tile_type == MC.TILE_TYPE_COAST) {
            return 3;
        } else if (tile_type == MC.TILE_TYPE_WATER) {
            return 4;
        } else {
            return 2;
        }
    }
    public void generateNew() {

        if (tile_type == MC.TILE_TYPE_PLANES) {

        }
    }
    public void setSliceData(int layer, MapSecData object) {
        content[layer] = object;
    }
    public void setTileType(int type) {
        tile_type = type;
    }

    public MapSecData getSliceData(int layer) {
        return content[layer];
    }

    public boolean doSimpleRender() {
        for(int x = 0; x < content.length; x++) {
            if (content[x].getDisplayEntity() != null && !content[x].getDisplayEntity().isNothing()) {
                return false;
            }
        }
        return true;
    }

    public Entity doImageRender() {
        for(int x = 0; x < content.length; x++) {
            if (content[x].getDisplayEntity() != null && !content[x].getDisplayEntity().isNothing()) {
                return content[x].getDisplayEntity();
            }
        }
        return null;
    }

    public void addEntity(Entity e, int index_section) {
        content[index_section].getEntities().add(e);
    }

    public int getRenderType() {
        //TODO: Update this to the building or entity that occupies it instead of only the natural terrain.
        return tile_type;
    }
    public int getType() {
        return tile_type;
    }
    public int getXPos() {
        return x_pos;
    }
    public int getYPos() {
        return y_pos;
    }
}
