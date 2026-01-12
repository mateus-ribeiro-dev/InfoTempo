package br.com.InfoTempo.principal;

import br.com.InfoTempo.modelos_logicos.Clima;
import br.com.InfoTempo.modelos_logicos.ConsultaClima;
import br.com.InfoTempo.modelos_logicos.ConsultaCoordenadas;
import br.com.InfoTempo.modelos_logicos.Endereco;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaCoordenadas consultaCoordenadas = new ConsultaCoordenadas();

        System.out.println("Seja bem vindo ao InfoTempo");
        System.out.println("Escreva sua cidade e bairro");
        var localidade = leitura.nextLine();

        try {
            Endereco novoEndereco = consultaCoordenadas.buscaCoordenada(localidade);
            System.out.println(novoEndereco);
            Clima novoClima = ConsultaClima.buscaClima(novoEndereco.latitude(), novoEndereco.longitude());
            System.out.println(novoClima);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }

    }
}
