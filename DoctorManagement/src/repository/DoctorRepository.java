/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import dto.DoctorRequestDTO;
import dto.DoctorResponseDTO;
import java.util.HashMap;
import java.util.Map;
import model.Doctor;

/**
 *
 * @author Phạm Quốc Anh
 */
public class DoctorRepository {

    // Gia lap database bang HashMap
    private HashMap<String, Doctor> doctorMap;

    public DoctorRepository() {
        doctorMap = new HashMap<>();
    }

    //Function 1: Them bac si
    public boolean addDoctor(DoctorRequestDTO requestDTO) throws Exception {
        //Tao doi tuong Doctor tu du lieu DTO
        Doctor doctor = new Doctor(
                requestDTO.getCode(),
                requestDTO.getName(),
                requestDTO.getSpecialization(),
                requestDTO.getAvailability()
        );
        //Luu bac si vao Database
        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }

    //Function 2: Cap nhat bac si
    public boolean updateDoctor(DoctorRequestDTO requestDTO) throws Exception {
        //Lay bac si tu database theo ma
        Doctor doctor = doctorMap.get(requestDTO.getCode());
        //Cap nhat lai thong tin bac si
        doctor.setName(requestDTO.getName());
        doctor.setSpecialization(requestDTO.getSpecialization());
        doctor.setAvailability(requestDTO.getAvailability());
        return true;
    }

    //Function 3: Xoa bac si
    public boolean deleteDoctor(DoctorRequestDTO requestDTO) throws Exception {
        //Xoa bac si theo ma
        doctorMap.remove(requestDTO.getCode());
        return true;
    }

    //Function 4: Tim kiem bac si
    public Map<String, DoctorResponseDTO> searchDoctor(String input) throws Exception {
        //HashMap luu ket qua tim kiem
        HashMap<String, DoctorResponseDTO> result = new HashMap<>();
        //Duyet tat ca bac si trong database 
        for (Doctor d : doctorMap.values()) {
            //Kiem tra dieu kien can tim
            if (d.getCode().contains(input)
                    || d.getName().contains(input)
                    || d.getSpecialization().contains(input)) {
                //Neu thoa man, chuyen sang ResponseDTO va dua vao ket qua
                result.put(d.getCode(), new DoctorResponseDTO(
                        d.getCode(),
                        d.getName(),
                        d.getSpecialization(),
                        d.getAvailability()
                )
                );
            }
        }
        return result;
    }
    // Kiem tra bac si co ton tai trong database hay khong

    public boolean isExistDoctor(String code) {
        return doctorMap.containsKey(code);
    }

    // Kiem tra trung ma bac si
    public boolean isDuplicate(String code) {
        return doctorMap.containsKey(code);
    }

    // Kiem tra database co rong hay khong
    public boolean isEmpty() {
        return doctorMap.isEmpty();
    }

}
