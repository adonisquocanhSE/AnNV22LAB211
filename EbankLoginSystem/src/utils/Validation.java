package utils;

import constants.RegexPattern;

public class Validation {

    //private constructor
    private Validation() {
    }

    //Kiểm tra và trả về số tài khoản hợp lệ
    public static String getUsername(String input, String errorMessage) throws Exception {
        if ((input == null) || (!input.matches(RegexPattern.USERNAME))) {
            throw new Exception(errorMessage);
        }
        return input.trim();
    }

    //Kiểm tra và trả về mật khẩu hợp lệ
    public static String getPassword(String input, String errorMessage) throws Exception {
        if ((input == null) || (!input.matches(RegexPattern.PASSWORD))) {
            throw new Exception(errorMessage);
        }
        return input.trim();
    }
    //Kiểm tra và trả về captcha hợp lệ

    public static String getCaptcha(String input, String errorMessage) throws Exception {
        if ((input == null) || (!input.matches(RegexPattern.CAPTCHA))) {
            throw new Exception(errorMessage);
        }
        return input.trim();
    }
    //Kiểm tra và trả về lựa chọn menu hợp lệ

    public static int getMenuOption(String input, String errorMessage) throws Exception {
        try {
            int option = Integer.parseInt(input);
            if ((option < 1) || (option > 3)) {
                throw new Exception(errorMessage);
            }
            return option;
        } catch (NumberFormatException e) {
            throw new Exception(errorMessage);
        }
    }

}
