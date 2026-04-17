public class EmpregadoAssalariado extends Empregado {
    private double salarioSemanal;

    EmpregadoAssalariado(String nome, String sobrenome, String numeroSeguroSocial, double salarioSemanal) {
        super(nome, sobrenome, numeroSeguroSocial);
        this.salarioSemanal = validaSalarioSemanal(salarioSemanal);
    }

    private double validaSalarioSemanal(double salarioSemanal) {
        return salarioSemanal >= 0.0 ? salarioSemanal : 0.0;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = validaSalarioSemanal(salarioSemanal);
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    @Override
    public double calculaPagamento() {
        return salarioSemanal;
    }

    @Override
    public String toString() {
        return "Empregado Assalariado: " + String.join(" ", getNome(), getSobrenome()) + "\nNúmero do Seguro Social: "
                + getNumeroSeguroSocial() + "\nSalário Semanal: $" + String.format("%.2f", salarioSemanal);
    }
}
