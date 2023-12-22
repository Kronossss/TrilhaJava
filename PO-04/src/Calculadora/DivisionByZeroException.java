package Calculadora;

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        super("Divisão por zero não permitida.");
    }
}
