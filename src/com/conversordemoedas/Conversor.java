package com.conversordemoedas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/761c3950e269f88788a83cdf/latest/";

    // Método para obter a taxa de câmbio em tempo real
    private double obterTaxaDeCambio(String moedaBase, String moedaDestino) throws IOException, InterruptedException {
        String url = API_URL + moedaBase;

        // Configuração do cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Envia a solicitação e obtém a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == HttpURLConnection.HTTP_OK) {
            // Parse da resposta usando GSON
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            if (conversionRates.has(moedaDestino)) {
                return conversionRates.get(moedaDestino).getAsDouble(); // Extrai o valor da taxa de câmbio
            } else {
                throw new IOException("A moeda de destino não está disponível na resposta da API.");
            }
        } else {
            throw new IOException("Erro ao obter dados da API. Código: " + response.statusCode());
        }
    }

    // Método para converter valores entre moedas
    public void converter(String moedaBase, String moedaDestino, double quantidade) {
        try {
            double taxa = obterTaxaDeCambio(moedaBase, moedaDestino);
            double resultado = quantidade * taxa;
            System.out.printf("%.2f %s equivalem a %.2f %s%n", quantidade, moedaBase, resultado, moedaDestino);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro ao conectar-se à API: " + e.getMessage());
        }
    }
}
