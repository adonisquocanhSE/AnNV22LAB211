package main;

import constants.CourseType;
import constants.Message;
import controller.StudentController;
import dto.StudentRequestDTO;
import java.util.Scanner;
import utils.Validation;

// Lop main dung de chay chuong trinh
public class Main {

    public static void main(String[] args) {
        // Tao scanner de nhap du lieu
        Scanner sc = new Scanner(System.in);
        // Tao controller
        StudentController controller = new StudentController();
        // Vong lap menu chinh
        while (true) {
            // Hien thi menu
            System.out.println(Message.MENU);
            // Yeu cau nhap lua chon
            System.out.print(Message.INPUT_CHOICE);
            try {
                // Validate lua chon tu 1 den 5
                int choice = Validation.getChoice(sc.nextLine(), 1, 5);
                switch (choice) {
                    // ================= CREATE =================
                    case 1:
                        while (true) {
                            // Tao DTO moi
                            StudentRequestDTO dto = new StudentRequestDTO();
                            // Nhap ID
                            System.out.print(Message.INPUT_ID);
                            dto.setId(Validation.getString(sc.nextLine()));
                            // Nhap ten
                            System.out.print(Message.INPUT_NAME);
                            dto.setName(Validation.getString(sc.nextLine()));
                            // Nhap semester
                            System.out.print(Message.INPUT_SEMESTER);
                            dto.setSemester(Validation.getString(sc.nextLine()));
                            CourseType course;

                            while (true) {
                                System.out.print(Message.INPUT_COURSE);

                                try {
                                    course = Validation.validateCourse(sc.nextLine());

                                    // hop le thi thoat
                                    if (course != null) {
                                        break;
                                    }

                                } catch (Exception e) {
                                    // neu ham validateCourse throw loi
                                    System.out.println(Message.INVALID_COURSE);
                                    continue;
                                }

                                // truong hop khong throw nhưng tra ve null
                                System.out.println(Message.INVALID_COURSE);
                            }
                            dto.setCourse(course);
                            // Goi controller tao sinh vien
                            controller.createStudent(dto);
                            // Neu da co it nhat 10 sinh vien thi hoi tiep tuc
                            if (!controller.isDatabaseLessThanTen()) {
                                System.out.print(Message.CONTINUE_CREATE);
                                String answer = Validation.validateYesNo(sc.nextLine());
                                // Neu chon N thi quay ve menu
                                if (answer.equals("N")) {
                                    break;
                                }
                            }
                        }
                        break;

                    // ================= FIND AND SORT =================
                    case 2:
                        System.out.print(Message.INPUT_SEARCH_NAME);
                        String keyword = Validation.getString(sc.nextLine());
                        controller.findAndSort(keyword);
                        break;
                    // ================= UPDATE / DELETE =================
                    case 3:
                        System.out.print(Message.INPUT_ID);
                        String id = Validation.getString(sc.nextLine());
                        System.out.print(Message.UPDATE_OR_DELETE);
                        String action = Validation.validateUpdateDelete(sc.nextLine());
                        // Neu chon update
                        if (action.equals("U")) {
                            StudentRequestDTO dto = new StudentRequestDTO();
                            dto.setId(id);
                            System.out.print(Message.INPUT_NAME);
                            dto.setName(Validation.getString(sc.nextLine()));
                            System.out.print(Message.INPUT_SEMESTER);
                            dto.setSemester(Validation.getString(sc.nextLine()));
                            CourseType course;
                            while (true) {
                                System.out.print(Message.INPUT_COURSE);
                                course = Validation.validateCourse(sc.nextLine());

                                if (course != null) {
                                    break;
                                }

                                System.out.println(Message.INVALID_COURSE);
                            }
                            dto.setCourse(course);
                            controller.updateStudent(id, dto);
                            System.out.println(Message.UPDATE_SUCCESS);
                        }
                        // Neu chon delete
                        if (action.equals("D")) {
                            controller.deleteStudent(id);
                            System.out.println(Message.DELETE_SUCCESS);
                        }
                        break;
                    // ================= REPORT =================
                    case 4:
                        controller.report();
                        break;
                    // ================= EXIT =================
                    case 5:
                        return;
                }

            } catch (Exception e) {
                // Bat loi va in thong bao
                System.out.println(e.getMessage());
            }
        }
    }
}
