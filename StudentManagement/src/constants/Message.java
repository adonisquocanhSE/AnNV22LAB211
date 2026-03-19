package constants;

// Lop chua tat ca cac message dung chung trong chuong trinh
public final class Message {

    // Chan tao doi tuong tu ben ngoai
    private Message() {
    }

    // Menu chinh cua chuong trinh
    public static final String MENU
            = "\n======== Student Management ========\n"
            + "1. Create Student\n"
            + "2. Find and Sort\n"
            + "3. Update/Delete\n"
            + "4. Report\n"
            + "5. Exit\n";

    // Thong bao nhap lieu
    public static final String INPUT_CHOICE = "Enter your choice: ";
    public static final String INPUT_ID = "Enter Student ID: ";
    public static final String INPUT_NAME = "Enter Student Name: ";
    public static final String INPUT_SEMESTER = "Enter Semester: ";
    public static final String INPUT_COURSE = "Enter Course (JAVA/.NET/C++): ";
    public static final String INVALID_YN = "Please input Y or N";
    public static final String INVALID_UD = "Please input U or D";
    // Thong bao loi
    public static final String EMPTY_INPUT = "Input cannot be empty";
    public static final String INVALID_NUMBER = "Invalid number";
    public static final String INVALID_RANGE = "Value out of range";
    public static final String INVALID_COURSE = "Course must be JAVA, .NET or C++";
    public static final String DATABASE_EMPTY = "Database is empty";
    public static final String STUDENT_NOT_EXIST = "Student does not exist";
    public static final String DUPLICATE_COURSE = "Student already registered this course in this semester!";
    public static final String DUPLICATE_ID = "Student ID already exists with different name!";
    // Thong bao xac nhan
    public static final String CONTINUE_CREATE = "Do you want to continue (Y/N)? ";
    public static final String UPDATE_OR_DELETE = "Do you want to update (U) or delete (D): ";
    public static final String INPUT_SEARCH_NAME = "Enter student name to search: ";
    public static final String UPDATE_SUCCESS = "Update successful";
    public static final String DELETE_SUCCESS = "Delete successful";
    public static final String UPDATE_FAIL = "Update fail";
    public static final String DELETE_FAIL = "Delete fail";

}
