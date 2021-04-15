package sample.crypto;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureBaseRSA;
import com.sun.org.apache.xml.internal.security.signature.XMLSignatureException;
import sun.security.mscapi.RSACipher;

import java.util.Base64;
import java.util.Random;

public class CoderAndDecoder {
    private static int textLength;
    private static int d;

    public static String decode(String text) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded1 = decoder.decode(text);
        return new String(decoded1);
    }

    public static String encode(String text) {
        Base64.Encoder encoder = Base64.getEncoder();
        Random random = new Random();
        d = random.nextInt(1000);
        setTextLength(text.length());
        byte[] encoded = encoder.encode((text).getBytes());
        return new String(encoded);
    }

    public static int getTextLength() {
        return textLength;
    }

    public static void setTextLength(int textLength) {
        CoderAndDecoder.textLength = textLength;
    }

}