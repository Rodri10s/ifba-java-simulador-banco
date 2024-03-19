package banco;

public class Main {
    public static void main(String[] args) throws Exception {

        Conta conta1 = new Conta();
        conta1.setNome("Ramon");
        conta1.setValor(35.00);

        Conta conta2 = new Conta();
        conta2.setNome("Ramon2");
        conta2.setValor(350.00);

        Conta conta3 = new Conta();
        conta3.setNome("Ramon3");
        conta3.setValor(3500.00);

        Conta conta4 = new Conta();
        conta4.setNome("Ramon4");
        conta4.setValor(35000.00);

        CadastrarConta cadastro = new CadastrarConta(3);

        cadastro.adicionarConta(conta1);
        cadastro.adicionarConta(conta2);
        cadastro.adicionarConta(conta3);
        cadastro.adicionarConta(conta4);

        // cadastro.procurarConta(2); //Procurar conta através da posição do vetor

         cadastro.buscarNome("Ramon4"); //Procurar conta através do atributo "Nome"

        // Conta conta5 = new Conta();
        // conta5.setNome("Teste De Posiçao");
        // conta5.setValor(111111);

        // cadastro.adicionarPosicaoEspecifica(2, conta5); //Adicionar conta em posição
        // específica

        // cadastro.listarConta();//Método de imprimir todas as contas na lista
    }
}
