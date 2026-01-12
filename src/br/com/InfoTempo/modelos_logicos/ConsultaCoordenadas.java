package br.com.InfoTempo.modelos_logicos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCoordenadas {

    public Endereco buscaCoordenada(String localidade) {
        URI endereco = URI.create(
                "https://api.positionstack.com/v1/forward?access_key=985ded97e5f86a26028b3e8cd9070463&query="
                        + localidade.replace(" ", "+")
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            JsonArray dataArray = jsonObject.getAsJsonArray("data");

            if (dataArray == null || dataArray.isEmpty()) {
                throw new RuntimeException("Nenhum resultado encontrado para a localidade informada.");
            }

            JsonObject primeiroResultado = dataArray.get(0).getAsJsonObject();

            String latitude = primeiroResultado.get("latitude").getAsString();
            String longitude = primeiroResultado.get("longitude").getAsString();

            return new Endereco(latitude, longitude);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível localizar o clima da sua região, tente escrever novamente");
        }
    }


}
