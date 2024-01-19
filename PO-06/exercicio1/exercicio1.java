//package PO-06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class exercicio1 {

    public static void main(String[] args) {
        String nomeArquivo = "entrada.txt";

        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }


    
}
