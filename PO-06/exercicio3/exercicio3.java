//package PO-06.exercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class exercicio3 {
    public static void main(String[] args) {
        String nomeArquivoOrigem = "origem.txt";
        String nomeArquivoDestino = "destino.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivoOrigem));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivoDestino))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha);
                escritor.newLine();
            }

            System.out.println("Conteúdo copiado de 'origem.txt' para 'destino.txt'.");

        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}


