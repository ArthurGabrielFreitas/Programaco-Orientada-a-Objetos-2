package model;
import exception.CalculoInvalidoException;

public interface Remuneravel {
    double calcularSalarioLiquido() throws CalculoInvalidoException;
}
