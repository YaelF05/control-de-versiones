import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Actividades t = new Actividades();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
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
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 3);
    }
}