package UI;

import Model.Entity.Entity;
import Model.MC;
import Model.MapData;
import Model.RenderSettings;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
/**
 * This object handles the rendering of the game state to the screen.
 *
 * All code related to rendering the data from the MapData Object to some kind of pane is done here.
 */
public class FrameRenderer {
    private Canvas view;
    private MapData data;
    private RenderSettings settings;
    private int gridlinethickness;

    /**
     *
     * @param view The canvas that will be renderd to.
     * @param data The data that will be rendered
     * @param settings The settings that will be used to render the data.
     */
    public FrameRenderer(Canvas view, MapData data, RenderSettings settings) {
        this.view = view;
        this.data = data;
        this.settings = settings;
        this.gridlinethickness = settings.getGridLineThickness();
    }
    public void RenderFrame(RenderSettings settings) {
        this.settings = settings;
        RenderFrame();
    }

    /**
     * Renders the internal MapData Object to the canvas with the RenderSettings settings.
     */
    public void RenderFrame() {
        // Fetch needed data and set vars.
        int width = (int) view.getWidth();
        int height = (int) view.getHeight();
        int startx = settings.getPosX(); // Assumed to be the x index of the center most tile.
        int starty = settings.getPosY(); // Assumed to be the y index of the center most tile.
        int sidelen = settings.getTileSideLength();
        GraphicsContext gc = view.getGraphicsContext2D();

        // Determine the center of the canvas (pixels)
        int centerx = width / 2;
        int centery = height / 2;

        // Reset frame to color of the grid lines.
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,width, height);

        // Determine how many square to draw both axis after the center.
        int netlen = sidelen + settings.getGridLineThickness();
        int totalw = (width / netlen) + 1; // Max tiles I'll draw on the X axis
        int totalh = (height / netlen) + 1; // Max tiles I'll draw on the Y axis

        // Determine offset to account for blank space that is visible on the render before the center.

        // Determine how many tiles I can fit before the center in each direction.
        int tmpx = centerx / netlen;
        int tmpy = centery / netlen;

        // Draw each square
        for(int x = 0; x < totalw; x++) {
            for(int y = 0; y < totalh; y++) {

                // Determine what tile is to be rendered.
                int npos_x = x + (startx - tmpx);
                int npos_y = y + (starty - tmpy);

                // Check to see if its a tile that is on the map.
                if (npos_x >= data.getWidth() || npos_y >= data.getHeight()) {
                    // Tile is out of range, stop rendering in that direction.
                    break;
                }
                if (npos_x < 0 || npos_y < 0) {
                    // Tile is off screen before the center. Skip this, but keep going.
                    continue;
                }
                // Determine what should be painted on the tile.
                if (data.getTileAtPos(npos_x,npos_y).doSimpleRender()) {
                    // We're painting a simple colored square.
                    int rendertype = data.getTileAtPos(npos_x,npos_y).getRenderType();
                    gc.setFill(getRenderFill(rendertype));

                    // Paint it.
                    gc.fillRect(x * netlen,y * netlen,sidelen,sidelen);
                } else {
                    // We're painting a picture in the square.
                    Entity e = data.getTileAtPos(npos_x,npos_y).doImageRender();
                    if (!e.getIsPointerEntity()) {
                        // We're painting an object that isn't a pointer or filler.
                        int totallen = sidelen * e.getTileSize();
                        gc.drawImage(e.getAsset(),x * netlen,y * netlen,totallen,totallen);
                    }
                }
            }
        }
    }

    /**
     * Determines what square a click is in.
     *
     * @param click_x The x componet of the click.
     * @param click_y The y componet of the click.
     * @return An array of size 2 holding an x and y value. The cordnates within the MapData object that was clicked into. Returns -1 in each if the click isn't within the data.
     */
    public int[] mapCanvasClickToMapDataCord(int click_x, int click_y) {
        int[] retval = new int[2];

        // Fetch data about the current frame.
        int width = (int) view.getWidth();
        int height = (int) view.getHeight();
        int pos_x = settings.getPosX();
        int pos_y = settings.getPosY();
        int netlen = settings.getTileSideLength() + settings.getGridLineThickness();

        // Determine the center of the canvas (pixels)
        int centerx = width / 2;
        int centery = height / 2;

        // Map mouse click into an offset from the edge.
        int tile_index_x = click_x / netlen;
        int tile_index_y = click_y / netlen;

        // Map click to selected box.
        retval[0] = tile_index_x - (centerx / netlen) + pos_x;
        retval[1] = tile_index_y - (centery / netlen) + pos_y;

        // If anything is out of range, set the entire thing to -1, -1 for out of bounds case.
        if (retval[0] < 0 || retval[0] >= data.getWidth() || retval[1] < 0 || retval[1] >= data.getHeight()) {
            retval[0] = -1;
            retval[1] = -1;
        }

        return retval;
    }
    private Paint getRenderFill(int rendertype) {
        if (rendertype == MC.TILE_TYPE_PLANES) {
            return Color.GREEN;
        } else if (rendertype == MC.TILE_TYPE_RIVER) {
            return Color.LIGHTSEAGREEN;
        } else if (rendertype == MC.TILE_TYPE_COAST) {
            return Color.BLUE;
        } else if (rendertype == MC.TILE_TYPE_WATER) {
            return Color.DARKBLUE;
        } else if (rendertype == MC.TILE_TYPE_HILL) {
            return Color.DARKGREEN;
        } else if (rendertype == MC.TILE_TYPE_MOUNTAIN) {
            return Color.GRAY;
        }
        return Color.BLACK;
    }
}
