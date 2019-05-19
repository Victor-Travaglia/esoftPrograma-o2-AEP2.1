package entities;

import java.util.UUID;

public class Fisica extends Pessoa {

    private String cpf;
    private String rg;

    public Fisica(UUID id, String nome, String cpf, String rg) {
        super(id, nome);

        if (cpf == null) {
            throw new RuntimeException("CPF é obrigatório");
        }

        if (cpf.length() > 11) {
            throw new RuntimeException("CPF deve possuir 11 digitos");
        }

        this.cpf = cpf;
        this.rg = rg;
    }

    public Fisica(String nome, String cpf, String rg) {
        super(nome);

        if (cpf == null) {
            throw new RuntimeException("CPF é obrigatório");
        }

        if (cpf.length() > 11) {
            throw new RuntimeException("CPF deve possuir 11 digitos");
        }

        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
}