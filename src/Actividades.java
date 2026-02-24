import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actividades {

    private List<Tarea> tareas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarTarea() {
        System.out.print("Escribe la nueva tarea: ");
        String descripcion = scanner.nextLine();

        while (descripcion.trim().isEmpty()) {
            System.out.println("La tarea no puede estar vacía.");
            System.out.print("Escribe la nueva tarea: ");
            descripcion = scanner.nextLine();
        }

        tareas.add(new Tarea(descripcion));
        System.out.println("Tarea agregada: " + descripcion + "\n");
    }

    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas pendientes.\n");
            return;
        }

        System.out.println("\nLista de tareas:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
        System.out.println();
    }

    public void eliminarTarea() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar.\n");
            return;
        }

        listarTareas();
        System.out.print("Ingresa el número de la tarea a eliminar: ");

        try {
            int numero = Integer.parseInt(scanner.nextLine());

            if (numero < 1 || numero > tareas.size()) {
                System.out.println("Número inválido.\n");
            } else {
                Tarea eliminada = tareas.remove(numero - 1);
                System.out.println("Tarea eliminada: " + eliminada.getDescripcion() + "\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa un número válido.\n");
        }
    }

    public void marcarCompletada() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para marcar como completadas.\n");
            return;
        }

        listarTareas();
        System.out.print("Ingresa el número de la tarea a marcar como completada: ");

        try {
            int numero = Integer.parseInt(scanner.nextLine());

            if (numero < 1 || numero > tareas.size()) {
                System.out.println("Número inválido.\n");
            } else {
                Tarea tarea = tareas.get(numero - 1);
                if (tarea.isCompletada()) {
                    System.out.println("La tarea ya estaba completada.\n");
                } else {
                    tarea.marcarComoCompletada();
                    System.out.println("Tarea marcada como completada: " + tarea.getDescripcion() + "\n");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa un número válido.\n");
        }
    }
}