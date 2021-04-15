package sample;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import static sample.read.ReadDemo.*;

public class FileChooserClass{
    //public static String text = "";
    private static File res = null;

    public static void showFile(String title, byte type){
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        Image image = new Image("/icon/oo.png");
        primaryStage.getIcons().add(image);
        if (type==1) {
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                    "documents(*.txt, *.crypt)","*.crypt","*.txt"));
            res = fileChooser.showOpenDialog(primaryStage);
            if (res == null)return;
            ///else read(res.getAbsolutePath(),"UTF-8");
        }
        else if (type==3) {
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Crypt document", "*.crypt"));
            res = fileChooser.showSaveDialog(primaryStage);
        }
        else if (type==2) {
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text document", "*.txt"),
                    new FileChooser.ExtensionFilter("Word document", "*.doc"));
            res = fileChooser.showSaveDialog(primaryStage);
        }
        else JOptionPane.showMessageDialog(null,"Error !!!");
    }

    public static File getRes() {
        return res;
    }
    public static String getTxt(){
        if (res!=null) return res.getName();
        return null;
    }
}
