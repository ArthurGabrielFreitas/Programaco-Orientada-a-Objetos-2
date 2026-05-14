package model;

public abstract class Colaborador implements Remuneravel {
    protected String nome;
    protected double salarioBase;
    private static int totalColaboradores = 0;

    public Colaborador(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        totalColaboradores++;
    }

    public static int getTotalColaboradores() {
        return totalColaboradores;
    }
}
