package model;

import exception.CalculoInvalidoException;
import util.Validacao;

public class Desenvolvedor extends Operacional {

    public Desenvolvedor(String nome, double salarioBase) {
        super(nome, salarioBase);
    }
    
    @Override
    public double calcularSalarioLiquido() throws CalculoInvalidoException {
        double salarioLiquido;
        
        Validacao.validarValorPositivo(salarioBase);

        salarioLiquido = salarioBase * 1.05 * 0.89;

        return salarioLiquido;
    }
}
