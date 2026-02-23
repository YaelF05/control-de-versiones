import java.util.ArrayList;
import java.util.Scanner;

public class Actividades {

    private ArrayList<String> tareas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    void agregarTarea() {
        System.out.print("Escribe la nueva tarea: ");
        String tarea = scanner.nextLine();
        while (tarea.isEmpty()) {
            System.out.println("La tarea no puede estar vacía.");
            System.out.print("Escribe la nueva tarea: ");
            tarea = scanner.nextLine();
        }
        tareas.add(tarea);
        System.out.println("Tarea agregada: " + tarea);
        System.out.println();
    }

    void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
        } else {
            System.out.println("\nLista de tareas");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
        System.out.println();
    }

}