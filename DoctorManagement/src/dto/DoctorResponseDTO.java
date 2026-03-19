/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 * @dto dung de tra du lieu ra View
 * @author Phạm Quốc Anh
 */
public class DoctorResponseDTO {

    private String code;
    private String name;
    private String specialization;
    private int availability;
    //Constructor co chua tham so

    public DoctorResponseDTO(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    //Getter de lay thong tin hien thi du lieu ra View
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAvailability() {
        return availability;
    }

    //Dinh dang thong tin de in ra man hinh
    @Override
    public String toString() {
        return String.format("%-10s%-15s%-20s%-10d", code, name, specialization, availability);
    }

}
