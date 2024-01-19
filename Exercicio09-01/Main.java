import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Digite o nome do arquivo : ");
        String nome = "C:\\Users\\igora\\Downloads\\TrilhaJava\\Exercicio09-01" + sc.nextLine();
        File arquivo = new File(nome);
        arquivo.createNewFile();

        System.out.println(" Digite uma linha para o arquivo : ");
        String linha = sc.nextLine();
        FileWriter fw = new FileWriter(nome, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(linha);

        while(!linha.isEmpty()){
            bw.newLine();
            System.out.println(" Digite uma linha para o arquivo : ");
            linha = sc.nextLine();
            bw.write(linha);

        }

        bw.close();
        fw.close();



    }
}