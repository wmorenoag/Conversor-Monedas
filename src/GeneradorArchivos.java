import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorArchivos {
    public void guardarJson(List<String> lista) {
        try {
            FileWriter fileWriter = new FileWriter("HistorialDeConsultas.txt");
            for (String resultado : lista) {
                fileWriter.write(resultado);
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Historial de consultas guardado");
        } catch (IOException e){
            System.out.println("Error al guardar el historial de consultas: " + e.getMessage());
        }
    }
}
