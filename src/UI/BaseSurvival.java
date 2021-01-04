package UI;

import Model.MapTileVisualLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BaseSurvival extends Application {
    public static boolean ALLOWDEBUGOPTIONS = true;

    public static void main(String[] args) {
        // Init assets first (Generate and load object)
        MapTileVisualLoader.getInstance();

        // Launch program.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Base Survival");
        MainScreen screen = new MainScreen();
        Scene scene = new Scene(screen, 1280,720);
        handleInput(scene, screen);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void handleInput(Scene scene, MainScreen screen) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                screen.MoveRenderNorth(1);
            } else if (event.getCode() == KeyCode.A){
                screen.MoveRenderWest(1);
            } else if (event.getCode() == KeyCode.S){
                screen.MoveRenderSouth(1);
            } else if (event.getCode() == KeyCode.D){
                screen.MoveRenderEast(1);
            } else if (event.getCode() == KeyCode.Z){
                screen.ZoomRender(1);
            } else if (event.getCode() == KeyCode.Q){
                screen.ZoomRender(-1);
            } else {
                System.out.println("Event other key pressed: " + event.getCode());
            }
        });
    }
}
