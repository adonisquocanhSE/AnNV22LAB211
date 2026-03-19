package controller;

import constants.Message;
import dto.ReportResponseDTO;
import dto.StudentRequestDTO;
import java.util.List;
import service.StudentService;
import view.StudentView;

public class StudentController {
    // Goi Service de xu ly nghiep vu

    private StudentService studentService;
    // Goi View de hien thi du lieu ra man hinh
    private StudentView studentView;

    // Constructor khoi tao Service va View
    public StudentController() {
        studentService = new StudentService();
        studentView = new StudentView();
    }
    //Tao sinh vien moi

    public void createStudent(StudentRequestDTO dto) throws Exception {
        // Goi Service thuc hien them sinh vien
        studentService.createStudent(dto);
    }

    //Cap nhat sinh vien
    public void updateStudent(String id, StudentRequestDTO dto) throws Exception {
        // Goi Service cap nhat
        boolean result = studentService.updateStudent(id, dto);
        // Neu sinh vien khong ton tai thi bao loi
        if (!result) {
            throw new Exception(Message.STUDENT_NOT_EXIST);
        }
    }

    //Xoa sinh vien
    public void deleteStudent(String id) throws Exception {
        // Goi Service xoa
        boolean result = studentService.deleteStudent(id);
        // Neu khong tim thay sinh vien thi nem loi
        if (!result) {
            throw new Exception(Message.STUDENT_NOT_EXIST);
        }
    }
    //Ham tim kiem va sap xep danh sach sinh vien
    public void findAndSort(String keyword) throws Exception {

        // Kiem tra database co du lieu hay khong
        if (studentService.isEmpty()) {
            throw new Exception(Message.DATABASE_EMPTY);
        }
        // Lay danh sach ket qua tu Service
        List<ReportResponseDTO> result = studentService.findAndSort(keyword);
        // Truyen du lieu sang View de hien thi
        studentView.setReportData(result);
        // Goi View hien thi du lieu
        studentView.display();
    }

    //Bao cao sinh vien
    public void report() throws Exception {
        // Kiem tra database rong
        if (studentService.isEmpty()) {
            throw new Exception(Message.DATABASE_EMPTY);
        }
        // Lay du lieu bao cao tu Service
        List<ReportResponseDTO> data = studentService.report();
        // Truyen du lieu qua View
        studentView.setReportData(data);
        // Hien thi ket qua
        studentView.display();
    }

    //Neu so sinh vien nhap vao < 10
    public boolean isDatabaseLessThanTen() {
        return studentService.getTotalStudents() < 10;
    }
}
