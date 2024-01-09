import java.io.*;
import java.util.Scanner;

public class MainRead {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Digite o nome do arquivo : ");
        String nome = "C://Users//08419437530//IdeaProjects//aula09.01//src/" + sc.nextLine();
        FileReader fr = new FileReader(nome);
        BufferedReader br = new BufferedReader(fr);
        while(br.ready()){
            String linha = br.readLine();
            System.out.println(linha);

        }
        br.close();
        fr.close();
    }
}
