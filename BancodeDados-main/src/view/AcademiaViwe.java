package view;

import control.ClienteController;
import control.PlanoController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;
import model.Plano;

public class AcademiaViwe {
    private static PlanoController planoController = new PlanoController();
    private static ClienteController clienteController = new ClienteController();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar Plano");
            System.out.println("2 - Atualizar Plano");
            System.out.println("3 - Listar Planos");
            System.out.println("4 - Remover Plano");
            System.out.println("5 - Buscar Plano");
            System.out.println("6 - Adicionar Cliente");
            System.out.println("7 - Listar clientes");
            System.out.println("8 - Buscar cliente");
            System.out.println("9 - Atualizar conta");
            System.out.println("10 - Remover cliente:");

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

                case 5:
                    buscarPlano();
                    break;

                case 6:
                    adicionarCliente();
                    break;

                case 7:
                    listarClientes();
                    break;

                case 8:
                    buscarCliente();
                    break;
                
                case 9:
                    atualizarConta();
                    break;

                case 10:
                    deletarCliente();
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

    public static void buscarPlano(){
        System.out.println("ID: ");
        int idPlano = entrada.nextInt();
        entrada.nextLine();

        Plano plano = planoController.buscarPlano(idPlano);
        System.out.println("ID: "+plano.getIdPlano()+" | Descrição: "+plano.getDescricaoPlano()+" | Preço: R$"+plano.getPrecoPlano());

    }

    public static void adicionarCliente(){
        String cpf, obs;
        System.out.println("O cliente já possui conta cadastrada?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opc = entrada.nextInt();
        entrada.nextLine();
        switch (opc) {
            case 1:
                System.out.println("Digite o cpf da conta:");
                cpf = entrada.nextLine();
                System.out.println("Observações: ");
                obs = entrada.nextLine();
                System.out.println(clienteController.cadastrarCliente(cpf, obs));
                break;

            case 2:
                System.out.println("Digite o nome completo:");
                String nome = entrada.nextLine();
                System.out.println("Digite o cpf:");
                cpf = entrada.nextLine();
                System.out.println("Digite o e-mail:");
                String email = entrada.nextLine();
                System.out.println("Digite o telefone:");
                String telefone = entrada.nextLine();
                System.out.println("Observações: ");
                obs = entrada.nextLine();
                System.out.println(clienteController.cadastrarContaCliente(nome,cpf,email,telefone,obs));
                break;
        
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void listarClientes(){
        ArrayList<Cliente> clientes = clienteController.listarClientes();
        for(Cliente cliente: clientes){
            System.out.println("ID: "+cliente.getId_cliente()+" | Nome: "+cliente.getNomeConta()+" | CPF: "+cliente.getCpfConta()+" | E-mail: "+cliente.getEmailConta()+" | Telefone: "+cliente.getTelefoneConta()+" | Observação: "+cliente.getObsCliente()+" | Data de cadastro: "+cliente.getDataCadastro());
        }

    }

    public static void buscarCliente(){
        System.out.println("Digite o cpf do cliente");
        String cpf = entrada.nextLine();
        Cliente cliente = clienteController.buscarCliente(cpf);
        System.out.println("ID: "+cliente.getId_cliente()+" | Nome: "+cliente.getNomeConta()+" | CPF: "+cliente.getCpfConta()+" | E-mail: "+cliente.getEmailConta()+" | Telefone: "+cliente.getTelefoneConta()+" | Observação: "+cliente.getObsCliente()+" | Data de cadastro: "+cliente.getDataCadastro());
    }

    public static void atualizarConta(){
        System.out.println("Digite o cpf da conta:");
        String cpf = entrada.nextLine();
        System.out.println("Digite o novo nome:");
        String novoNome = entrada.nextLine();
        System.out.println("Digite o novo e-mail:");
        String novoEmail = entrada.nextLine();
        System.out.println("Digite o novo telefone:");
        String novoTelefone = entrada.nextLine();
        System.out.println(clienteController.atualiarConta(cpf, novoNome, novoEmail, novoTelefone));

    }

    public static void deletarCliente(){
        System.out.println("Digite o cpf do cliente que deseja excluir:");
        String cpf = entrada.nextLine();
        System.out.println(clienteController.deletarCliente(cpf));
    }


}
