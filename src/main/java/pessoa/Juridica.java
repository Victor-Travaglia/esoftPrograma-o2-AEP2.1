package pessoa;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Juridica extends Pessoa {

    private Cnpj cnpj;
    private double capitalSocial;

    Set<CotaSociedade> cotasSociedade = new HashSet<CotaSociedade>();

    public Juridica(String nome, Cnpj cnpj, double capitalSocial) {
        super(UUID.randomUUID(), nome);
        Cnpj.validarCnpj(cnpj.getCnpj());
        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public Juridica(UUID id, String nome, Cnpj cnpj, double capitalSocial) {
        super(id, nome);
        Cnpj.validarCnpj(cnpj.getCnpj());
        Verificador.naoNulo(capitalSocial, "capital social");
        Verificador.menorQueZero(capitalSocial, "capital social");
        Verificador.maiorQueCem(capitalSocial, "capital social");

        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public double getCapitalSocial() {
        return capitalSocial;
    }

    public void adicionarSocio(Pessoa socio, double percentualDeParticipacao) {
        double percentual = somarPercentualAtual() + percentualDeParticipacao;

        Verificador.naoNulo(percentualDeParticipacao, "percentual de participação");
        Verificador.maiorQueCem(percentual, "percentual de participação");
        Verificador.menorQueZero(percentualDeParticipacao, "percentual de partificapção");

        cotasSociedade.add(new CotaSociedade(socio, percentualDeParticipacao));
    }

    public void removerSocio(Pessoa socio) {
        if (cotasSociedade.isEmpty()) {
            System.out.println("Você não possui sócios.");
        }
        else {
            cotasSociedade.removeIf(pessoa -> pessoa.socio.equals(socio));
        }
    }

    // método para teste.
    public void mostrarSocios() {
        for (CotaSociedade cotaSociedade : cotasSociedade) {
            System.out.println(cotaSociedade.socio.getNome());
        }
    }

    private double somarPercentualAtual() {
        double percentualAtual = 0.00d;
        for (CotaSociedade cotaSociedade : cotasSociedade) {
            percentualAtual += cotaSociedade.percentualDeParticipacao;
        }
        return percentualAtual;
    }

    private class CotaSociedade {

        private Pessoa socio;
        private double percentualDeParticipacao;

        public CotaSociedade(Pessoa socio, double percentualDeParticipacao) {
            this.socio = socio;
            this.percentualDeParticipacao = percentualDeParticipacao;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CotaSociedade)) return false;

            CotaSociedade that = (CotaSociedade) o;

            return Objects.equals(socio, that.socio);

        }

        @Override
        public int hashCode() {
            return socio != null ? socio.hashCode() : 0;
        }
    }
}

