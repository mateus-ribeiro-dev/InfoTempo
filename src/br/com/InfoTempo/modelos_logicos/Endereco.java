package br.com.InfoTempo.modelos_logicos;

public record Endereco(String latitude, String longitude) {

    @Override
    public String toString() {
        return  "Coordenadas - " +
                "(Latitude: " + latitude +
                ", Longitude: " + longitude + ")";
    }
}
