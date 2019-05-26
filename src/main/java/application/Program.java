package application;

import pessoa.*;

public class Program {

    public static void main(String[] args) {

        try {
            Pessoa jose = new Fisica("José", "123", new Cpf("07323323037"));
            Pessoa maria = new Fisica("Maria", "456", new Cpf("75734654086"));
            Pessoa joao = new Fisica("João", "789", new Cpf("09002535090"));

            Juridica empresa = new Juridica("empresa", new Cnpj("33748964000171"), 50000.0);
            empresa.adicionarSocio(jose, 20.0);
            empresa.adicionarSocio(maria, 40.0);
            empresa.adicionarSocio(joao, 40.0);

            System.out.println("Sócios da Empresa.");
            empresa.mostrarSocios();
            System.out.println("Removendo o sócio José.");
            empresa.removerSocio(jose);
            empresa.mostrarSocios();
        }
        catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
