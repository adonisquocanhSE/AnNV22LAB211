package constants;
// Enum dinh nghia cac loai task trong he thong

public enum TaskType {
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");

    private int id;
    private String name;

    //construtor cua enum 
    TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Ham chuyen doi id sang TaskType tuong ung
    public static TaskType fromId(int id) {
        for (TaskType t : values()) {
            if (t.id == id) {
                return t;
            }
        }
        return null;
    }

    //Lay ten loai task de hien thi ra view
    public String getName() {
        return name;
    }
}
