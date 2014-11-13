package com.flnoc.LeasedLine;

/**
 * Created by Rokhdelar on 2014-11-13.
 */

import com.flnoc.LeasedLine.View.MainAppWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage mainStage;

    public Stage getMainStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("View/MainAppWindow.fxml"));
        Parent root=fxmlLoader.load();

        MainAppWindowController mainAppWindowController=fxmlLoader.getController();
        mainAppWindowController.setMainAppStage(primaryStage);

        Scene scene=new Scene(root,1024,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("X Tools...");
        primaryStage.show();
    }
}
