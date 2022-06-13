package modelo;

import javax.persistence.Embeddable;

@Embeddable
public class ClienteId {

    private String nome;

    private String cpf;

    public ClienteId(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public ClienteId() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
