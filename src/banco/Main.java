package banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        CadastrarConta cadastro = new CadastrarConta(10);

        boolean repeticao = true;
        do {
            opcoes();
            int escolha = input.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Quantas Contas Deseja Gerar?");
                    int quantidade = input.nextInt();
                    gerarContas(quantidade, cadastro);
                    break;
            
                case 2:
                    System.out.println("Quantas Contas Deseja Inserir?");
                    quantidade = input.nextInt();
                    adicionarManualmente(quantidade, cadastro);
                    break;

                case 3:
                    procurarPosicao(input, cadastro);
                    break;

                case 4:
                    procurarNome(input, cadastro);
                    break;

                case 5:
                    cadastro.listarConta();
                    break;

                case 6:
                    repeticao = false;
                    System.out.println("Programa Finalizado!");
                    break;

                default:
                    System.out.println("Opção não existente!");
                    break;
            }
        } while (repeticao);
    }

    public static void gerarContas(int quantidade, CadastrarConta cadastro){
        Conta conta;
        for(int i=0; i<quantidade; i++){
            conta = new Conta();
            conta.setNome("Nome"+i);
            conta.setValor(i);
            cadastro.adicionarConta(conta);
        }
    }

    public static void adicionarManualmente(int quantidade, CadastrarConta cadastro){
        Scanner input = new Scanner(System.in);
        Conta conta;
        for(int i=0; i<quantidade; i++){
            conta = new Conta();
            System.out.println("Digite o Nome do proprietário da conta:");
            conta.setNome(input.nextLine());
            System.out.println("Digite o Valor da conta:");
            conta.setValor(input.nextDouble());
            cadastro.adicionarConta(conta);
        }
    }

    public static void opcoes(){
        System.out.println("ESCOLHA UMA OPÇÃO:");
        System.out.println("1 - Adicionar Conta Dinamicamente");
        System.out.println("2 - Adicionar Conta Manualmente");
        System.out.println("3 - Procurar Conta Por Posição");
        System.out.println("4 - Procurar Conta Pelo Nome");
        System.out.println("5 - Listar Contas");
        System.out.println("6 - Fechar Programa\n");
    }

    public static void procurarPosicao(Scanner input, CadastrarConta cadastro) throws Exception{
        System.out.println("Qual a posição deseja Procurar?\n");
        int posicao = input.nextInt();
        cadastro.procurarConta(posicao);
        }

    public static void procurarNome(Scanner input, CadastrarConta cadastro){
        System.out.println("Qual Nome deseja Procurar?\n");
        String nome = input.nextLine();
        nome = input.nextLine();
        cadastro.buscarNome(nome);
    }
}
