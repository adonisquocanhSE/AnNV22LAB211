package main;

import constants.Message;
import controller.TaskController;
import dto.TaskRequestDTO;
import java.util.Date;
import java.util.Scanner;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        //Nhap tu ban phim nguoi dung
        Scanner sc = new Scanner(System.in);
        TaskController controller = new TaskController();

        while (true) {
            //Hien thi Menu va nhap lua chon
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);

            try {
                int choice = Validation.getChoice(sc.nextLine(), 1, 4);

                switch (choice) {
                    case 1:
                        //Them task
                        TaskRequestDTO dto = new TaskRequestDTO();
                        //Nhap Requirement
                        System.out.print(Message.INPUT_REQUIREMENT);
                        dto.setRequirementName(
                                Validation.getString(sc.nextLine()));
                        //Nhap Task Type
                        System.out.print(Message.INPUT_TASK_TYPE);
                        dto.setTaskTypeId(
                                Validation.validateTaskType(sc.nextLine()));
                        //Nhap Date
                        System.out.print(Message.INPUT_DATE);
                        String dateStr = Validation.getString(sc.nextLine());
                        Date date = Validation.validateDate(dateStr);
                        dto.setDate(date);
                        //Nhap thoi gian bat dau
                        System.out.print(Message.INPUT_FROM);
                        double from = Validation.getPositiveDouble(sc.nextLine());
                        dto.setFrom(from);
                        //Nhap thoi gian ket thuc
                        System.out.print(Message.INPUT_TO);
                        double to = Validation.getPositiveDouble(sc.nextLine());
                        dto.setTo(to);

                        Validation.validatePlanTime(from, to);
                        //Nhap thong tin nguoi duoc giao viec
                        System.out.print(Message.INPUT_ASSIGNEE);
                        dto.setAssignee(
                                Validation.getString(sc.nextLine()));
                        //Nhap thong tin nguoi giao viec
                        System.out.print(Message.INPUT_REVIEWER);
                        dto.setReviewer(
                                Validation.getString(sc.nextLine()));

                        controller.addTask(dto);
                        break;

                    case 2:
                        //Xoa task
                        System.out.print(Message.INPUT_ID);
                        int id = Validation.getPositiveInt(sc.nextLine());
                        controller.deleteTask(id);
                        break;

                    case 3:
                        //Hien thi task
                        controller.displayTasks();
                        break;

                    case 4:
                        //Ket thuc chuong trinh
                        return;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
