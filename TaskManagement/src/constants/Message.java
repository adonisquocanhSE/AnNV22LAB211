package constants;

public final class Message {

    //private constructor
    private Message() {
    }
    //Message hien thi Menu
    public static final String MENU
            = "\n========= Task Program =========\n"
            + "1. Add Task\n"
            + "2. Delete Task\n"
            + "3. Display Task\n"
            + "4. Exit\n";
    //Message hien thi nhap lieu
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_REQUIREMENT = "Requirement Name: ";
    public static final String INPUT_TASK_TYPE = "Task Type: ";
    public static final String INPUT_DATE = "Date: ";
    public static final String INPUT_FROM = "From: ";
    public static final String INPUT_TO = "To: ";
    public static final String INPUT_ASSIGNEE = "Assignee: ";
    public static final String INPUT_REVIEWER = "Reviewer: ";
    public static final String INPUT_ID = "Enter ID: ";
    //Message hien thi loi
    public static final String EMPTY_INPUT = "Input cannot be empty";
    public static final String INVALID_NUMBER = "Invalid number!";
    public static final String INVALID_RANGE = "Value is out of allowed range";
    public static final String INVALID_DATE = "Invalid date format";
    public static final String TASK_NOT_EXIST = "Task does not exist";
}
