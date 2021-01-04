package Model.Entity;

import Model.MC;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This object is intended to represent an empty entity without resorting to using a null object.
 */
public class Nothing extends Entity {
    public Nothing(int pos_x, int pos_y, int tile_size) {
        super(pos_x, pos_y, tile_size);
        UNIQUE_TYPE_ID = MC.OBJECT_ID_NOTHING;
    }

    public void doAction() {
        // Do nothing.
        return;
    }
    public void onClick() {
        // Do nothing.
        return;
    }
    public Image getAsset() {
        // Do nothing.
        return null;
    }
    public boolean isNothing() {
        return true;
    }
    public String toString() {
        return "Nothing Entity: x = " + pos_x + " , y = " + pos_y;
    }
}
