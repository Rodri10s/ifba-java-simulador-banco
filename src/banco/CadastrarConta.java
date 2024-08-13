package src.banco;

import java.util.Arrays;

public class CadastrarConta<T> {

    private T[] contas;
    private int tamanho;

    public CadastrarConta(int capacidade) {
        this.contas = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public void adicionarCapacidade() {
        if (this.tamanho == this.contas.length) {
            T[] novaConta = (T[]) new Object[this.contas.length * 2];
            for (int i = 0; i < this.contas.length; i++) {
                novaConta[i] = this.contas[i];
            }
            this.contas = novaConta;
        }
    }

    public void adicionarConta(T conta) {
        this.adicionarCapacidade();

        this.contas[tamanho] = conta;
        tamanho++;

    }

    public void verificar(int posicao) throws Exception {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new Exception("posição insdisponível!\n");
        }
    }

    public T procurarConta(int posicao) throws Exception {
        this.verificar(posicao);
        return contas[posicao];
    }

    public void buscarNome(String nome) {

    }

    public int busca(T conta) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.contas[i].equals(conta)) {
                return i;
            }
        }
        return -1;
    }

    public void adicionarPosicaoEspecifica(int posicao, T conta) throws Exception {
        this.verificar(posicao);
        for (int i = this.tamanho; i >= posicao; i--) {
            this.contas[i] = this.contas[i - 1];
        }
        this.contas[posicao] = conta;
        this.tamanho++;
    }

    public void removerPosicaoEspecifica(int posicao) throws Exception {
        this.verificar(posicao);
        for (int i = posicao; i <= this.tamanho; i++) {
            this.contas[i] = this.contas[i + 1];
        }
        this.tamanho--;
        this.contas[tamanho] = null;
    }

    public T[] listarConta() {
        return this.contas;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i <= this.tamanho - 1; i++) {
            s.append(contas[i]);
            s.append(", ");
        }

        s.append("]");

        return Arrays.toString(contas);
    }
}
