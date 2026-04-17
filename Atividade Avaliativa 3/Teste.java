public class Teste {
    public static void main(String[] args) {
        EmpregadoAssalariado empregadoAssalariado = new EmpregadoAssalariado("John", "Smith", "111-11-1111", 800.0);
        EmpregadoHorista empregadoHorista = new EmpregadoHorista("Karen", "Price", "222-22-2222", 16.75, 40.0);
        EmpregadoComissionado empregadoComissionado = new EmpregadoComissionado("Sue", "Jones", "333-33-3333", 10000.0,
                0.06);
        EmpregadoMisto empregadoMisto = new EmpregadoMisto("Bob", "Lewis", "444-44-4444", 10000.0, 0.06, 300.0);

        // Sem usar Polimorfismo
        System.out.println("Empregados Processados Individualmente:\n\n");

        System.out.println(empregadoAssalariado.toString());
        System.out.println("Total Ganho: $" + String.format("%.2f", empregadoAssalariado.calculaPagamento()));
        System.out.println();

        System.out.println(empregadoHorista.toString());
        System.out.println("Total Ganho: $" + String.format("%.2f", empregadoHorista.calculaPagamento()));
        System.out.println();

        System.out.println(empregadoComissionado.toString());
        System.out.println("Total Ganho: $" + String.format("%.2f", empregadoComissionado.calculaPagamento()));
        System.out.println();

        System.out.println(empregadoMisto.toString());
        System.out.println("Total Ganho: $" + String.format("%.2f", empregadoMisto.calculaPagamento()));
        System.out.println();

        // Usando Polimorfismo
        Empregado[] empregados = { empregadoAssalariado, empregadoHorista, empregadoComissionado, empregadoMisto };

        System.out.println("Empregados Processados Polimorficamente:\n\n");
        for (Empregado empregado : empregados) {
            System.out.println(empregado.toString());
            if (empregado instanceof EmpregadoMisto) {
                EmpregadoMisto m = (EmpregadoMisto) empregado;
                m.setSalarioBase(m.getSalarioBase() * 1.1);
                System.out.printf("Novo Salário-base com 10%% de aumento é: $%.2f%n",
                        m.getSalarioBase());
            }
            System.out.println("Total Ganho: $" + String.format("%.2f", empregado.calculaPagamento()));
            System.out.println();
        }
    }
}
