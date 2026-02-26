package arthurMorais_TipoGenerico.model;

public class Vetor<T>{
    private T [] vetor;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Vetor(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = (T[]) new Object[tamanho];
    }

    public T get(int indice) {
        if (indice >= 0 && indice < tamanho) {
            return vetor[indice];
        }
        throw new IndexOutOfBoundsException("Índice fora dos limites do vetor.");
    }

    public void set(int indice, T valor) {
        if (indice >= 0 && indice < tamanho) {
            vetor[indice] = valor;
        } else {
            throw new IndexOutOfBoundsException("Índice fora dos limites do vetor.");
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}