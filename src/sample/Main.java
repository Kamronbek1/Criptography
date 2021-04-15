package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        int w = 990,h = 590;
        Parent root = FXMLLoader.load(getClass().getResource("fxml_files/ncrypto.fxml"));
        Image image = new Image("/icon/oo.png");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("Cripton");
        primaryStage.setScene(new Scene(root,w,h));
        primaryStage.show();
    }


    public static void main(String[] args) {
       // Application.launch(args);
        Application.launch(Main.class, args);
    }
}
