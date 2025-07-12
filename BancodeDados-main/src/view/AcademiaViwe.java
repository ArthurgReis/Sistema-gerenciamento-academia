package view;

import control.ClienteController;
import control.FuncionarioController;
import control.MatriculaController;
import control.PlanoController;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Cliente;
import model.Funcionario;
import model.Matricula;
import model.Plano;

public class AcademiaViwe {
    private static PlanoController planoController = new PlanoController();
    private static ClienteController clienteController = new ClienteController();
    private static FuncionarioController funcionarioController = new FuncionarioController();
    private static MatriculaController matriculaController = new MatriculaController();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    public static void exibirMenuPrincipal() {
        while (true) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Gerenciar Planos");
            System.out.println("2 - Gerenciar Clientes");
            System.out.println("3 - Gerenciar Funcionários");
            System.out.println("4 - Gerenciar Matrículas");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma área: ");

            int opc = -1;
            try {
                opc = entrada.nextInt();
                entrada.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                continue;
            }

            switch (opc) {
                case 1:
                    menuPlanos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    menuFuncionarios();
                    break;
                case 4:
                    menuMatriculas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuPlanos() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("\n--- Gerenciar Planos ---");
            System.out.println("1 - Cadastrar Plano");
            System.out.println("2 - Atualizar Plano");
            System.out.println("3 - Listar Planos");
            System.out.println("4 - Remover Plano");
            System.out.println("5 - Buscar Plano");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opc = entrada.nextInt();
                entrada.nextLine();

                switch (opc) {
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
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                entrada.nextLine();
            }
        }
    }

    private static void menuClientes() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("\n--- Gerenciar Clientes ---");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Atualizar conta");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opc = entrada.nextInt();
                entrada.nextLine();

                switch (opc) {
                    case 1:
                        adicionarCliente();
                        break;
                    case 2:
                        listarClientes();
                        break;
                    case 3:
                        buscarCliente();
                        break;
                    case 4:
                        atualizarConta();
                        break;
                    case 0:
                        break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                entrada.nextLine();
            }
        }
    }

    private static void menuFuncionarios() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("\n--- Gerenciar Funcionários ---");
            System.out.println("1 - Adicionar funcionário");
            System.out.println("2 - Listar Funcionarios");
            System.out.println("3 - Buscar funcionário");
            System.out.println("4 - Atualizar funcionário");
            System.out.println("5 - Deletar funcionário");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opc = entrada.nextInt();
                entrada.nextLine();

                switch (opc) {
                    case 1:
                        adcionarFuncionario();
                        break;
                    case 2:
                        listartFuncionarios();
                        break;
                    case 3:
                        buscarFuncionario();
                        break;
                    case 4:
                        atualizarFuncionario();
                        break;
                    case 5:
                        deletarFuncionario();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                entrada.nextLine();
            }
        }
    }

    private static void menuMatriculas() {
        int opc = -1;
        while (opc != 0) {
            System.out.println("\n--- Gerenciar Matrículas ---");
            System.out.println("1 - Matricular cliente");
            System.out.println("2 - Desativar matrícula");
            System.out.println("3 - Pagamento matrícula");
            System.out.println("4 - Listar Matrículas Ativas");
            System.out.println("5 - Listar Matrículas de um Cliente");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opc = entrada.nextInt();
                entrada.nextLine();

                switch (opc) {
                    case 1:
                        matricularCliente();
                        break;
                    case 2:
                        desativarMatricula();
                            break;
                    case 3:
                        pagamentoMatricula();
                            break;
                    case 4:
                        listarMatriculasAtivas();
                            break;
                    case 5:
                        listarMatriculasCliente();
                            break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                entrada.nextLine();
            }
        }
    }

    public static void inserirPlano() {
        System.out.println("Descrição:");
        String descricao = entrada.nextLine();
        System.out.println("Preço:");
        double preco = entrada.nextDouble();
        entrada.nextLine();
        planoController.inserirPlano(descricao, preco);
    }

    public static void alterarPlano() {
        System.out.println("ID do plano:");
        int id_plano = entrada.nextInt();
        System.out.println("Novo preço:");
        double preco = entrada.nextDouble();
        entrada.nextLine();
        planoController.atualizarPlano(id_plano, preco);
    }

    public static void listarPlanos() {
        ArrayList<Plano> planos = planoController.listarPlanos();
        for (Plano plano : planos) {
            System.out.println("ID: " + plano.getIdPlano() + " | Descrição: " + plano.getDescricaoPlano() + " | Preço: R$" + plano.getPrecoPlano());
        }
    }

    public static void removerPlano() {
        System.out.println("ID:");
        int id_plano = entrada.nextInt();
        entrada.nextLine();
        System.out.println(planoController.deletarPlano(id_plano));
    }

    public static void buscarPlano() {
        System.out.println("ID: ");
        int idPlano = entrada.nextInt();
        entrada.nextLine();
        Plano plano = planoController.buscarPlano(idPlano);
        System.out.println("ID: " + plano.getIdPlano() + " | Descrição: " + plano.getDescricaoPlano() + " | Preço: R$" + plano.getPrecoPlano());
    }

    public static void adicionarCliente() {
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
                System.out.println(clienteController.cadastrarContaCliente(nome, cpf, email, telefone, obs));
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void listarClientes() {
        ArrayList<Cliente> clientes = clienteController.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId_cliente() + " | Nome: " + cliente.getNomeConta() + " | CPF: " + cliente.getCpfConta() + " | E-mail: " + cliente.getEmailConta() + " | Telefone: " + cliente.getTelefoneConta() + " | Observação: " + cliente.getObsCliente() + " | Data de cadastro: " + cliente.getDataCadastro());
        }
    }

    public static void buscarCliente() {
        System.out.println("Digite o cpf do cliente");
        String cpf = entrada.nextLine();
        Cliente cliente = clienteController.buscarCliente(cpf);
        System.out.println("ID: " + cliente.getId_cliente() + " | Nome: " + cliente.getNomeConta() + " | CPF: " + cliente.getCpfConta() + " | E-mail: " + cliente.getEmailConta() + " | Telefone: " + cliente.getTelefoneConta() + " | Observação: " + cliente.getObsCliente() + " | Data de cadastro: " + cliente.getDataCadastro());
    }

    public static void atualizarConta() {
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

    public static void adcionarFuncionario() {
        String cpf, funcao;
        double salario;
        System.out.println("O funcionario já possui conta cadastrada?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opc = entrada.nextInt();
        entrada.nextLine();
        switch (opc) {
            case 1:
                System.out.println("Digite o cpf da conta:");
                cpf = entrada.nextLine();
                System.out.println("Cargo: ");
                funcao = entrada.nextLine();
                System.out.println("Salário:");
                salario = entrada.nextDouble();
                entrada.nextLine();
                System.out.println(funcionarioController.cadastrarFuncionario(cpf, funcao, salario));
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
                System.out.println("Cargo: ");
                funcao = entrada.nextLine();
                System.out.println("Salário:");
                salario = entrada.nextDouble();
                entrada.nextLine();
                System.out.println(funcionarioController.cadastrarContaFuncionario(nome, cpf, telefone, email, funcao, salario));
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void listartFuncionarios() {
        ArrayList<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId_funcionario() + " | Nome: " + funcionario.getNomeConta() + " | CPF: " + funcionario.getCpfConta() + " | E-mail: " + funcionario.getEmailConta() + " | Telefone: " + funcionario.getTelefoneConta() + " | Cargo: " + funcionario.getFuncao() + " | Salário: " + funcionario.getSalario());
        }
    }

    public static void buscarFuncionario() {
        System.out.println("Digite o cpf do funcionario");
        String cpf = entrada.nextLine();
        Funcionario funcionario = funcionarioController.buscarFuncionario(cpf);
        System.out.println("ID: " + funcionario.getId_funcionario() + " | Nome: " + funcionario.getNomeConta() + " | CPF: " + funcionario.getCpfConta() + " | E-mail: " + funcionario.getEmailConta() + " | Telefone: " + funcionario.getTelefoneConta() + " | Cargo: " + funcionario.getFuncao() + " | Salário: " + funcionario.getSalario());
    }

    public static void deletarFuncionario() {
        System.out.println("Digite o cpf do funcionario que deseja excluir:");
        String cpf = entrada.nextLine();
        System.out.println(funcionarioController.deletarFuncionario(cpf));
    }

    public static void atualizarFuncionario() {
        System.out.println("Digite o cpf da conta:");
        String cpf = entrada.nextLine();
        System.out.println("Digite a nova função:");
        String funcao = entrada.nextLine();
        System.out.println("Digite o novo salário:");
        double salario = entrada.nextDouble();
        entrada.nextLine();
        System.out.println(funcionarioController.atualizarFuncionario(cpf, funcao, salario));
    }

    public static void matricularCliente() {
        System.out.println("Digite o CPF do cliente:");
        String cpf = entrada.nextLine();
        System.out.println("Digite o ID do plano:");
        int idPlano = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite a duração em meses:");
        int meses = entrada.nextInt();
        System.out.println(matriculaController.matricularCliente(cpf, idPlano, meses));
    }

    public static void desativarMatricula() {
        System.out.println("Digite o CPF do cliente:");
        String cpf = entrada.nextLine();
        System.out.println(matriculaController.desativarMatricula(cpf));
    }

    public static void pagamentoMatricula() {
        System.out.println("Digite o CPF do cliente:");
        String cpf = entrada.nextLine();
        System.out.println(matriculaController.pagamentoMatricula(cpf));
    }

    public static ArrayList<Matricula> listarMatriculasAtivas() {
        return matriculaController.listarMatriculasAtivas();
    }

    public static ArrayList<Matricula> listarMatriculasCliente() {
        System.out.println("Digite o CPF do cliente:");
        String cpf = entrada.nextLine();
        return matriculaController.listarMatriculasCliente(cpf);
    }
}
