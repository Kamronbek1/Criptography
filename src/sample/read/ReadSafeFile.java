package sample.read;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class ReadSafeFile {

    public static String text = "";
   /* public static void fileOpen(String path) {
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Ошибка при чтении файла!!!");
        }
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
            text += scanner.nextLine();
        }
        scanner.close();
    }*/
    public static void fileSave(String filepath, String text) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
            out.write(text);
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Faylni saqlashda xatolik yuzberdi!" +
                    "\nIltimos faylni boshqatdan saqlang");
        }
    }
}
