package service;

import constants.CourseType;
import constants.Message;
import dto.ReportResponseDTO;
import dto.StudentRequestDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;
import model.StudentCourse;
import repository.StudentRepository;

public class StudentService {

    // Goi Repository de thao tac du lieu
    private StudentRepository repository;

    // Constructor: khoi tao Repository
    public StudentService() {
        repository = new StudentRepository();
    }

    //Tao sinh vien moi
    // tao sinh vien moi
    public boolean createStudent(StudentRequestDTO dto) throws Exception {

        // neu id da ton tai thi phai kiem tra trung du lieu
        if (repository.findById(dto.getId()) != null) {
            repository.checkDuplicate(repository.findById(dto.getId()), dto);
        }

        // sau khi hop le thi tien hanh them
        return repository.addStudent(dto);
    }

    //Cap nhat sinh vien
    public boolean updateStudent(String id, StudentRequestDTO dto) throws Exception {
        return repository.updateStudent(id, dto);
    }

    //Xoa sinh vien
    public boolean deleteStudent(String id) {
        return repository.deleteStudent(id);
    }

    //Tim kiem va sap xep sinh vien
    public List<ReportResponseDTO> findAndSort(String keyword) throws Exception {
        // Danh sach tam de luu sinh vien tim duoc
        List<Student> filtered = new ArrayList<>();
        // Duyet toan bo danh sach sinh vien
        for (Student s : repository.getAllStudents()) {
            // Kiem tra ten co chua tu khoa hay khong
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                filtered.add(s);
            }
        }
        // Neu khong tim thay sinh vien nao thi nem loi
        if (filtered.isEmpty()) {
            throw new Exception(Message.STUDENT_NOT_EXIST);
        }
        // Sap xep danh sach theo ten tang dan
        Collections.sort(filtered, Comparator.comparing(Student::getName));
        // Danh sach ket qua tra ve cho Controller
        List<ReportResponseDTO> result = new ArrayList<>();
        // Chuyen doi du lieu tu Model sang DTO
        for (Student s : filtered) {
            for (StudentCourse sc : s.getCourses()) {
                result.add(new ReportResponseDTO(
                        s.getName(),
                        sc.getCourse().name(), 1));
            }
        }
        return result;
    }

    //Bao cao sinh vien
    public List<ReportResponseDTO> report() {
        // Danh sach ket qua tra ve
        List<ReportResponseDTO> result = new ArrayList<>();
        // Duyet tung sinh vien
        for (Student s : repository.getAllStudents()) {
            // Map luu so lan hoc theo tung CourseType
            Map<CourseType, Integer> courseCount = new HashMap<>();
            // Duyet tung mon hoc cua sinh vien
            for (StudentCourse sc : s.getCourses()) {
                CourseType type = sc.getCourse();
                // Neu chua co trong Map thi mac dinh la 0
                // Sau do tang len 1
                courseCount.put(type, courseCount.getOrDefault(type, 0) + 1);
            }
            // Dua du lieu tu Map sang DTO
            for (Map.Entry<CourseType, Integer> entry : courseCount.entrySet()) {
                result.add(new ReportResponseDTO(
                        s.getName(),
                        entry.getKey().name(),
                        entry.getValue()));
            }
        }
        return result;
    }

    // Kiem tra database co rong hay khong
    public boolean isEmpty() {
        return repository.isEmpty();
    }

    //Cho ra tong so hoc sinh da them vao
    public int getTotalStudents() {
        return repository.getAllStudents().size();
    }
}
