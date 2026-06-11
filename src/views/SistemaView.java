package views;

import java.util.Scanner;
import controllers.FilaController;
import dao.DadosRepository;

public class SistemaView {
    private Scanner leitor = new Scanner(System.in);
    private FilaController controller = new FilaController();
    private DadosRepository repository = new DadosRepository();

    public void exibirMenuPrincipal(){
       repository.conectarBanco();
       int opcao = -1;

       while(opcao != 0){
           System.out.println("\n--- SISTEMA DE GERENCIAMENTO DE FILAS ---");
           System.out.println("1. Cidadao");
           System.out.println("2. Atendente");
           System.out.println("3. Administrador");
           System.out.println("0. Sair");
           System.out.print("Escolha uma opcao: ");

            try {
               opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
               System.out.println("Erro: Digite apenas numeros.");
               continue;
            }

            switch(opcao){
                case 1:
                    exibirMenuCidadao();
                    break;
                case 2:
                    exibirPainelAtendente();
                    break;
                case 3:
                    exibirPainelAdmin();
                    break;
                case 0: 
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
           }
       }
    }

    public void exibirMenuCidadao(){
        System.out.println("\n--- MENU CIDADAO ---");
        System.out.println("1. Entrar na fila");
        System.out.println("2. Ver meu Historico");
        System.out.println("3. Voltar");
        System.out.print("Escolha: ");

        try {
            int acao = Integer.parseInt(leitor.nextLine());
            if (acao == 1) {
                entrarNaFilaView();
            } else if(acao == 2) {
                visualizarHistoricoView();
            } else if(acao == 3) {
                return;
            }
        } catch (NumberFormatException e){
            System.out.println("Erro: Escolha invalida.");
        }
    }

    public void exibirPainelAtendente(){
        System.out.println("\n--- PAINEL ATENDENTE ---");
        System.out.println("1. Chamar proximo");
        System.out.println("2. Registrar Inicio de Atendimento");
        System.out.println("3. Registrar Fim de Atendimento");
        System.out.println("4. Voltar");
        System.out.print("Escolha: ");

        try {
            int acao = Integer.parseInt(leitor.nextLine());

            switch(acao){
                case 1:
                    controller.processarChamadaSenha();
                    break;
                case 2:
                    System.out.println("Status alterado: Iniciando atendimento...");
                    break;
                case 3:
                    System.out.println("Status alterado: Finalizando atendimento...");
                    break;
                case 4:
                   return;
                default:
                    System.out.println("Opcao invalida.");
                    break;           
            }
        } catch (NumberFormatException e){
            System.out.println("Erro: Digite um numero valido.");
        }
    }

    public void exibirPainelAdmin(){
        System.out.println("\n--- PAINEL ADMINISTRADOR ---");
        System.out.println("1. Cadastrar Unidade");
        System.out.println("2. Gerenciar Tipos de Atendimento");
        System.out.println("3. Gerar Relatorio Mensal");
        System.out.println("4. Voltar");
        System.out.print("Escolha: ");

        try {
            int acao = Integer.parseInt(leitor.nextLine());

            switch(acao) {
                case 1:
                    System.out.print("Nome da Unidade: ");
                    String nome = leitor.nextLine();
                    System.out.print("Endereco: ");
                    String endereco = leitor.nextLine();
                    System.out.println("Unidade " + nome  + " no endereco " + endereco +  " cadastrada com sucesso.");
                    break;
                case 2:
                    System.out.println("Lista de servicos carregada.");
                    break;
                case 3:
                    exibirRelatorios();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite um numero valido.");
        }
    }

    public void entrarNaFilaView(){
        System.out.println("\n=== Solicitacao de Senha ===");
        System.out.print("Informe seu CPF: ");
        String cpf = leitor.nextLine();
        
        controller.processarEntradaFila();
        System.out.println("Senha vinculada ao CPF: " + cpf);
    }

    public void visualizarHistoricoView(){
        System.out.println("\n=== Consulta de Historico ===");
        System.out.print("Informe o CPF para busca: ");
        String cpf = leitor.nextLine();
        
        System.out.println("Consultando registros no banco de dados para o CPF: " + cpf);
        repository.buscarDados();
    }

    public void exibirRelatorios() {
        System.out.println("\n=== Relatorio Geral de Atendimentos ===");
        repository.buscarDados();
        System.out.println("Relatório carregado com sucesso.");
    }
}