import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TareaRepository repository = new CsvTareaRepository("tareas.csv");
        Actividades t = new Actividades(repository);
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Marcar tarea completada");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    t.agregarTarea();
                    break;
                case 2:
                    t.listarTareas();
                    break;
                case 3:
                    t.eliminarTarea();
                    break;
                case 4:
                    t.marcarCompletada();
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}