/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Phạm Quốc Anh
 */
public class CountryResponseDTO {

    private String countryCode;
    private String countryName;
    private float totalArea;
    private String terrain;

    //constructor co chua tham so
    public CountryResponseDTO(String countryCode, String countryName, float totalArea, String terrain) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
        this.terrain = terrain;
    }

    //Getter muc dich hien thi ra view
    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public String getTerrain() {
        return terrain;
    }

    //Dinh dang hien thi ra man hinh
    @Override
    public String toString() {
        return String.format("%-15s%-20s%-15.2f%-15s",
                countryCode, countryName, totalArea, terrain);
    }

}
