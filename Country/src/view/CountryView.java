/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import dto.CountryResponseDTO;

/**
 *
 * @author Phạm Quốc Anh
 */
public class CountryView {

    //Danh sach chuoi chua thong tin quoc gia da duoc Controller xu ly
    private List<CountryResponseDTO> countryInfoList;

    //Nhan thong tin cac quoc gia tu Controller
    public void setCountryInfoList(List<CountryResponseDTO> countryInfoList) {
        this.countryInfoList = countryInfoList;
    }

    //Hien thi thong tin quoc gia ra man hinh
    public void display() {
        System.out.printf("%-15s%-20s%-15s%-15s\n", "ID", "Name", "Total Area", "Terrain");
        //in tung dong thong tin quoc gia
        for (CountryResponseDTO info : countryInfoList) {
            System.out.println(info);
        }
    }

}
