package model;

import java.util.ArrayList;
import java.util.List;

// Lop Student co quan he 1 - N voi StudentCourse
public class Student {

    // Ma sinh vien
    private String id;

    // Ten sinh vien
    private String name;

    // Danh sach cac cap semester + course
    private List<StudentCourse> courses;

    // Constructor khoi tao sinh vien
    public Student(String id, String name) {

        // Gan id
        this.id = id;

        // Gan ten
        this.name = name;

        // Khoi tao danh sach rong
        this.courses = new ArrayList<>();
    }

    // Getter lay id
    public String getId() {
        return id;
    }

    // Getter lay ten
    public String getName() {
        return name;
    }
   
    // Getter lay danh sach course
    public List<StudentCourse> getCourses() {
        return courses;
    }

    // Them mot cap semester + course vao sinh vien
    public void addCourse(StudentCourse sc) {
        courses.add(sc);
    }
    //Cap nhat ten
    public void updateInfo(String newName) {
        this.name = newName;
    }
}
