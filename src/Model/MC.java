package Model;

/**
 * Defines a set of constants that define the types of various items, objects and tiles.
 */
public class MC {

    // Core Tile types
    public final static int TILE_TYPE_CONSTANT = 0;
    public final static int TILE_TYPE_PLANES = 0;
    public final static int TILE_TYPE_RIVER = 1;
    public final static int TILE_TYPE_COAST = 2;
    public final static int TILE_TYPE_WATER = 3;
    public final static int TILE_TYPE_HILL = 4;
    public final static int TILE_TYPE_MOUNTAIN = 5;

    // Raw Mined Material types
    public final static int MAT_MIN_RAW_CONSTANT = 10000;
    public final static int MAT_MIN_RAW_QUANTITY = 16;

    public final static int MAT_MIN_RAW_AIR = 10000;
    public final static int MAT_MIN_RAW_STONE = 10001;
    public final static int MAT_MIN_RAW_WATER = 10002;
    public final static int MAT_MIN_RAW_WOOD = 10003;
    public final static int MAT_MIN_RAW_IRON = 10004;
    public final static int MAT_MIN_RAW_COPPER = 10005;
    public final static int MAT_MIN_RAW_TIN = 10006;
    public final static int MAT_MIN_RAW_SILVER = 10007;
    public final static int MAT_MIN_RAW_GOLD = 10008;
    public final static int MAT_MIN_RAW_LEAD = 10009;
    public final static int MAT_MIN_RAW_URANIUM = 10010;
    public final static int MAT_MIN_RAW_COAL = 10011;
    public final static int MAT_MIN_RAW_DIAMOND = 10012;
    public final static int MAT_MIN_RAW_RARE_EARTH = 10013;
    public final static int MAT_MIN_RAW_CLAY = 10014;
    public final static int MAT_MIN_RAW_OIL = 10015;

    // Raw Farmed Material types
    public final static int MAT_FARM_RAW_CONSTANT = 20000;
    public final static int MAT_FARM_RAW_SKINS = 20000;
    public final static int MAT_FARM_RAW_MEAT = 20001;
    public final static int MAT_FARM_RAW_COTTON = 20002;
    public final static int MAT_FARM_RAW_BONE = 20003;
    public final static int MAT_FARM_RAW_RICE = 20004;
    public final static int MAT_FARM_RAW_WHEAT = 20005;
    public final static int MAT_FARM_RAW_CORN = 20006;
    public final static int MAT_FARM_RAW_NUTS = 20007;
    public final static int MAT_FARM_RAW_FRUIT = 20008;
    public final static int MAT_FARM_RAW_MILK = 20009;

    // Processed Metals
    public final static int MAT_PRO_CONSTANT = 30000;
    public final static int MAT_PRO_IRON = 30001;
    public final static int MAT_PRO_COPPER = 30002;
    public final static int MAT_PRO_TIN = 30003;
    public final static int MAT_PRO_SILVER = 30004;
    public final static int MAT_PRO_GOLD = 30005;
    public final static int MAT_PRO_LEAD = 30006;
    public final static int MAT_PRO_URANIUM = 30007;
    public final static int MAT_PRO_RARE_EARTH = 30008;
    public final static int MAT_PRO_LEATHER = 30009;
    
    // Processed Farmed types
    public final static int MAT_FARM_PRO_CONSTANT = 40000;
    public final static int MAT_FARM_PRO_BREAD = 40000;

    // Game object type IDs

    public final static int OBJECT_ID_CONSTANT = 100000;
    public final static int OBJECT_ID_ENTITY = 100000;
    public final static int OBJECT_ID_BUILDING = 100001;
    public final static int OBJECT_ID_UNIT = 100002;
    public final static int OBJECT_ID_TILE_RESOURCE = 100003;
    public final static int OBJECT_ID_NOTHING = 100004;
    public final static int OBJECT_ID_HARVESTER = 100005;
    public final static int OBJECT_ID_MINE = 100006;
}
