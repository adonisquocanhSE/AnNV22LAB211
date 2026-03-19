package dto;

// DTO dung de hien thi ket qua report
public class ReportResponseDTO {

    // Ten sinh vien
    private String studentName;

    // Ten mon hoc
    private String course;

    // So lan hoc mon do
    private int total;

    // Constructor khoi tao du lieu report
    public ReportResponseDTO(String studentName, String course, int total) {
        this.studentName = studentName;
        this.course = course;
        this.total = total;
    }

    // Ghi de toString de hien thi dung format
    @Override
    public String toString() {
        return studentName + " | " + course + " | " + total;
    }
}
