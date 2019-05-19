package entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Juridica extends Pessoa {

    private String cnpj;
    private double capitalSocial;
    private Set<CotaSociedade> socios = new HashSet();

    public Juridica(UUID id, String nome, String cnpj, Double capitalSocial) {
        super(id, nome);
        if (cnpj == null) {
            throw new RuntimeException("CNPJ é obrigatório");
        }

        if (cnpj.length() > 14) {
            throw new RuntimeException("CNPJ deve possuir 14 digitos");
        }
        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public Juridica(String nome, String cnpj, Double capitalSocial) {
        super(nome);
        this.cnpj = cnpj;
        this.capitalSocial = capitalSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Double getCapitalSocial() {
        return capitalSocial;
    }

    public Set<CotaSociedade> getSocios() {
        return socios;
    }

    public void adicionarSocio(Pessoa socio, Double percentualDeParticipacao){
        socios.add(new CotaSociedade(socio, percentualDeParticipacao));
    }

    public void removerSocio(Pessoa socio){
        for(CotaSociedade pessoa : socios){
            if (socio == pessoa.socio) {
                socios.remove(socio);
            }
        }
    }

    private class CotaSociedade {
        private Pessoa socio;
        private Double percentualDeParticipacao;

        public CotaSociedade(Pessoa socio, Double percentualDeParticipacao) {
            this.socio = socio;
            this.percentualDeParticipacao = percentualDeParticipacao;
        }

        public Pessoa getSocio() {
            return socio;
        }

        public Double getPercentualDeParticipacao() {
            return percentualDeParticipacao;
        }
    }
}