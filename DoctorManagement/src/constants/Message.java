/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author Phạm Quốc Anh
 */
public final class Message {

    //private constructor
    private Message() {

    }
    //Message hien thi Menu
    public static final String MENU
            = "\n========= Doctor Management =========\n"
            + "1. Add Doctor\n"
            + "2. Update Doctor\n"
            + "3. Delete Doctor\n"
            + "4. Search Doctor\n"
            + "5. Exit\n";

    //Message thong bao nhap
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_DOCTOR_CODE = "Enter Code: ";
    public static final String INPUT_DOCTOR_NAME = "Enter Name: ";
    public static final String INPUT_DOCTOR_SPECIALIZATION = "Enter Specialization: ";
    public static final String INPUT_DOCTOR_AVAILABILITY = "Enter Availability: ";
    public static final String INPUT_DOCTOR_SEARCH = "Enter text: ";
    //Message thong bao loi
    public static final String EMPTY_INPUT = "Input cannot be empty";
    public static final String INPUT_DUPLICATE = "Doctor code is duplicate!";
    public static final String DOCTOR_NOT_AVAILABLE = "Doctor does not exist!";
    public static final String INVALID_NUMBER = "Invalid number!";
    public static final String DATABASE_EMPTY = "Database is empty!";
    public static final String INVALID_RANGE = "Value is out of allowed range";
}
