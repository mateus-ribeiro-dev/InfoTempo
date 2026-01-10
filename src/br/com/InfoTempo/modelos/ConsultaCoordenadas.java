package br.com.InfoTempo.modelos;

import br.com.InfoTempo.principal.Endereco;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCoordenadas {

    public Endereco buscaCoordenada(String localidade){
        URI endereco = URI.create("https://api.positionstack.com/v1/forward?access_key=985ded97e5f86a26028b3e8cd9070463&query=" + localidade.replace(" ", "+"));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (Exception e){
            throw new RuntimeException("Não foi possível localizar o clima da sua região, tente escrever novamente");
        }
    }

}
