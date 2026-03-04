package service;

import client.ApiClient;
import com.google.gson.Gson;
import model.ExchangeResponse;

import java.util.Set;

public class ConversorService {

    private static final String API_KEY = "7271364fcb8499d77a7ae9ab";

    private static final String BASE_URL =
            "https://v6.exchangerate-api.com/v6/";

    private static final Set<String> MONEDAS_PERMITIDAS = Set.of(
            "ARS", "BOB", "BRL", "CLP", "COP", "USD"
    );

    private final ApiClient apiClient = new ApiClient();
    private final Gson gson = new Gson();

    public double convertir(String monedaBase,
                            String monedaDestino,
                            double monto) throws Exception {

        validarMoneda(monedaBase);
        validarMoneda(monedaDestino);

        String url = BASE_URL + API_KEY + "/latest/" + monedaBase;
        String respuesta = apiClient.realizarSolicitud(url);

        ExchangeResponse response =
                gson.fromJson(respuesta, ExchangeResponse.class);

        if (!"success".equals(response.getResult())) {
            throw new RuntimeException("Error en la respuesta de la API");
        }

        Double tasa = response.getConversionRates().get(monedaDestino);

        if (tasa == null) {
            throw new RuntimeException("Moneda destino no encontrada");
        }

        return monto * tasa;
    }

    private void validarMoneda(String moneda) {
        if (!MONEDAS_PERMITIDAS.contains(moneda)) {
            throw new IllegalArgumentException(
                    "Moneda no permitida: " + moneda);
        }
    }
}