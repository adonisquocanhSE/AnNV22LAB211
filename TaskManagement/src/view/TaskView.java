package view;

import dto.TaskResponseDTO;
import java.util.List;

public class TaskView {

    private List<TaskResponseDTO> data;

    // Nhan du lieu tu controller
    public void setData(List<TaskResponseDTO> data) {
        this.data = data;
    }

    // In danh sach task
    public void display() {
        System.out.printf(
                "%-5s%-15s%-12s%-15s%-6s%-6s%-10s%-10s\n",
                "ID", "Name", "Type", "Date", "From", "To", "Assignee", "Reviewer");

        for (TaskResponseDTO t : data) {
            System.out.println(t);
        }
    }
}
