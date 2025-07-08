package model;

public class Funcionario extends Conta{
    private int idConta;
    private int idFuncao;
    private float adcSalario;
    public Funcionario (String nomeConta, String cpfConta, String emailConta, String telefoneConta, int idConta, int idFuncao, float adcSalario) {
        super(nomeConta, cpfConta, emailConta, telefoneConta);
        this.idConta = idConta;
        this.idFuncao = idFuncao;
        this.adcSalario = adcSalario;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public int getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }
}
