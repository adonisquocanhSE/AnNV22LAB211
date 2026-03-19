package controller;

import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.util.List;
import repository.TaskRepository;
import view.TaskView;

public class TaskController {

    private TaskRepository taskRepository;
    private TaskView taskView;

    //Khoi tao repository va view
    public TaskController() {
        taskRepository = new TaskRepository();
        taskView = new TaskView();
    }

    // Them task
    public void addTask(TaskRequestDTO dto) {
        taskRepository.addTask(dto);
    }

    // Xoa task (NHAN ID DA HOP LE)
    public void deleteTask(int taskId) throws Exception {
        taskRepository.deleteTask(taskId);
    }

    // Hien thi danh sach task
    public void displayTasks() {
        List<TaskResponseDTO> data = taskRepository.getDataTasks();
        taskView.setData(data);
        taskView.display();
    }
}
