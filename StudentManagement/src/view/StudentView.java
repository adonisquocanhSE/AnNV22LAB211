package view;

import dto.ReportResponseDTO;
import java.util.List;

// View chi co nhiem vu hien thi du lieu ra man hinh
// Khong xu ly logic nghiep vu
public class StudentView {

    // Danh sach du lieu report duoc controller truyen vao
    private List<ReportResponseDTO> reportData;

    // Setter de nhan du lieu tu controller
    public void setReportData(List<ReportResponseDTO> reportData) {
        this.reportData = reportData;
    }

    // Hien thi danh sach report theo dung format
    public void display() {
        // Duyet tung dong trong report
        for (ReportResponseDTO r : reportData) {
            // In tung dong ra man hinh
            System.out.println(r);
        }
    }
}
