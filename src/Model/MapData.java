package Model;

import UI.BaseSurvival;

/**
 * The mapData object is an object that holds all data relevant to the state of the game world.
 * It does operates to the map.
 *
 * Only one map object can be created. Any attempts to generate it will return the existing one.
 */

public class MapData {

    private int width = 100;
    private int height = 100;
    private MapCol[][] data;

    private static MapData instance;

    public static MapData getInstance(int width, int height) {
        if (instance == null) {
            instance = new MapData(width, height);
        }
        return instance;
    }


    public static MapData getInstance() {
        return instance;
    }

    /**
     * Clear the internaly stored version, allowed a new one to be generated on getInstance.
     *
     * ONLY TO BE USED FOR DEBUGGING
     */
    public void invalidateObject() {
        if (!BaseSurvival.ALLOWDEBUGOPTIONS) {
            throw new IllegalStateException("Debugger was false, but we attempted to invalidate the MapData Object!");
        }
        instance = null;
    }
    /**
     * Constructs the MapData object
     *
     * Holds all data about the state of the map that be being used.
     * @param width The width of the map in units. Must be greater than 10.
     * @param height The height of the map in units. Must be greater than 10.
     */
    private MapData(int width, int height) {

        // Check input
        if (width < 10 || height < 10) {
            throw new IllegalArgumentException("Width or Height was too low!");
        }
        // Set params
        this.width = width;
        this.height = height;

        // Init internal data
        data = new MapCol[this.width][this.height];

        for(int x = 0; x < this.width; x++) {
            for(int y = 0; y < this.height; y++) {
                data[x][y] = new MapCol(x,y);
            }
        }
    }
    public MapCol getTileAtPos(int x, int y) {

        if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
            throw new IllegalArgumentException("Out of range position!");
        }

        return data[x][y];
    }
    public void setTileAtPos(int x, int y, MapCol object) {
        if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
            throw new IllegalArgumentException("Out of range position!");
        }
        data[x][y] = object;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
}
