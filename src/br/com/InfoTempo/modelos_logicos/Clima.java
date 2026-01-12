package br.com.InfoTempo.modelos_logicos;

public record Clima(String temperatura, String sensacaoTermica, String pressao, String humidade) {

    @Override
    public String toString() {
        return  "Clima - " +
                "(Temperatura: " + temperatura + "°" +
                ", Sensação termica: " + sensacaoTermica + "°" +
                ", " + "Pressão: " + pressao + "atm" +
                ", " + "Humidade: " + humidade + "%" + ")";
    }
}
