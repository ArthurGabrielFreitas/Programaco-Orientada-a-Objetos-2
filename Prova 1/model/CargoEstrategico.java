package model;

public abstract class CargoEstrategico extends Colaborador implements Avaliavel {
    protected double kpiScore;

    public CargoEstrategico(String nome, double salarioBase) {
        super(nome, salarioBase);
        this.kpiScore = 0;
    }

    @Override
    public void registrarKpi(double score){
        kpiScore = score;
    }
}
