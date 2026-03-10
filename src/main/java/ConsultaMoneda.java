
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultaMoneda {

    private HttpClient client = HttpClient.newHttpClient();
    public HttpRequest crearSolicitud(String apiKey) {

        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        return request;
    }

    public String obtenerDatos(String apiKey) {

        try {

            HttpRequest request = crearSolicitud(apiKey);

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la información de la API");
        }
    }

    public RespuestaMoneda convertirDatos(String json) {

        Gson gson = new Gson();

        return gson.fromJson(json, RespuestaMoneda.class);

    }

    public double obtenerTasa(RespuestaMoneda datos, String moneda) {

        if (!datos.conversion_rates.containsKey(moneda)) {
            System.out.println("Moneda no encontrada. Intenta con otro código.");
            return -1;
        }

        return datos.conversion_rates.get(moneda);

    }

    public double convertirMoneda(double cantidad, double tasa) {
        return cantidad * tasa;
    }

}
