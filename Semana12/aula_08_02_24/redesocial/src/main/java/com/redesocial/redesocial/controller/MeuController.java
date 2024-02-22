package com.redesocial.redesocial.controller;

import com.redesocial.redesocial.rsa.RSAGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MeuController {

    private int valor;
    private int valor2;

    @RequestMapping("/valor")
    public int getValor(){
        return valor;
    }

    @RequestMapping("/valoraleatorio")
    public int getValorAleatorio(){
        valor = (int) (Math.random() * 50);
        return valor;
    }

    @RequestMapping("/valoremsequencia")
    public int getValorEmSequencia(){

        int valorAux = valor;
        valor++;

        return valorAux;
    }

    @RequestMapping("/valoremsequenciaprimo")
    public int getValorEmSequenciaPrimo() {

        int auxPrimo;

        for (int valor2 = 1; valor2 <= 100; valor2++) {

            boolean primo = true;

            for (valor = 2 ; valor < valor2 ; valor++){

                if (valor2%valor == 0){

                    primo = false;

                }

            }
            if (primo){

                System.out.println(valor2);

            }

        }
        return valor2;
    }

    @RequestMapping("/gerachavesrsa")
    public ArrayList<String> retornaChavesRsa(){
        RSAGenerator rsaGenerator = new RSAGenerator(1024);
        ArrayList<String> privatePublic = new ArrayList<>();
        String privateKey;
        String publicKey;
        privatePublic.add(privateKey = rsaGenerator.getPrivatekey().toString());
        privatePublic.add(publicKey = rsaGenerator.getPublickey().toString());

        return privatePublic;
    }
}
