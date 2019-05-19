package application;

import entities.Fisica;
import entities.Juridica;

import java.util.UUID;

public class Program {

    public static void main(String[] args) {

        Fisica pessoaFisica = new Fisica(UUID.randomUUID(), "Victor", "12345678910", "123456789");
        Juridica pessoaJuridica = new Juridica(UUID.randomUUID(), "Empresa teste", "12345678910111", 10.0);
        Juridica empresa = new Juridica(UUID.randomUUID(), "Empresa final", "12345678910112", 100.0);

        empresa.adicionarSocio(pessoaFisica, 10.0);
        empresa.adicionarSocio(pessoaJuridica, 40.0);
    }
}