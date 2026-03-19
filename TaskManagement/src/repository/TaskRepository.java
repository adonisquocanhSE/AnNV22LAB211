package repository;

import constants.Message;
import constants.TaskType;
import dto.TaskRequestDTO;
import dto.TaskResponseDTO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Task;

public class TaskRepository {

    //Danh sach luu tru cac task trong bo nho
    private List<Task> taskList;
    //Bien luu id cuoi cung de tu dong tang
    private int lastId;

    //khoi tao taskList va lastId
    public TaskRepository() {
        taskList = new ArrayList<>();
        lastId = 0;
    }

    //Them task
    public int addTask(TaskRequestDTO dto) {
        //Tao doi tuong task tu dto
        Task task = new Task(
                ++lastId,
                dto.getTaskTypeId(),
                dto.getRequirementName(),
                dto.getDate(),
                dto.getFrom(),
                dto.getTo(),
                dto.getAssignee(),
                dto.getReviewer()
        );
        //Them task vao danh sach
        taskList.add(task);
        //Tra ve id vua tao
        return lastId;
    }

    //Tim task bang Id
    private Task findTaskById(int taskId) throws Exception {
        //Duyet tung Task trong danh sach
        for (Task t : taskList) {
            //Neu id trung nhau thi tra ve task
            if (t.getId() == taskId) {
                return t;
            }
        }
        throw new Exception(Message.TASK_NOT_EXIST);
    }

    //Xoa task
    public void deleteTask(int taskId) throws Exception {
        Task task = findTaskById(taskId);
        taskList.remove(task);
    }

    //chuyen sang ResponseDTO
    private TaskResponseDTO convertToResponseDTO(Task t) {
        //Lay enum TaskType tu id loai task
        TaskType type = TaskType.fromId(t.getTaskTypeId());
        //Gop gio bat dau va ket thuc thanh chuoi time
        String time = t.getFrom() + " - " + t.getTo();
        //Tao va tra ve doi tuong ResponseDTO
        return new TaskResponseDTO(
                t.getId(),
                t.getRequirementName(),
                type.getName(),
                t.getDate(),
                time,
                t.getAssignee(),
                t.getReviewer()
        );
    }

    //Lay du lieu task
    public List<TaskResponseDTO> getDataTasks() {
        //Tao danh sach ket qua
        List<TaskResponseDTO> result = new ArrayList<>();

        // Sap xep task theo ID tang dan
        taskList.sort(Comparator.comparing(Task::getId));
        //Chuyen tung task sang ResponseDTO
        for (Task t : taskList) {
            result.add(convertToResponseDTO(t));
        }

        return result;
    }
}
