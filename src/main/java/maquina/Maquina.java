package maquina;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Maquina {
    private Fita fita;
    private HashMap<Integer,Estado> estados;
    private Estado estadoAtual;
    private char branco;
    private int estadoInicial; // novo: guardar inicial

    public Maquina(String arquivConfiguracao){
        estados = new HashMap<>();
        criarMaquina(arquivConfiguracao);
    }

    public boolean criarMaquina(String arquivConfiguracao){
        LeitorJson leitor;
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(arquivConfiguracao);
            leitor = gson.fromJson(reader, LeitorJson.class);
            reader.close();
        } catch (IOException e){
            System.out.println("Erro de Leitura da maquina: " + e.getMessage());
            return false;
        }

        // Criar estados
        for (Transicao t : leitor.getTransitions()) {
            estados.putIfAbsent(t.getFrom(), new Estado(t.getFrom()));
            estados.putIfAbsent(t.getTo(), new Estado(t.getTo()));
        }


        // Guardar estado inicial
        estadoInicial = leitor.getInitial();
        estadoAtual = estados.get(estadoInicial);

        // Definir estados finais
        for (int f : leitor.getFinall()) {
            estados.get(f).setEstadoFinal(true);
        }

        // Adicionar transições
        for (Transicao t : leitor.getTransitions()) {
            estados.get(t.getFrom()).addTansicao(t);
        }

        branco = leitor.getWhite();
        return true;
    }

    public boolean testar(String entrada){
        fita = new Fita(branco, entrada);
        estadoAtual = estados.get(estadoInicial);

        int passos = 0;
        while (!estadoAtual.isEstadoFinal()) {
            Transicao t = estadoAtual.buscarTransicao(fita.getSimboloAtual());

            if (t != null) {
                fita.fazerTransicao(t);
                estadoAtual = estados.get(t.getTo());
            } else {
                return false; // rejeita
            }

            passos++;
            /*if (passos > 999999999) { // limite de segurança
                System.out.println("Loop detectado, abortando...");
                return false;
            }
            */

        }
        return true; // aceitou
    }

    public String getFitaString() {
        return fita.toString();
    }
}
