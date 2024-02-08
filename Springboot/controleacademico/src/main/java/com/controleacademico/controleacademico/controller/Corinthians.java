package com.controleacademico.controleacademico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Corinthians {
    @RequestMapping("/igor")
    @ResponseBody
    public String corinthians(){
        return " SATURNO";
    }
}

    @RequestMapping("/ian")
    @ResponseBody
    public ArrayList<String> oloquinho(){

        return retornaConteudoArquivo();

    }

    public ArrayList<String> retornaConteudoArquivo(){

        ArrayList<String> dado = new ArrayList<>();
        File arquivo = new File("leitura.txt");
        boolean existe = arquivo.exists();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))){

            while(br.ready()){

                dado.add(br.readLine());

            }

        } catch (IOException e){

            System.out.println("Erro: " + e.getMessage());

        }

        return dado;
    }

}
