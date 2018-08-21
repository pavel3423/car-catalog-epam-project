package by.htp.car_catalog.service.utils.sequrity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private Hash() {
    }

    public static String getHash(String password, String salt) {
        String passWithSalt = password + salt;
        MessageDigest sha256 = null;
        try {
            sha256 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            //TODO logger
            e.printStackTrace();
        }
        byte[] passBytes = passWithSalt.getBytes();
        byte[] passHash = sha256.digest(passBytes);
        StringBuilder sb = new StringBuilder();
        for (byte aPassHash : passHash) {
            sb.append(Integer.toString((aPassHash & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

}
