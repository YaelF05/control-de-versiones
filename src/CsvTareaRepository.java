import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvTareaRepository implements TareaRepository {
    private final String filePath;

    public CsvTareaRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Tarea> cargarTareas() {
        List<Tarea> tareas = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return tareas;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                // Saltamos la primera línea si es el encabezado
                if (primeraLinea) {
                    primeraLinea = false;
                    if (linea.trim().equalsIgnoreCase("completada,descripcion")) {
                        continue;
                    }
                }

                // Separamos por la primera coma que encontremos en caso de que la descripción
                // tenga comas.
                String[] partes = linea.split(",", 2);
                if (partes.length == 2) {
                    boolean completada = Boolean.parseBoolean(partes[0].trim());
                    String descripcion = partes[1];
                    Tarea tarea = new Tarea(descripcion);
                    if (completada) {
                        tarea.marcarComoCompletada();
                    }
                    tareas.add(tarea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar las tareas desde el archivo CSV: " + e.getMessage());
        }
        return tareas;
    }

    @Override
    public void guardarTareas(List<Tarea> tareas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Escribimos el encabezado primero
            bw.write("completada,descripcion");
            bw.newLine();

            for (Tarea tarea : tareas) {
                // Guardamos en formato: completada,descripcion
                bw.write(tarea.isCompletada() + "," + tarea.getDescripcion());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar las tareas en el archivo CSV: " + e.getMessage());
        }
    }
}
