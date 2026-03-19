/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constants.Message;
import dto.DoctorRequestDTO;
import dto.DoctorResponseDTO;
import java.util.HashMap;
import java.util.Map;
import repository.DoctorRepository;
import view.DoctorView;

public class DoctorController {

    private DoctorRepository doctorRepository;
    private DoctorView doctorView;

    //Khoi tao Repository va View
    public DoctorController() {
        doctorRepository = new DoctorRepository();
        doctorView = new DoctorView();
    }

    //Function 1: Them bac si
    public void addDoctor(DoctorRequestDTO request) throws Exception {
        // Kiem tra trung ma truoc khi them
        if (doctorRepository.isDuplicate(request.getCode())) {
            throw new Exception(Message.INPUT_DUPLICATE);
        }
        doctorRepository.addDoctor(request);
    }

    //Function 2: Cap nhat bac si
    public void updateDoctor(DoctorRequestDTO request) throws Exception {
        // Kiem tra bac si co ton tai hay khong
        if (!doctorRepository.isExistDoctor(request.getCode())) {
            throw new Exception(Message.DOCTOR_NOT_AVAILABLE);
        }
        doctorRepository.updateDoctor(request);
    }

    //Function 3: Xoa bac si
    public void deleteDoctor(DoctorRequestDTO request) throws Exception {
        // Kiem tra bac si co ton tai hay khong
        if (!doctorRepository.isExistDoctor(request.getCode())) {
            throw new Exception(Message.DOCTOR_NOT_AVAILABLE);
        }
        doctorRepository.deleteDoctor(request);
    }

    //Function 4: Tim kiem bac si
    public void searchDoctor(String input) throws Exception {
        // Kiem tra database co du lieu truoc khi tim kiem
        if (doctorRepository.isEmpty()) {
            throw new Exception(Message.DATABASE_EMPTY);
        }
        Map<String, DoctorResponseDTO> result
                = doctorRepository.searchDoctor(input);

        // Truyen du lieu sang View
        doctorView.setData((HashMap<String, DoctorResponseDTO>) result);
        doctorView.display();
    }

}
