package Calculadora;

import java.util.ArrayList;

public class Calculadora {
    public static int somar(int a, int b) {
        return a + b;
    }

    public static int subtrair(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static int dividir(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }

    public static float somar(float a, float b) {
        return a + b;
    }

    public static float subtrair(float a, float b) {
        return a - b;
    }

    public static float multiplicar(float a, float b) {
        return a * b;
    }

    public static float dividir(float a, float b) throws DivisionByZeroException {
        if (b == 0.0f) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }

    public static int somar(ArrayList<Integer> numeros) {
        int resultado = 0;
        for (int numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }

    public static int multiplicar(ArrayList<Integer> numeros) {
        int resultado = 1;
        for (int numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }
}
