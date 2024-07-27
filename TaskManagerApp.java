import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManagerImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Añadir Tarea");
            System.out.println("2. Modicicar Tarea");
            System.out.println("3. Remover Tarea");
            System.out.println("4. Ver Tareas Pendientes");
            System.out.println("5. Ver Tareas Completadas");
            System.out.println("6. Salir");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la tarea: ");
                    String description = scanner.nextLine();
                    Task task = new Task(taskManager.getPendingTasks().size() + 1, description);
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.print("ingrese el Id de la tarea: ");
                    int modifyId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Nueva orden: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("La tarea fue completada? (true/false): ");
                    boolean isCompleted = scanner.nextBoolean();
                    taskManager.modifyTask(modifyId, newDescription, isCompleted);
                    break;
                case 3:
                    System.out.print("Numero de la tarea a remover: ");
                    int removeId = scanner.nextInt();
                    taskManager.removeTask(removeId);
                    break;
                case 4:
                    System.out.println("Tarea pendiente:");
                    for (Task t : taskManager.getPendingTasks()) {
                        System.out.println(t);
                    }
                    break;
                case 5:
                    System.out.println("Tarea completada:");
                    for (Task t : taskManager.getCompletedTasks()) {
                        System.out.println(t);
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Codigo Invalido. vuelva a intentarlo.");
            }
        }
    }
}

