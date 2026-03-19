package utils;

import constants.CourseType;
import constants.Message;

// Lop xu ly validate du lieu dau vao
// Tat ca cac ham deu la static
// Khong cho tao doi tuong tu ben ngoai
public final class Validation {

    // Chan tao doi tuong
    private Validation() {
    }

    // Kiem tra chuoi khong duoc rong   
    public static String getString(String input)
            throws Exception {
        // Neu null hoac rong thi bao loi
        if ((input == null) || input.trim().isEmpty()) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        // Tra ve chuoi da duoc cat khoang trang
        return input.trim();
    }

    // Kiem tra lua chon nam trong khoang min - max
    public static int getChoice(String input, int min, int max) throws Exception {
        try {
            // Chuyen chuoi thanh so
            int choice = Integer.parseInt(input);
            // Kiem tra nam ngoai khoang cho phep
            if (choice < min || choice > max) {
                throw new Exception(Message.INVALID_RANGE);
            }
            return choice;
        } catch (NumberFormatException e) {
            // Neu khong phai so thi bao loi
            throw new Exception(Message.INVALID_NUMBER);
        }
    }

    // ================= VALIDATE COURSE =================
    // Chi chap nhan 3 khoa hoc JAVA, .NET, C++
    public static CourseType validateCourse(String input) throws Exception {
        // Kiem tra JAVA
        if (input.equalsIgnoreCase("JAVA")) {
            return CourseType.JAVA;
        }
        // Kiem tra .NET
        if (input.equalsIgnoreCase(".NET")) {
            return CourseType.DOT_NET;
        }
        // Kiem tra C++
        if (input.equalsIgnoreCase("C++")) {
            return CourseType.CPP;
        }
        // Neu khong trung voi gia tri nao thi bao loi
        throw new Exception(Message.INVALID_COURSE);
    }

    // ================= VALIDATE Y / N =================
    // Dung trong chuc nang continue create
    public static String validateYesNo(String input) throws Exception {
        if (input.equalsIgnoreCase("Y")
                || input.equalsIgnoreCase("N")) {
            // Tra ve chu in hoa de de xu ly
            return input.toUpperCase();
        }
        throw new Exception(Message.INVALID_YN);
    }

    // ================= VALIDATE U / D =================
    // Dung trong chuc nang update hoac delete
    public static String validateUpdateDelete(String input) throws Exception {
        if (input.equalsIgnoreCase("U") || input.equalsIgnoreCase("D")) {
            return input.toUpperCase();
        }
        throw new Exception(Message.INVALID_UD);
    }
}
