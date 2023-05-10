package com.yz.poem_learning_master.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Date: 2023/5/8 16:48
 * Author: hez
 * Description:
 */
public class SHAUtils {

    private static final String[] HEX_DIGITS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte value : bytes) {
            result.append(byteToHexString(value));
        }
        return result.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = b + 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }

    /**
     * SHA加密
     * @param originalStr 原字符串
     * @return 加密字符串
     */
    public static String encrypt(String originalStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bytes = originalStr.getBytes(StandardCharsets.UTF_8);
        assert md5 != null;
        md5.update(bytes);
        return byteArrayToHexString(md5.digest());
    }
}
