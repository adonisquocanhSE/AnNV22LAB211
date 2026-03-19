package view;

import dto.DoctorResponseDTO;
import java.util.Map;

public class DoctorView {

    private Map<String, DoctorResponseDTO> data;

    //Setter de controller truyen du lieu vao view
    public void setData(Map<String, DoctorResponseDTO> data) {
        this.data = data;
    }

    //Hien thi thong tin Doctor
    public void display() {
        System.out.printf("%-10s%-20s%-20s%-10s\n",
                "Code", "Name", "Specialization", "Availability");

        for (DoctorResponseDTO d : data.values()) {
            System.out.println(d);
        }
    }
}
