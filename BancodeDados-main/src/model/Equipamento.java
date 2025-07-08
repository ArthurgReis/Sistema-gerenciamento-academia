package model;

public class Equipamento {

    private String descricao;
    private String marca;
    private String musculoAlvo;

    public Equipamento(String descricao, String marca, String musculoAlvo) {
        this.descricao = descricao;
        this.marca = marca;
        this.musculoAlvo = musculoAlvo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMusculoAlvo() {
        return musculoAlvo;
    }

    public void setMusculoAlvo(String musculoAlvo) {
        this.musculoAlvo = musculoAlvo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
