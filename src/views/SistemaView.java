package views;

import java.util.Scanner;
import controllers.FilaController;

public class SistemaView {
    private Scanner leitor = new Scanner(System.in);
    private FilaController controller = new FilaController();

    public void exibirMenuPrincipal(){
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
                controller.processarEntradaFila();
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
                    System.out.println("Chamando proximo paciente...");
                    break;
                case 2:
                    System.out.println("Iniciando atendimento...");
                    break;
                case 3:
                    System.out.println("Finalizando atendimento...");
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
                    System.out.println("Cadastrando unidade...");
                    break;
                case 2:
                    System.out.println("Gerenciando tipos...");
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
        System.out.println("Aguardando geracao de senha...");
    }

    public void visualizarHistoricoView(){
        System.out.println("Carregando historico de atendimentos...");
    }

    public void exibirRelatorios() {
        System.out.println("Gerando relatorios...");
    }
}