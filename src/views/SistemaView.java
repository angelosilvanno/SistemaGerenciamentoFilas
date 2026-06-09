package views;
import java.util.Scanner;

public class SistemaView {
    private Scanner leitor = new Scanner(System.in);

    public void exibirMenuPrincipal(){
       int opcao = -1;

       while(opcao != 0){
           System.out.println("\n--- SISTEMA DE GERENCIAMENTO DE FILAS ---");
           System.out.println("1. Cidadao");
           System.out.println("2. Atendente");
           System.out.println("3. Administrador");
           System.out.println("0. Sair");
           System.out.print("Escolha uma opcao:");

           opcao = leitor.nextInt();

           switch(opcao){
               case 1:
                exibirMenuCidadao();
                break;
               case 2:
                exibirPainelAtendente();
                break;
               case 3:
                System.out.println("Acesso restito ao Adminstrador");
                break;
               case 0: 
                System.out.println("Saindo...");
                break;
               default:
                System.out.println("Opcao invalida.");
               break;
           }
       }
    }
    public void exibirMenuCidadao(){
        System.out.println("\n--- MENU CIDADAO ---");
    }
    public void exibirPainelAtendente(){
        System.out.println("\n--- PAINEL ATENDENTE ---");
    }
    public void exibirRelatorios(){
        
    }
}
