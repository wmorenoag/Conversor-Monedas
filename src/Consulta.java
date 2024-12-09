import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public String buscaConversion(String monedaOrigen, String monedaObjetivo, double cantidad) {
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1465ac21f187863671909fba/pair/"+
                    monedaOrigen +"/"+ monedaObjetivo +"/"+ cantidad);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return jsonObject.get("conversion_result").getAsString();
        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println("Se ha producido un error: ");
            throw new RuntimeException("Error" + e.getMessage());
        }
    }
}
