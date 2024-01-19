import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter escritor = new BufferedWriter(new FileWriter("saida.txt"))) {

            System.out.println("Digite as linhas de texto (digite 'exit' para encerrar):");

            String linha;
            while (!(linha = scanner.nextLine()).equalsIgnoreCase("exit")) {
                escritor.write(linha);
                escritor.newLine();
            }

            System.out.println("As linhas foram gravadas no arquivo 'saida.txt'.");

        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }
}
