import java.util.List;

public interface TaskManager {
    void addTask(Task task);
    void modifyTask(int taskId, String newDescription, boolean isCompleted);
    void removeTask(int taskId);
    List<Task> getPendingTasks();
    List<Task> getCompletedTasks();
}


