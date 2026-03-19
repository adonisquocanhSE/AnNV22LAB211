package repository;

import constants.Message;
import dto.StudentRequestDTO;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import model.StudentCourse;

public class StudentRepository {

    // danh sach luu tru toan bo sinh vien
    private List<Student> studentList;

    // khoi tao danh sach rong
    public StudentRepository() {
        studentList = new ArrayList<>();
    }

    // ================= ADD =================
    // ham nay chi lam nhiem vu them sinh vien, KHONG check trung
    public boolean addStudent(StudentRequestDTO dto) {

        // tim sinh vien theo id
        Student student = findById(dto.getId());

        // neu chua ton tai thi tao moi
        if (student == null) {
            student = new Student(dto.getId(), dto.getName());
            studentList.add(student);
        }

        // them course moi vao danh sach cua sinh vien
        student.addCourse(new StudentCourse(dto.getSemester(), dto.getCourse()));
        return true;
    }

    // ================= UPDATE =================
    // cap nhat thong tin sinh vien va them course moi
    public boolean updateStudent(String id, StudentRequestDTO dto) throws Exception {

        // tim sinh vien theo id
        Student student = findById(id);

        // neu khong ton tai thi khong update duoc
        if (student == null) {
            throw new Exception(Message.STUDENT_NOT_EXIST);
        }

        // goi ham check trung de dam bao du lieu hop le
        checkDuplicate(student, dto);

        // cap nhat ten sinh vien
        student.updateInfo(dto.getName());

        // them course moi (khong xoa course cu)
        student.addCourse(new StudentCourse(dto.getSemester(), dto.getCourse()));

        return true;
    }

    // ================= CHECK DUPLICATE =================
    // ham nay chi chiu trach nhiem kiem tra trung du lieu
    public void checkDuplicate(Student student, StudentRequestDTO dto) throws Exception {

        // neu id trung nhung ten khac -> loi
        if (!student.getName().equalsIgnoreCase(dto.getName())) {
            throw new Exception(Message.DUPLICATE_ID);
        }

        // kiem tra trung semester + course
        // 1 semester co the hoc nhieu mon, nhung khong duoc hoc 1 mon 2 lan
        for (StudentCourse sc : student.getCourses()) {
            if ((sc.getSemester().equalsIgnoreCase(dto.getSemester()))
                    && (sc.getCourse() == dto.getCourse())) {

                throw new Exception(Message.DUPLICATE_COURSE);
            }
        }
    }

    // ================= DELETE =================
    // xoa sinh vien khoi danh sach
    public boolean deleteStudent(String id) {

        Student student = findById(id);

        // neu khong tim thay thi khong xoa duoc
        if (student == null) {
            return false;
        }

        studentList.remove(student);
        return true;
    }

    // ================= FIND =================
    // tim sinh vien theo id
    public Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // lay toan bo danh sach sinh vien
    public List<Student> getAllStudents() {
        return studentList;
    }

    // kiem tra danh sach co rong hay khong
    public boolean isEmpty() {
        return studentList.isEmpty();
    }
}
