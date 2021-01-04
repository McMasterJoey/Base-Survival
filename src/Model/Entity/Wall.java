package Model.Entity;

import Model.MapTileVisualLoader;
import javafx.scene.image.Image;

public class Wall extends PassiveDefense {

    public Wall(int pos_x, int pos_y) {
        super(pos_x, pos_y, 1, "Wall", 10);
    }
    public void doAction() {
        // TODO: Write me
        return;
    }
    public void onClick() {
        // TODO: Write me
        return;
    }
    public void buildUpgradeCostList() {
        return;
    }
    public Image getAsset() {
        MapTileVisualLoader v = MapTileVisualLoader.getInstance();
        return v.getAsset("Wall",this.level);
    }
    public String toString() {
        return "Wall: x = " + pos_x + " , y = " + pos_y;
    }
}
