public class EmpregadoHorista extends Empregado {
    private double salarioHora, horasTrabalhadas;

    EmpregadoHorista(String nome, String sobrenome, String numeroSeguroSocial, double salarioHora,
            double horasTrabalhadas) {
        super(nome, sobrenome, numeroSeguroSocial);
        this.salarioHora = validaSalarioHora(salarioHora);
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
    }

    private double validaSalarioHora(double salarioHora) {
        return salarioHora >= 0.0 ? salarioHora : 0.0;
    }

    private double validaHorasTrabalhadas(double horasTrabalhadas) {
        return horasTrabalhadas >= 0 ? horasTrabalhadas : 0;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = validaSalarioHora(salarioHora);
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    @Override
    public double calculaPagamento() {
        if (horasTrabalhadas <= 40) {
            return salarioHora * horasTrabalhadas;
        }
        return 40 * salarioHora + (horasTrabalhadas - 40) * salarioHora * 1.5;
    }

    @Override
    public String toString() {
        return "Empregado Horista: " + String.join(" ", getNome(), getSobrenome()) + "\nNúmero do Seguro Social: "
                + getNumeroSeguroSocial() + "\nValor por Hora: $" + String.format("%.2f", salarioHora)
                + "; Horas Trabalhadas: "
                + String.format("%.2f", horasTrabalhadas);
    }
}
