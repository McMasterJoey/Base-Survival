package UI;

import Control.MapGenerator;
import Model.Entity.Wall;
import Model.MapCol;
import Model.MapData;
import Model.MC;
import Model.RenderSettings;
import javafx.geometry.Side;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainScreen extends BorderPane {

    private Canvas gameview;
    private VBox buildmenu;
    private MapData data;
    private FrameRenderer frame;
    private ContextMenu context_menu;
    private RenderSettings rendersettings;
    private GridPane subMenuDefenses;
    private GridPane subMenuProduction;
    private GridPane subMenuOther;
    private GridPane selectedSubBuildMenu;

    public MainScreen() {
        super();
        initGameView(1500,1200);
        initContextMenu();
        initBuildMenu();
        initTest();

        this.setRight(buildmenu);
    }

    private void initBuildMenu() {
        buildmenu = new VBox();

        HBox menuBar = new HBox();
        subMenuDefenses = new GridPane();
        subMenuProduction = new GridPane();
        subMenuOther = new GridPane();
        //
        Button setSubMenuMilitaryButton = new Button("Defenses");
        Button setSubMenuProductionButton = new Button("Production");
        Button setSubMenuOtherButton = new Button("Other");
        menuBar.getChildren().addAll(setSubMenuMilitaryButton,setSubMenuProductionButton,setSubMenuOtherButton);
        //
        selectedSubBuildMenu = subMenuDefenses;
        buildmenu.getChildren().addAll(menuBar,selectedSubBuildMenu);
    }
    public void MoveRenderNorth(int numberoftiles) {
        int y = rendersettings.getPosY();

        // Check and correct if we go off the grid.
        if (y - numberoftiles < 0) {
            y = 0;
        } else {
            y -= numberoftiles;
        }

        // Update renderinfo
        rendersettings.setPosY(y);
        frame.RenderFrame();
    }
    public void MoveRenderEast(int numberoftiles) {
        int x = rendersettings.getPosX();

        // Check and correct if we go off the grid.
        if (x + numberoftiles >= data.getWidth()) {
            x = data.getWidth() - 1;
        } else {
            x += numberoftiles;
        }
        // Update renderinfo
        rendersettings.setPosX(x);
        frame.RenderFrame();
    }
    public void MoveRenderSouth(int numberoftiles) {
        int y = rendersettings.getPosY();

        // Check and correct if we go off the grid.
        if (y + numberoftiles >= data.getHeight()) {
            y = data.getHeight() - 1;
        } else {
            y += numberoftiles;
        }
        // System.out.println("South " + y);
        // Update renderinfo
        rendersettings.setPosY(y);
        frame.RenderFrame();
    }
    public void MoveRenderWest(int numberoftiles) {
        int x = rendersettings.getPosX();

        // Check and correct if we go off the grid.
        if (x - numberoftiles < 0) {
            x = 0;
        } else {
            x -= numberoftiles;
        }

        // Update renderinfo
        rendersettings.setPosX(x);
        frame.RenderFrame();
    }

    public void ZoomRender(int tilesidelengthadjust) {
        int tilesidelen = rendersettings.getTileSideLength();
        int newtilesidelen = tilesidelen += tilesidelengthadjust;
        if (newtilesidelen < 1) {
            newtilesidelen = 1;
        } else if (newtilesidelen > 200) {
            newtilesidelen = 200;
        }
        rendersettings.setTileSideLength(newtilesidelen);
        frame.RenderFrame();
    }

    private void onGameViewClick(int click_grid_pos_x, int click_grid_pos_y) {
        if (click_grid_pos_x < 0 || click_grid_pos_y < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        MapCol tile = data.getTileAtPos(click_grid_pos_x,click_grid_pos_y);
        //tile.setTileType(MC.TILE_TYPE_WATER);
        tile.addEntity(new Wall(tile.getXPos(),tile.getYPos()),3);
        frame.RenderFrame();
    }
    private void initGameView(int width, int height) {
        gameview = new Canvas(width,height);
        gameview.setOnMouseClicked((click) -> {
            int[] result = frame.mapCanvasClickToMapDataCord((int) click.getX(), (int) click.getY());
            if (result[0] >= 0 && result[1] >= 0) {
                if (click.getButton() == MouseButton.PRIMARY) {
                    context_menu.hide();
                    onGameViewClick(result[0],result[1]);
                } else if (click.getButton() == MouseButton.SECONDARY) {
                    createTileSelectedContextMenu((int) click.getX(),(int) click.getY());
                } else {
                    // TODO: Action on Scroll Wheel click.
                }
            }

        });
    }
    private void initContextMenu() {
        context_menu =  new ContextMenu();
    }
    private void createTileSelectedContextMenu(int click_x, int click_y) {
        // Flush old context Menu
        context_menu.hide();
        context_menu.getItems().clear();

        // Create new context menu.
        context_menu = new ContextMenu();
        MenuItem item1 =  new MenuItem("Get Info");
        item1.setOnAction((click) -> {
            //System.out.println("Context Menu: Get Info");
            int[] result = frame.mapCanvasClickToMapDataCord(click_x, click_y);
            MapCol col = data.getTileAtPos(result[0],result[1]);
            System.out.println(col.getType());
        });
        MenuItem item2 =  new MenuItem("Deselect");
        item2.setOnAction((click) -> {
            //System.out.println("Context Menu: Deselect");
            context_menu.hide();
        });
        context_menu.getItems().addAll(item1,item2);



        System.out.println("Screen click at: " + click_x + "," + click_y);
        System.out.println("this " + this.getWidth() + "," + this.getHeight());
        // Show, the + (num) was the offset found to correct the menu.
        int offsetx = 0; // 1280 = 320, 720 = 600
        int offsety = 0; // 720 = 125
        context_menu.show(this, click_x + offsetx,click_y + offsety);
    }


    private void initTest() {
        data = MapData.getInstance(500,500);
        MapGenerator generator = new MapGenerator(data);
        rendersettings = new RenderSettings(8,0,0,0);
        frame = new FrameRenderer(gameview,data,rendersettings);
        frame.RenderFrame();
        this.setCenter(gameview);
    }
}
