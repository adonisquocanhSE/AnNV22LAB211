/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.EastAsiaCountries;
import dto.CountryRequestDTO;
import dto.CountryResponseDTO;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Phạm Quốc Anh
 */
public class CountryRepository {

    //khoi tao danh sach chua cac quoc gia
    private List<EastAsiaCountries> countryList;
    //constructor

    public CountryRepository() {
        countryList = new ArrayList<>();
    }

    //Them quoc gia moi
    public void add(CountryRequestDTO requestDTO) {
        EastAsiaCountries country = new EastAsiaCountries(
                requestDTO.getCode(),
                requestDTO.getName(),
                requestDTO.getArea(),
                requestDTO.getTerrain());
        countryList.add(country);
    }

    //Hien thi tat ca cac quoc gia
    public List<CountryResponseDTO> getAll() {
        List<CountryResponseDTO> responseList = new ArrayList<>();
        for (EastAsiaCountries country : countryList) {
            responseList.add(convertToResponseDTO(country));
        }
        return responseList;
    }

    //Check trung ma quoc gia
    public boolean isDuplicate(String countryCode) {
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }

    //Tim kiem quoc gia theo ten
    public List<CountryResponseDTO> findByName(String name) {
        List<CountryResponseDTO> matchedCountries = new ArrayList<>();
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                matchedCountries.add(convertToResponseDTO(country));
            }
        }
        return matchedCountries;
    }

    //Chuyen Model sang ResponseDTO
    private CountryResponseDTO convertToResponseDTO(EastAsiaCountries country) {
        return new CountryResponseDTO(
                country.getCountryCode(),
                country.getCountryName(),
                country.getTotalArea(),
                country.getCountryTerrain());
    }

    // Check danh sach co dung 11 quoc gia hay khong
    public boolean isEnough11Countries() {
        return countryList.size() >= 11;
    }
}
