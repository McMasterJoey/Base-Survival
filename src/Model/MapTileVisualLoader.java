package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;

public class MapTileVisualLoader {

    private HashMap<String, Image> images;
    private static MapTileVisualLoader instance = null;
    private String basepath = "D:/Pictures/Programming Project/";

    private MapTileVisualLoader() {
        images = new HashMap<String, Image>();
        // Load each asset.
        //Image Wall_1 = new Image(getClass().getResourceAsStream("/Wall_1.png"));
        //images.put("Wall_1",Wall_1);

        //Image Mine_1 = new Image(getClass().getResourceAsStream("/Mine_1.png"));
        //images.put("Mine_1",Mine_1);
    }

    /**
     * Gets the current instance of the MapTileVisualLoader.
     *
     * This object is a singleton to ensure that assets are only loaded once to prevent slow operations from being repeated.
     *
     * @return The current instance
     */
    public static MapTileVisualLoader getInstance() {
        if (instance == null) {
            instance = new MapTileVisualLoader();
        }
        return instance;
    }

    public Image getAsset(String assetName, int variation) {
        String key = assetName + "_" + variation;

        Image i = images.get(key);
        if (i == null) {
            System.err.println("Requested null!, key = " + key);
        }
        return i;
    }
    public Image getAsset(String assetFileName) {

        Image i = images.get(assetFileName);
        if (i == null) {
            System.err.println("Requested null!, key = " + assetFileName);
        }
        return i;
    }
}
