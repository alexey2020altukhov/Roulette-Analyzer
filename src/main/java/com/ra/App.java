package com.ra;

import com.ra.service.GameService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage appStage;

    @Override
    public void start(Stage stage) throws IOException {
        setAppStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Анализатор рулетки");
        stage.setScene(scene);
        stage.show();
    }

    private void setAppStage(Stage stage) {
        App.appStage = stage;
    }

    public static Stage getAppStage() {
        return App.appStage;
    }

    @Override
    public void stop() throws IOException {
        if(GameService.getGameSettings().isAutomaticallySaveGameAfterExiting()) {
            GameService.saveGame();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}