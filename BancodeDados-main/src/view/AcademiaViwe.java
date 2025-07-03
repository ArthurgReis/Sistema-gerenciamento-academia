package view;

import java.util.Scanner;

import control.PlanoController;
import model.Plano;

import java.util.ArrayList;

public class AcademiaViwe {
    private static PlanoController planoController = new PlanoController();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar Plano");
            System.out.println("2 - Atualizar Plano");
            System.out.println("3 - Listar Planos");
            System.out.println("4 - Remover Plano");

            int opc = entrada.nextInt();
            entrada.nextLine();

            switch(opc){
                case 1:
                    inserirPlano();
                    break;

                case 2:
                    alterarPlano();
                    break;

                case 3:
                    listarPlanos();
                    break;
                
                case 4:
                    removerPlano();
                    break;

                default:
                    System.out.println("Opção inválida!");


            }
            
        }
        
    }

    public static void inserirPlano(){
        System.out.println("Descrição:");
        String descricao = entrada.nextLine();
        System.out.println("Preço:");
        double preco = entrada.nextDouble();
        entrada.nextLine();
        planoController.inserirPlano(descricao, preco);
        System.out.println("Plano cadastrado com sucesso!");
    }

    public static void alterarPlano(){
        System.out.println("ID do plano:");
        int id_plano = entrada.nextInt();
        System.out.println("Novo preço:");
        double preco = entrada.nextDouble();
        entrada.nextLine();
        planoController.atualizarPlano(id_plano, preco);
    }

    public static void listarPlanos(){
        ArrayList<Plano> planos = planoController.listarPlanos();
        for(Plano plano: planos){
            System.out.println("ID: "+plano.getIdPlano()+" | Descrição: "+plano.getDescricaoPlano()+" | Preço: R$"+plano.getPrecoPlano());
        }
    }

    public static void removerPlano(){
        System.out.println("ID:");
        int id_plano = entrada.nextInt();
        entrada.nextLine();

        System.out.println(planoController.deletarPlano(id_plano));
    }


}
