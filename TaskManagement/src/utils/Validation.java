package utils;

import constants.Message;
import constants.TaskType;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Validation {

    private Validation() {
    }

    // Chuoi khong duoc rong
    public static String getString(String input) throws Exception {
        if ((input.equals(null)) || (input.trim().isEmpty())) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    // So nguyen duong
    public static int getPositiveInt(String input) throws Exception {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                throw new Exception(Message.INVALID_RANGE);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    // So thuc duong
    public static double getPositiveDouble(String input) throws Exception {
        try {
            double value = Double.parseDouble(input);
            if (value <= 0) {
                throw new Exception(Message.INVALID_RANGE);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    // Validate task type
    public static int validateTaskType(String input) throws Exception {

        try {
            int id = Integer.parseInt(input);

            if (id < 1 || id > 4) {
                throw new Exception(Message.INVALID_RANGE);
            }

            return id;

        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    // Validate date
    public static Date validateDate(String input) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            return sdf.parse(input);
        } catch (Exception e) {
            throw new Exception(Message.INVALID_DATE);
        }
    }

    // Validate working time
    public static void validatePlanTime(double from, double to) throws Exception {
        if ((from < 8.0) || (to > 17.5) || (from >= to)) {
            throw new Exception(Message.INVALID_RANGE);
        }
    }

    // Validate menu choice
    public static int getChoice(String input, int min, int max) throws Exception {
        int choice = getPositiveInt(input);
        if ((choice < min) || (choice > max)) {
            throw new Exception(Message.INVALID_RANGE);
        }
        return choice;
    }
}
