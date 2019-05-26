package pessoa;

import java.util.Objects;
import java.util.UUID;

public class Pessoa {

    private UUID id;
    private String nome;

    public Pessoa(String nome) {
        Verificador.naoNulo(nome, "nome");
        Verificador.validarNome(nome, "nome");
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

    public Pessoa(UUID id, String nome) {
        Verificador.naoNulo(id, "id");
        Verificador.naoNulo(nome, "nome");
        Verificador.validarNome(nome, "nome");
        this.id = id;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;

        Pessoa pessoa = (Pessoa) o;

        return Objects.equals(id, pessoa.id);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
