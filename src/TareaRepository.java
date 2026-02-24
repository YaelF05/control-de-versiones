import java.util.List;

public interface TareaRepository {
    List<Tarea> cargarTareas();

    void guardarTareas(List<Tarea> tareas);
}
