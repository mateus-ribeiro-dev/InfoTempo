package br.com.InfoTempo.modelos_logicos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaClima {

    public static Clima buscaClima(String latitude, String longitude){
        URI clima = URI.create("https://api.openweathermap.org/data/2.5/weather?" +
                "lon=" + longitude + "&lat=" + latitude +
                "&appid=a0fdc85108714b3fd70cebc6215834fd&units=metric");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(clima)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            JsonObject mainObject = jsonObject.getAsJsonObject("main");

            if (mainObject == null) {
                throw new RuntimeException("Nenhum resultado encontrado para a localidade informada.");
            }


            String temperatura = mainObject.get("temp").getAsString();
            String sensacaoTermica = mainObject.get("feels_like").getAsString();
            String pressao = mainObject.get("pressure").getAsString();
            String humidade = mainObject.get("humidity").getAsString();

            return new Clima(temperatura, sensacaoTermica, pressao, humidade);


        } catch (Exception e) {
            throw new RuntimeException("Erro na classe ConsultaClima");
        }
    }
}
