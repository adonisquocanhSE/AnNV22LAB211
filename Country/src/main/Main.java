package main;

import constants.Message;
import controller.CountryController;
import dto.CountryRequestDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        //Khoi tao nhap du lieu tu ban phim
        Scanner sc = new Scanner(System.in);
        CountryController controller = new CountryController();

        while (true) {
            //Hien thi Menu
            System.out.println(Message.MENU);
            System.out.print(Message.INPUT_CHOICE);

            try {
                //Lay lua chon Menu va kiem tra hop le
                int choice = Validation.getChoice(sc.nextLine(), 1, 5);
                //Xu ly theo lua chon cua nguoi dung
                switch (choice) {
                    case 1:
                        //Tao doi tuong dto de chua du lieu nhap vao
                        CountryRequestDTO dto = new CountryRequestDTO();
                        //Nhap ma quoc gia
                        System.out.println(Message.INPUT_CODE);
                        dto.setCode(Validation.getString(sc.nextLine()));
                        //Nhap ten quoc gia
                        System.out.println(Message.INPUT_NAME);
                        dto.setName(Validation.getString(sc.nextLine()));
                        //Nhap dien tich quoc gia
                        System.out.println(Message.INPUT_AREA);
                        dto.setArea(Validation.getPositiveFloat(sc.nextLine()));
                        //Nhap dia hinh quoc gia 
                        System.out.println(Message.INPUT_TERRAIN);
                        dto.setTerrain(Validation.getString(sc.nextLine()));
                        //Goi controller de them quoc gia moi
                        controller.addCountryInformation(dto);
                        break;

                    case 2:
                        //Hien thi thong tin quoc gia vua nhap
                        Validation.checkEmptyList(controller.getAllCountries());
                        controller.getRecentlyEnteredInformation();
                        break;

                    case 3:
                        //Nhap ten quoc gia can tim
                        Validation.checkEmptyList(controller.getAllCountries());
                        System.out.println(Message.INPUT_SEARCH);
                        //tim kiem quoc gia theo ten
                        controller.searchInformationByName(
                                Validation.getString(sc.nextLine()));
                        break;

                    case 4:
                        //Sap xep va hien thi quoc gia theo ten tang dan
                        Validation.checkEmptyList(controller.getAllCountries());
                        controller.sortInformationByAscendingOrder();
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
