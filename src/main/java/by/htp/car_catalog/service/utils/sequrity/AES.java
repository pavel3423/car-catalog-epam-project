package by.htp.car_catalog.service.utils.sequrity;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class AES {
    private static final String ENCODING = "UTF-8";
    private static final String KEY;
    private static final String VECTOR;

    static {
        KEY = readFile("/home/skynet/IdeaProjects/key.crypt");
        VECTOR = readFile("/home/skynet/IdeaProjects/vector.crypt");
    }

    private AES() {
    }

    public static String encrypt(String value) {
        String key = null;
        try {
            IvParameterSpec iv = new IvParameterSpec(VECTOR.getBytes(ENCODING));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(ENCODING), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            key = Base64.encodeBase64String(encrypted);
        } catch (GeneralSecurityException | UnsupportedEncodingException e) {
            //TODO logger
            e.printStackTrace();
        }
        return key;
    }

    public static String decrypt(String encrypted) {
        byte[] original = null;
        try {
            IvParameterSpec iv = new IvParameterSpec(VECTOR.getBytes(ENCODING));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(ENCODING), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            original = cipher.doFinal(Base64.decodeBase64(encrypted));
        } catch (Exception e) {
            //TODO logger
            e.printStackTrace();
        }
        return new String(original);
    }

    private static String readFile(String path) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            //TODO logger
            e.printStackTrace();
        }
        return sb.toString();
    }
}
