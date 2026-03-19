package utils;

import constants.Message;

/**
 *
 * @author Phạm Quốc Anh
 */
public final class Validation {

    //Chan khong cho tao object
    private Validation() {
    }

    //Kiem tra va chuyen doi String sang double trong khoang [min, max]
    public static double getDouble(String input, double min, double max) throws Exception {
        try {
            double number = Double.parseDouble(input);
            
            if (number < min || number > max) {
                throw new Exception(
                        String.format(Message.NUMBER_RANGE_ERROR, min, max)
                );
            }
            return number;
            
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER_ERROR);
        }
    }

    //Kiem tra chuoi rong
    public static String getString(String input) throws Exception {
        if (input.equals(null) || input.trim().isEmpty()) {
            throw new Exception("Input string cannot be empty!");
        }
        return input.trim();
    }

    // Kiem tra gia tri Yes / No & Tra ve true neu Y, false neu N
    public static boolean checkYN(String input) throws Exception {
        if (input.equalsIgnoreCase("y")) {
            return true;
        }
        if (input.equalsIgnoreCase("n")) {
            return false;
        }
        throw new Exception("Please input Y or N only!");
    }
}
