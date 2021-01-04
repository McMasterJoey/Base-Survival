package Model.Entity;

import Model.MC;
import Model.MapData;
import Model.MapTileVisualLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The Generic class for the Entity object type.
 *
 * Each Entity can be placed within the map and has a graphic assoicated with it that is independent of the terrain its on.
 */
public class Entity {
    protected int pos_x;
    protected int pos_y;
    protected int tile_size;

    protected boolean hasPointerEntities;
    protected boolean isPointerEntity;

    protected Entity parent;
    protected int UNIQUE_TYPE_ID = MC.OBJECT_ID_ENTITY;

    public Entity(int pos_x, int pos_y, int tile_size) {
        // Bound check
        boundCheckInputtedCords(true,pos_x);
        boundCheckInputtedCords(false,pos_y);

        if (tile_size < 1) {
            throw new IllegalArgumentException("Entity: Tile_size out of range!");
        }

        // Set internal values
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.tile_size = tile_size;
        this.hasPointerEntities = tile_size != 1;
        this.isPointerEntity = false;
    }

    /**
     * Fetches the Unique ID that is held by this object type.
     * @return The Type ID.
     */
    public int getTypeID() {
        return UNIQUE_TYPE_ID;
    }
    /**
     * Gets the image file assoicated with this entity.
     * @return
     */
    public Image getAsset() {
        //MapTileVisualLoader asset = MapTileVisualLoader.getInstance();
        //return asset.getAsset(null);
        throw new IllegalStateException("No asset is detailed for this generic Entity!");
    }

    /**
     * Gets the x position of this Entity. 
     * @return The x index into the MapData array.
     */
    public int getPosX() {
        return pos_x;
    }
    /**
     * Gets the y position of this Entity. 
     * @return The y index into the MapData array.
     */
    public int getPosY() {
        return pos_y;
    }

    /**
     * Gets the tile size of this Entity.
     * @return The tile size in Tile side length of all sides.
     */
    public int getTileSize() {
        return tile_size;
    }
    /**
     * Sets the x position of this Entity.
     * @param pos_x The new x position (index into the MapData array). 
     */
    public void setPosX(int pos_x) {
        // Bound check
        boundCheckInputtedCords(true,pos_x);

        // Set value.
        this.pos_x = pos_x;
    }

    /**
     * Sets the y position of this Entity.
     * @param pos_y The new y position (index into the MapData array).
     */
    public void setPosY(int pos_y) {
        // Bound check
        boundCheckInputtedCords(false,pos_y);

        // Set value.
        this.pos_y = pos_y;
    }

    /**
     * Carries out the action that this entity does.
     * If done on an object that does not override this method, will result in an exception being thrown.
     */
    public void doAction() {
        throw new IllegalStateException("No action is detailed for this generic Entity!");
    }

    public void onClick() {
        throw new IllegalStateException("No action is detailed for this generic Entity!");
    }
    /**
     * Prints out a String to represent the object.
     * @return A string that represents the object in text form.
     */
    public String toString() {
        return "Entity: x = " + pos_x + " , y = " + pos_y;
    }

    /**
     * Sets the state of the entity interms of its pointer status.
     *
     * @param parent True = Entity returns the cords of the object it points to. False = Entity stands on its own.
     */
    public void setIsPointerEntity(Entity parent) {
        isPointerEntity = true;
        this.parent = parent;
    }

    /**
     * Fetches the state of the entity interms of its pointer status.
     * @return True = Entity returns the cords of the object it points to. False = Entity stands on its own.
     */
    public boolean getIsPointerEntity() {
        return isPointerEntity;
    }

    /**
     * Fetches the parent that is pointed to by the object.
     * @return null if this entity stands alone. Otherwise its an Entity of the parent.
     */
    public Entity getParent() {
        return parent;
    }

    /**
     * Simple call that asks if the object represents Nothing.
     * @return If true, the object is Nothing. Otherwise, its something.
     */
    public boolean isNothing() {
        return false;
    }
    /**
     * Performs a bound check on an input cord value.
     * @param isX Set to true if checking an x value, false if its a y value.
     * @param value The value being checked.
     *
     * @Throws IllegalArgumentException if the value is out of range.
     */
    public static void boundCheckInputtedCords(boolean isX, int value) {
        // Fetch map data object for bound checking.
        MapData data = MapData.getInstance();
        int upper_bound_y = 0;
        int upper_bound_x = 0;
        if (data != null) {
            upper_bound_y = data.getHeight();
            upper_bound_x = data.getWidth();
        } else {
            throw new IllegalArgumentException("Error: Entity.boundCheckInputtedCords - MapData wasn't defined yet!");
        }

        // Bound check.
        if (isX) {
            if (value < 0 || value >= upper_bound_x) {
                throw new IllegalArgumentException("Inputted x value out of range");
            }
        } else {
            if (value < 0 || value >= upper_bound_y) {
                throw new IllegalArgumentException("Inputted y value out of range");
            }
        }
    }
}
