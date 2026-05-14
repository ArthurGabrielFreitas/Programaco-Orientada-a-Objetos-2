package util;
import exception.CalculoInvalidoException;

public class Validacao {
    public static boolean validarCpf(String cpf){
        boolean valido;
        valido = cpf.matches("([0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2})");
        return valido;
    }

    public static void validarValorPositivo(double valor) throws CalculoInvalidoException{
        if (valor < 0) {
            throw new CalculoInvalidoException("Valor negativo inválido: " + valor);
        }
    }
}
