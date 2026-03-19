package utils;

import constants.Message;
import java.util.List;

public final class Validation {

    //private constructor
    private Validation() {
    }

    //Kiem tra chuoi hop le
    public static String getString(String input) throws Exception {
        if ((input.equals(null)) || (input.trim().isEmpty())) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    //Kiem tra va chuyen doi chuoi sang so thuc duong
    public static float getPositiveFloat(String input) throws Exception {
        try {
            float number = Float.parseFloat(input);
            if (number <= 0) {
                throw new Exception(Message.POSITIVE_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Kiem tra lua chon Menu nam trong khoang cho phep
    public static int getChoice(String input, int min, int max) throws Exception {
        try {
            int choice = Integer.parseInt(input);
            if ((choice < min) || (choice > max)) {
                throw new Exception(Message.INVALID_RANGE);
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    // Check danh sach rong (dung cho case 2,3,4)
    public static void checkEmptyList(List<?> list) throws Exception {
        if ((list.equals(null)) || (list.isEmpty())) {
            throw new Exception(Message.NO_COUNTRY_AVAILABLE);
        }
    }
}
