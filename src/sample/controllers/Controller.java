package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.read.ReadDemo.readFile;
import static sample.FileChooserClass.*;
import static sample.read.ReadSafeFile.fileSave;
import static sample.crypto.CoderAndDecoder.decode;
import static sample.crypto.CoderAndDecoder.encode;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private MenuBar menu;

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem safeMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private Menu editMenu;

    @FXML
    private MenuItem deleteMenuItem;

    @FXML
    private MenuItem decodeMenuItem;

    @FXML
    private MenuItem codeMenuItem;

    @FXML
    private Menu helpMenu;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Button encodeBut;

    @FXML
    private Button safeBut1;

    @FXML
    private Button decodeBut;

    @FXML
    private Button safeBut2;

    private static String encode_text;
    private static String decode_text;

    @FXML
    void initialize() {
        /** MenuItem **/
        openMenuItem.setOnAction(event -> {
            System.out.println("MenuItem = <open>");
            showFile("Open", (byte) 1);
            if (getRes() != null) {
                String s2 = readFile(getRes(),"UTF-8");
                if (getTxt().endsWith(".txt")) {
                    textArea1.setText(s2);
                } else if (getTxt().endsWith("crypt")) {
                    textArea2.setText(s2);
                    s2 = null;
                }
            }else return;
        });
        safeMenuItem.setOnAction(event -> {
            System.out.println("MenuItem = <safe>");
            showFile("Open", (byte) 3);
        });
        newMenuItem.setOnAction(event -> {
            System.out.println("MenuItem = <new>");
        });
        closeMenuItem.setOnAction(event -> {
            System.out.println("MenuItem = <close>");
            int type = JOptionPane.showConfirmDialog(null, "Файл не сохранен! Хотите сохранит файл?");
            switch (type) {
                case JOptionPane.CANCEL_OPTION:
                case JOptionPane.CLOSED_OPTION:
                    break;
                case JOptionPane.YES_OPTION:
                    showFile("Safe", (byte) 2);
                    break;
            }
        });
        deleteMenuItem.setOnAction(event -> {
            if (textArea1.isFocused()) textArea1.setText("");
            if (textArea2.isFocused()) textArea2.setText("");

        });
        decodeMenuItem.setOnAction(event -> {
            System.out.println("MenuItem = <decode>");
            if (textArea2.getText() != "") {
                textArea1.setText(decode(textArea2.getText()));
            }
        });
        codeMenuItem.setOnAction(event -> {
            System.out.println("MenuItem = <code>");
            textArea2.setText(encode(textArea1.getText()));
        });
        aboutMenuItem.setOnAction(event -> {
            System.out.println("MenuItem = <help>");
            try {
                Stage stage = new Stage();
                stage.setTitle("About");
                stage.setResizable(false);
                Image image = new Image("/icon/oo.png");
                stage.getIcons().add(image);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/sample/fxml_files/about.fxml")), 490, 390));
                stage.showAndWait();
            } catch (IOException e) {
                System.out.println("fayl ne nayden");
            }
        });
        /*/** end menuItems */
        decodeBut.setOnAction(event -> {
            // if(!(textArea2.getText().isEmpty()))
            textArea1.setText(decode(textArea2.getText()));
        });
        encodeBut.setOnAction(event -> {
            if (!(textArea1.getText().isEmpty()))
                textArea2.setText(encode(textArea1.getText()));
        });
        safeBut1.setOnAction(event -> {
            showFile("Safe", (byte) 2);
            fileSave(getRes().getAbsolutePath(), textArea1.getText());
        });
        safeBut2.setOnAction(event -> {
            showFile("Safe", (byte) 3);
            fileSave(getRes().getAbsolutePath(), textArea2.getText());
            //System.out.println(textArea2.getText());
        });
        textArea1.setWrapText(true);
        textArea1.setEditable(true);
        textArea2.setWrapText(true);
        textArea2.setEditable(false);
        decode_text = textArea1.getText();
        encode_text = textArea2.getText();
    }
}
