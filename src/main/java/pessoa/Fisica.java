package pessoa;

import java.util.UUID;

public class Fisica extends Pessoa {

    private String rg;
    private Cpf cpf;

    public Fisica(String nome, String rg, Cpf cpf) {
        super(UUID.randomUUID(), nome);
        Verificador.naoNulo(rg, "RG");
        Verificador.validarRg(rg, "RG");
        Cpf.validarCpf(cpf.getCpf());

        this.rg = rg;
        this.cpf = cpf;
    }

    public Fisica(UUID id, String nome, String rg, Cpf cpf) {
        super(id, nome);
        Verificador.naoNulo(rg, "RG");
        Verificador.validarRg(rg, "RG");
        Cpf.validarCpf(cpf.getCpf());

        this.rg = rg;
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }
}
