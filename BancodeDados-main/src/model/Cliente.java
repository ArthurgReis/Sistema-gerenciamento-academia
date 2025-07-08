package model;

import java.time.LocalDate;

public class Cliente extends Conta{
    private LocalDate dataCadastro;
    private String obsCliente;

    public Cliente (String nomeConta, String cpfConta, String emailConta, String telefoneConta, LocalDate data_cadastro, String obsCliente) {
        super(nomeConta, cpfConta, emailConta, telefoneConta);
        this.dataCadastro = data_cadastro;
        this.obsCliente = obsCliente;
    }
}
