/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constants.Message;
import controller.ShapeController;
import dto.ShapeDTO;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width;
        double length;
        double radius;
        double sideA;
        double sideB;
        double sideC;

        //Hien thi tieu de
        System.out.println(Message.TITLE);

        //Nhap va kiem tra tinh hop le chieu rong
        do {
            try {
                System.out.println(Message.WIDTH_NOTIFICATION);
                width = utils.Validation.getDouble(sc.nextLine(), Double.MIN_VALUE, 100);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        //Nhap va kiem tra tinh hop le chieu dai (phai lon hon hoac bang chieu rong)
        do {
            try {
                System.out.println(Message.LENGTH_NOTIFICATION);
                length = utils.Validation.getDouble(sc.nextLine(), width, 100);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        //Nhap ban kinh
        do {
            try {
                System.out.println(Message.RADIUS_NOTIFICATION);
                radius = utils.Validation.getDouble(sc.nextLine(), Double.MIN_VALUE, 100);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        //Nhap va kiem tra tinh hop le 3 canh tam giac
        while (true) {
            try {
                System.out.println(Message.SIDE_A_NOTIFICATION);
                sideA = utils.Validation.getDouble(sc.nextLine(), Double.MIN_VALUE, 100);
                System.out.println(Message.SIDE_B_NOTIFICATION);
                sideB = utils.Validation.getDouble(sc.nextLine(), Double.MIN_VALUE, 100);
                System.out.println(Message.SIDE_C_NOTIFICATION);
                sideC = utils.Validation.getDouble(sc.nextLine(), Double.MIN_VALUE, 100);
                //kiem tra bat dang thuc tam giac
                if (sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
                    break;
                } else {
                    System.out.println(Message.SUM_SIDE_ERROR);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //Luu tru du lieu vao DTO va chuyen qua Controller de xu ly
        ShapeDTO dto = new ShapeDTO();
        dto.setWidth(width);
        dto.setLength(length);
        dto.setRadius(radius);
        dto.setSideA(sideA);
        dto.setSideB(sideB);
        dto.setSideC(sideC);
        ShapeController controller = new ShapeController();
        controller.setShapeDTO(dto);
        controller.createShape();
    }

}
