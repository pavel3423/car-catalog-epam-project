package by.htp.car_catalog.service.utils.sequrity;

import java.security.SecureRandom;

public class Salt {
    private Salt() {
    }

    public static String getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[64];
        random.nextBytes(salt);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salt.length; i++) {
            sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt());
    }
}
