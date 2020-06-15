package com.paul.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public MenuBar createMenu(){
        Menu fileMenu =new Menu("File");
        MenuItem newMenuItem = new MenuItem("New Game");

        newMenuItem.setOnAction(event -> controller.resetGame());

        MenuItem resetMenuItem = new MenuItem("Reset Game");

        resetMenuItem.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitMenuItem = new MenuItem("Exit Game");

        exitMenuItem.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newMenuItem,resetMenuItem,separatorMenuItem,exitMenuItem);


        Menu helpMenu =new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Game");

        aboutGame.setOnAction(event -> {
            aboutGame();
        });

        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();

        MenuItem aboutMe = new MenuItem("About Me");

        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separatorMenuItem1,aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Baishalee Paul");
        alert.setContentText("I am a beginner in building desktop applications in JavaFX and Connect4 is the first one I have built. I love coding in Java and aim in becoming a pro at it soon. ");
        alert.show();
    }

    private void aboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How to play?");
        alert.setContentText("Connect Four (also known as Four Up, Plot Four, Find Four, Four in a Row, Four in a Line, Drop Four, and Gravitrips " +
                "(in Soviet Union)) is a two-player connection board game in which the players first choose a color and then take turns dropping one " +
                "colored disc from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the lowest" +
                " available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of " +
                "four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves. ");
        alert.show();

    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
