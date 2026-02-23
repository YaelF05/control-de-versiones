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

    void eliminarTarea() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            System.out.println();
            return;
        }
        listarTareas();
        System.out.print("Ingresa el número de la tarea a eliminar: ");
        int numero = scanner.nextInt();
        if (numero < 1 || numero > tareas.size()) {
            System.out.println("Número inválido.");
        } else {
            String eliminada = tareas.remove(numero - 1);
            System.out.println("Tarea eliminada: " + eliminada);
        }
        System.out.println();
    }

}