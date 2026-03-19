package main;

import constants.Message;
import controller.DoctorController;
import dto.DoctorRequestDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoctorController controller = new DoctorController();

        while (true) {
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);

            try {
                int choice = Validation.getChoice(sc.nextLine(), 1, 5);

                switch (choice) {

                    case 1:
                        //Them bac si
                        DoctorRequestDTO addDto = new DoctorRequestDTO();

                        System.out.print(Message.INPUT_DOCTOR_CODE);
                        String code = Validation.getString(sc.nextLine());
                        addDto.setCode(code);
                        //Nhap ten bac si
                        System.out.print(Message.INPUT_DOCTOR_NAME);
                        addDto.setName(Validation.getString(sc.nextLine()));
                        //Nhap chuyen nganh cua bac si
                        System.out.print(Message.INPUT_DOCTOR_SPECIALIZATION);
                        addDto.setSpecialization(
                                Validation.getString(sc.nextLine())
                        );
                        //Nhap availability
                        System.out.print(Message.INPUT_DOCTOR_AVAILABILITY);
                        addDto.setAvailability(
                                Validation.getPositiveInt(sc.nextLine())
                        );

                        controller.addDoctor(addDto);
                        break;

                    case 2:

                        DoctorRequestDTO updateDto = new DoctorRequestDTO();

                        System.out.print(Message.INPUT_DOCTOR_CODE);
                        String updateCode = Validation.getString(sc.nextLine());

                        updateDto.setCode(updateCode);

                        System.out.print(Message.INPUT_DOCTOR_NAME);
                        updateDto.setName(Validation.getString(sc.nextLine()));

                        System.out.print(Message.INPUT_DOCTOR_SPECIALIZATION);
                        updateDto.setSpecialization(Validation.getString(sc.nextLine()));

                        System.out.print(Message.INPUT_DOCTOR_AVAILABILITY);
                        updateDto.setAvailability(
                                Validation.getPositiveInt(sc.nextLine())
                        );

                        controller.updateDoctor(updateDto);
                        break;

                    case 3:

                        DoctorRequestDTO deleteDto = new DoctorRequestDTO();

                        System.out.print(Message.INPUT_DOCTOR_CODE);
                        String deleteCode = Validation.getString(sc.nextLine());

                        deleteDto.setCode(deleteCode);
                        controller.deleteDoctor(deleteDto);
                        break;

                    case 4:

                        System.out.print(Message.INPUT_DOCTOR_SEARCH);
                        String input = Validation.getString(sc.nextLine());
                        controller.searchDoctor(input);
                        break;

                    case 5:
                        //Thoat chuong trinh
                        return;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
