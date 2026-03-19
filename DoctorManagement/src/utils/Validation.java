package utils;

import constants.Message;
import java.util.Map;

public final class Validation {

    private Validation() {
    }

    //Kiem tra chuoi hop le
    public static String getString(String input) throws Exception {
        if ((input.equals(null)) || (input.trim().isEmpty())) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    //Kiem tra so nguyen duong
    public static int getPositiveInt(String input) throws Exception {
        try {
            int number = Integer.parseInt(input);
            if (number < 0) {
                throw new Exception(Message.INVALID_RANGE);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    //Kiem tra nhap lua chon hop le
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

}
