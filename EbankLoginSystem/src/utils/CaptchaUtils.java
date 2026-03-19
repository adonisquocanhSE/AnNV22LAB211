package utils;

import java.util.Random;

public final class CaptchaUtils {

    //private constructor
    private CaptchaUtils() {
    }

    public static String generateCaptcha() {
        // Khai báo biến random
        Random random = new Random();
        StringBuilder captchaBuilder = new StringBuilder();
        int base;
        int charCode;
        // Tạo từng ký tự ngẫu nhiên trong phạm vi A-Z, a-z, 0-9
        for (int i = 0; i < 6; i++) {
            base = Math.abs(random.nextInt()) % 62;
            charCode = 0;

            if (base < 26) {
                // A-Z (65-90)
                charCode = 65 + base;
            } else if (base < 52) {
                // a-z (97-122)
                charCode = 97 + (base - 26);
            } else {
                // 0-9 (48-57)
                charCode = 48 + (base - 52);
            }
            captchaBuilder.append((char) charCode);
        }
        return captchaBuilder.toString();
    }
}
