package banco;

import java.util.Arrays;

public class CadastrarConta {

    private Conta[] contas;
    private int tamanho;

    
    public CadastrarConta(int capacidade) {
        this.contas = new Conta[capacidade];
        this.tamanho = 0;
    }

    public void adicionarCapacidade() {
        if (this.tamanho == this.contas.length) {
            Conta[] novaConta = new Conta[this.contas.length * 2];
            for (int i = 0; i < this.contas.length; i++) {
                novaConta[i] = this.contas[i];
            }
            this.contas = novaConta;
        }
    }

    public void adicionarConta(Conta conta) {
        this.adicionarCapacidade();
        if (this.tamanho < this.contas.length) {
            this.contas[tamanho] = conta;
            tamanho++;
        }
    }

    public void verificar(int posicao) throws Exception {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new Exception("posição insdisponível!\n");
        }
    }

    public void procurarConta(int posicao) throws Exception {
        this.verificar(posicao);
        System.out.println("Conta " + (posicao) + ":\nNome: " + this.contas[posicao].getNome() + "\nValor: R$ "
                + this.contas[posicao].getValor() + "\n");
    }

    public void listarConta() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println("Conta " + i + ":\nNome: " + this.contas[i].getNome() + "\nValor: R$ "
                    + this.contas[i].getValor() + "\n");
        }
    }

    public void buscarNome(String nome) {
        boolean verificar = false;
        for (int i = 0; i < this.tamanho; i++) {
            if (this.contas[i].getNome().equals(nome)) {
                verificar = true;
                System.out.println("Conta " + i + ":\nNome: " + this.contas[i].getNome() + "\nValor: R$ "
                        + this.contas[i].getValor() + "\n");
            } else if ((i + 1) == this.tamanho && verificar == false) {
                System.out.println("Conta não encontrada");
            }
        }
    }

    public void adicionarPosicaoEspecifica(int posicao, Conta conta) throws Exception {
        this.verificar(posicao);
        for (int i = this.tamanho; i >= posicao; i--) {
            this.contas[i] = this.contas[i - 1];
        }
        this.contas[posicao] = conta;
        this.tamanho++;
    }
}
