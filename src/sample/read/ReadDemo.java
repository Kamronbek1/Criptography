package sample.read;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadDemo {
    public static String s2 = "";
    public static StringBuffer sb = new StringBuffer();
/*
    public static void read(String path, String encoding) {
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(path))) {
                String sd;
                while ((sd = in.readLine()) != null) {
                    s2 += sd;
                }
                System.out.println(s2);
            }
        } catch (IOException e) {
            System.out.println("Fayl ne nayden");
        }
    }
*/
    public static String readFile(File file, String encoding) {
        InputStreamReader f = null;
        try {
            f = encoding == null ? new FileReader(file) : new InputStreamReader(new FileInputStream(file), encoding);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("mmxm");
        }
        try {
            char[] buf = new char[32768];
            int len = 0;
            while (true) {
                try {
                    if (!((len = f.read(buf, 0, buf.length)) >= 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.append(buf, 0, len);
            }
            return sb.toString();
        } finally {
            try {
                f.close();
            } catch (Exception e) {
            }
        }
    }
}