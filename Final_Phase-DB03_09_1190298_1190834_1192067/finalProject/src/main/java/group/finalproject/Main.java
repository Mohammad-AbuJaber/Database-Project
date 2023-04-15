package group.finalproject;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class Main extends Application {
    //    double x,y = 0.0;
    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;


        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setResizable(false);
        stage.setTitle("TMT Salaries Data Base Management System");
        stage.setScene(scene);
        stage.show();

    }

    public void changeScene(String fxml) throws IOException {
        Parent p = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(p);
    }

    public static void main(String[] args) {
        launch();
    }
}