package com.controleacademico.controleacademico.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeitorDeArquivo {

    public static String lerArquivoPeloNome(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();

        try {
            // Obtém o caminho do arquivo a partir do diretório atual
            URL resource = LeitorDeArquivo.class.getClassLoader().getResource(nomeArquivo);
            if (resource != null) {
                Path path = Paths.get(resource.toURI());

                try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        conteudo.append(linha).append("\n");
                    }
                }
            } else {
                System.out.println("Arquivo não encontrado: " + nomeArquivo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conteudo.toString();
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String nomeDoArquivo = "leitura.txt";
        String conteudoDoArquivo = lerArquivoPeloNome(nomeDoArquivo);

        System.out.println("Conteúdo do arquivo:\n" + conteudoDoArquivo);
    }
}
