/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Phạm Quốc Anh
 */
public class Rectangle extends Shape {

    private double width;
    private double length;

    //constuctor khong tham so
    public Rectangle() {
    }
    //constructor co tham so

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    //Tinh chu vi
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    //Tinh dien tich
    @Override
    public double getArea() {
        return width * length;
    }

    //Tra ve chuoi
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Width: ").append(width);
        sb.append("\nLength: ").append(length);
        sb.append("\nArea: ").append(getArea());
        sb.append("\nPerimeter: ").append(getPerimeter());
        return sb.toString();
    }

}
