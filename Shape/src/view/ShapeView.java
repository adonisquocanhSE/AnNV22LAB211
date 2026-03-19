/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Phạm Quốc Anh
 */
public class ShapeView {

    private String rectangleInfo;
    private String circleInfo;
    private String triangleInfo;

    //Nhan du lieu hinh chu nhat
    public void setRectangleInfo(String rectangleInfo) {
        this.rectangleInfo = rectangleInfo;
    }

    //Nhan du lieu hinh tron
    public void setCircleInfo(String circleInfo) {
        this.circleInfo = circleInfo;
    }

    //Nhan du lieu hinh tam giac
    public void setTriangleInfo(String triangleInfo) {
        this.triangleInfo = triangleInfo;
    }

    //Hien thi thong tin
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println(rectangleInfo);
        System.out.println("-----Circle-----");
        System.out.println(circleInfo);
        System.out.println("-----Triangle-----");
        System.out.println(triangleInfo);
    }
}
