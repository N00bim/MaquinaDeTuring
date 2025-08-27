package maquina;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Main <arquivo_maquina.json> <arquivo_entrada.in>");
            //return;
        }

        String json = args[0];
        String arquivoEntrada = args[1];

        // Nome do arquivo de saída
        File entradaFile = new File(arquivoEntrada);
        String nomeSaida = "saida" + entradaFile.getName().replaceAll("\\..*$", "") + ".txt";

        Maquina maquina = new Maquina(json);

        try (Scanner scEntrada = new Scanner(entradaFile);
             BufferedWriter bw = new BufferedWriter(new FileWriter(nomeSaida))) {

            while (scEntrada.hasNextLine()) {
                String palavra = scEntrada.nextLine().trim();
                if (palavra.isEmpty()) continue;

                boolean aceita = maquina.testar(palavra);

                // Escrever a fita final no arquivo
                bw.write("Entrada: " + palavra + "\n");
                bw.write("Fita final: " + maquina.getFitaString() + "\n\n");

                // Imprimir no console 1 ou 0
                System.out.println(aceita ? 1 : 0);
            }

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}
