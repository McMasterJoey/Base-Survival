package Model.Entity;

import Model.MC;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Buildings are any structure built by a player.
 */
public class Building extends Entity {
    protected String building_type;
    protected int level;
    protected int max_levels;
    protected ArrayList<HashMap<Integer, Integer>> buildcosts;

    public Building(int pos_x, int pos_y, int tile_size, String building_type, int max_levels) {
        super(pos_x, pos_y, tile_size);
        UNIQUE_TYPE_ID = MC.OBJECT_ID_BUILDING;
        this.building_type = building_type;
        this.max_levels = max_levels;
        this.level = 1;
        buildcosts = new ArrayList<HashMap<Integer, Integer>>(max_levels + 1);
        buildUpgradeCostList();
    }

    public String getBuildingType() {
        return this.building_type;
    }
    protected void buildUpgradeCostList() {
        throw new IllegalStateException("No cost list has been built for this building!");
        // Level 0 (Initial Build)
        //HashMap<Integer,Integer> intialbuild = new HashMap<Integer,Integer>();
        //intialbuild.put(MC.MAT_MIN_RAW_WOOD, 100); // Structure costs 100 wood.
        //buildcosts.add(intialbuild);
    }
    public HashMap<Integer,Integer> getCostOf(int level) {
        return buildcosts.get(level);
    }
    public void upgrade() {

    }
    public String toString() {
        return "Building: x = " + pos_x + " , y = " + pos_y;
    }
}
