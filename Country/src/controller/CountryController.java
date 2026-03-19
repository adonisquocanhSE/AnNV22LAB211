package controller;

import constants.Message;
import dto.CountryRequestDTO;
import dto.CountryResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import repository.CountryRepository;
import view.CountryView;

public class CountryController {

    private CountryView countryView;
    private CountryRepository countryRepository;
    //Khoi tao View va Repository

    public CountryController() {
        countryView = new CountryView();
        countryRepository = new CountryRepository();
    }

    //Function 1: Them thong tin quoc gia moi
    public void addCountryInformation(CountryRequestDTO requestDTO) throws Exception {
        //Check chi duoc nhap toi da 11 quoc gia
        if (countryRepository.isEnough11Countries()) {
            throw new Exception(Message.MAX_11_COUNTRIES);
        }
        // Check duplicate code
        if (countryRepository.isDuplicate(requestDTO.getCode())) {
            throw new Exception(Message.DUPLICATE);
        }
        countryRepository.add(requestDTO);
    }

    //Function 2: Hien thi thong tin quoc gia moi duoc nhap
    public void getRecentlyEnteredInformation() throws Exception {
        List<CountryResponseDTO> allCountries = countryRepository.getAll();
        //Lay quoc gia moi nhap
        CountryResponseDTO latestCountry = allCountries.get(allCountries.size() - 1);
        //Tao danh sach tam de luu vao
        List<CountryResponseDTO> recentCountryInfo = new ArrayList<>();
        recentCountryInfo.add(latestCountry);
        //Goi den View de hien thi
        countryView.setCountryInfoList(recentCountryInfo);
        countryView.display();
    }

    //Function 3: Tim kiem thong tin quoc gia
    public void searchInformationByName(String name) throws Exception {
        List<CountryResponseDTO> matchedCountries = countryRepository.findByName(name);
        //Truyen vao View de hien thi
        countryView.setCountryInfoList(matchedCountries);
        countryView.display();
    }

    //Function 4: Sap xep cac quoc gia theo thu tu tang dan theo ten
    public void sortInformationByAscendingOrder() throws Exception {
        List<CountryResponseDTO> allCountries = countryRepository.getAll();
        //Sap xep
        allCountries.sort(Comparator.comparing(CountryResponseDTO::getCountryName));
        //Truyen vao View de hien thi
        countryView.setCountryInfoList(allCountries);
        countryView.display();
    }

    //Lay danh sach tat ca quoc gia (du lieu da duoc chuyen sang ResponseDTO)
    public List<CountryResponseDTO> getAllCountries() {
        return countryRepository.getAll();
    }

}
