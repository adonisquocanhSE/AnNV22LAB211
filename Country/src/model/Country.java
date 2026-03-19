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
public class Country {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;
    //constructor khong chua tham so

    public Country() {
    }
    //constructor co tham so

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }
    //getter va setter

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    //Tra ve chuoi thong tin cua 1 quoc gia
    @Override
    public String toString() {
        return String.format("%-15s%-20s%-15.1f", countryCode, countryName, totalArea);
    }

}
