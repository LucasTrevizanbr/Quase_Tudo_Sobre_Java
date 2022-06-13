package modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @EmbeddedId
    private ClienteId id;

    public Cliente(ClienteId id) {
        this.id = id;
    }

    public String getClienteNome() {
        return this.id.getNome();
    }

    public String getClienteCpf() {
        return this.id.getCpf();
    }
}
