package model;

import constants.CourseType;

// Lop nay the hien 1 cap Semester + Course
// Day la doi tuong con trong quan he 1 - N voi Student
public class StudentCourse {

    // Hoc ky cua mon hoc
    private String semester;

    // Mon hoc theo enum
    private CourseType course;

    // Constructor khoi tao doi tuong
    public StudentCourse(String semester, CourseType course) {
        this.semester = semester;
        this.course = course;
    }

    // Getter lay hoc ky
    public String getSemester() {
        return semester;
    }

    // Getter lay mon hoc
    public CourseType getCourse() {
        return course;
    }
}
