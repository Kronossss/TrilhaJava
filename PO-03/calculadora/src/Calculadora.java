import java.util.Scanner;

// Exceção personalizada para divisão por zero
class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        super("Divisão por zero não permitida.");
    }
}

// Classe Calculadora com menu
public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                exibirMenu();
                int escolha = scanner.nextInt();

                if (escolha == 0) {
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                }

                System.out.print("Digite o valor de a: ");
                int a = scanner.nextInt();

                System.out.print("Digite o valor de b: ");
                int b = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Resultado da soma: " + somar(a, b));
                        break;
                    case 2:
                        System.out.println("Resultado da subtração: " + subtrair(a, b));
                        break;
                    case 3:
                        System.out.println("Resultado da multiplicação: " + multiplicar(a, b));
                        break;
                    case 4:
                        try {
                            System.out.println("Resultado da divisão de inteiros: " + dividir(a, b));
                        } catch (DivisionByZeroException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("Resultado da divisão de floats: " + dividir((float) a, (float) b));
                        } catch (DivisionByZeroException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                        break;
                }
            }
        } finally {
            scanner.close();
        }
    }

    // Métodos de operações matemáticas
    public static int somar(int a, int b) {
        return a + b;
    }

    public static int subtrair(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static int dividir(int dividendo, int divisor) throws DivisionByZeroException {
        if (divisor == 0) {
            throw new DivisionByZeroException();
        }
        return dividendo / divisor;
    }

    public static float dividir(float dividendo, float divisor) throws DivisionByZeroException {
        if (divisor == 0.0f) {
            throw new DivisionByZeroException();
        }
        return dividendo / divisor;
    }

    // Exibir menu de escolhas
    public static void exibirMenu() {
        System.out.println("\nEscolha a operação desejada:");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão de inteiros");
        System.out.println("5. Divisão de floats");
        System.out.println("0. Sair do programa");
        System.out.print("Digite o número da opção desejada: ");
    }
}
