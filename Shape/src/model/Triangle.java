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
public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    //constructor khong tham so
    public Triangle() {
    }
    //constructor co tham so

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    //Tinh chu vi
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    //Tinh dien tich
    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    //Tra ve chuoi
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Side A: ").append(sideA);
        sb.append("\nSide B: ").append(sideB);
        sb.append("\nSide C: ").append(sideC);
        sb.append("\nArea: ").append(getArea());
        sb.append("\nPerimeter: ").append(getPerimeter());
        return sb.toString();
    }
}
