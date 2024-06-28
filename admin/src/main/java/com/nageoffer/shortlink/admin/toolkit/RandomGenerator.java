package com.nageoffer.shortlink.admin.toolkit;

import java.security.SecureRandom;

/**
 * 分组 ID 随机生成器
 */
public final class RandomGenerator {

    private static final  String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 生成指定长度的短链接分组 ID
     *
     * @return 短链接分组 ID
     */
    public static String generateRandom() {
        return generateRandom(6);
    }

    /**
     * 生成指定长度的短链接分组 ID
     *
     * @param length 字符串长度
     * @return 随机字符串
     */
    public static String generateRandom(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
