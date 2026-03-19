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
    //Message cua so Menu
    public static final String MENU
            = "\n                               MENU\n"
            + "===========================================================================\n"
            + "1. Input the information of 11 countries in East Asia\n"
            + "2. Display the information of country you've just input\n"
            + "3. Search the information of country by user-entered name\n"
            + "4. Display the information of countries sorted name in ascending order\n"
            + "5. Exit\n"
            + "===========================================================================";

    //Message thong bao nhap
    public static final String INPUT_CODE = "Enter code of country:";
    public static final String INPUT_NAME = "Enter name of country:";
    public static final String INPUT_AREA = "Enter area of country:";
    public static final String INPUT_TERRAIN = "Enter terrain of country:";
    public static final String INPUT_CHOICE = "Enter your choice:";
    public static final String INPUT_SEARCH = "Enter the name you want to search for:";
    //Message thong bao loi
    public static final String EMPTY_INPUT = "Input cannot be empty";
    public static final String INVALID_RANGE = "Value is out of allowed range";
    public static final String POSITIVE_NUMBER = "Number must be greater than 0";
    public static final String DUPLICATE = "Country code is already existed!";
    public static final String INVALID_NUMBER = "Invalid number!";
    public static final String NO_COUNTRY_AVAILABLE = "No country information available!";
    public static final String MAX_11_COUNTRIES = "Maximum 11 countries are allowed!";
}
