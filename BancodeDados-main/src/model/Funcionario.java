package model;

public class Funcionario extends Conta{
    private int id_funcionario;
    private int id_funcao;
    private float adcSalario;
    public Funcionario ( int id_funcionario, String nomeConta, String cpfConta, String emailConta, String telefoneConta, int idFuncao, float adcSalario) {
        super(nomeConta, cpfConta, emailConta, telefoneConta);
        this.id_funcionario = id_funcionario;
        this.id_funcao = idFuncao;
        this.adcSalario = adcSalario;
    }


    public void setId_funcao(int id_funcao) {
        this.id_funcao = id_funcao;
    }

    public float getAdcSalario() {
        return adcSalario;
    }

    public void setAdcSalario(float adcSalario) {
        this.adcSalario = adcSalario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getId_funcao() {
        return id_funcao;
    }

    
}
