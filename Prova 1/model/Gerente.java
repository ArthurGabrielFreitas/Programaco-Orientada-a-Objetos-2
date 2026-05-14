package model;
import exception.CalculoInvalidoException;
import util.Validacao;

public class Gerente extends CargoEstrategico {
    private Departamento departamento;
    private Endereco endereco;

    public Gerente(String nome, double salarioBase, Departamento departamento, String endereco) {
        super(nome, salarioBase);
        this.departamento = departamento;
        this.endereco = new Endereco(endereco);
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public double calcularSalarioLiquido() throws CalculoInvalidoException{
        double salarioBruto, imposto, salarioLiquido;

        Validacao.validarValorPositivo(salarioBase);

        salarioBruto = salarioBase + (salarioBase * (kpiScore / 100));
        imposto = (salarioBruto > 7000) ? salarioBruto * 0.275 : (salarioBruto > 3000) ? salarioBruto * 0.15 : 0;
        salarioLiquido = salarioBruto - imposto;

        return salarioLiquido;
    }
}
