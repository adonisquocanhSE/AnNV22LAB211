package dto;

// DTO dung de nhan du lieu tu nguoi dung
import constants.CourseType;

public class StudentRequestDTO {

    // Ma sinh vien
    private String id;

    // Ten sinh vien
    private String name;

    // Hoc ky
    private String semester;

    // Mon hoc dang string
    private CourseType course;

    // Getter va Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public CourseType getCourse() {
        return course;
    }

    public void setCourse(CourseType course) {
        this.course = course;
    }

}
