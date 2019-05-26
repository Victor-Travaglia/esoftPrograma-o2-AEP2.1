package pessoa;

public class Cnpj {

    private String cnpj;

    public Cnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public static void validarCnpj(String CNPJ) {
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
                CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
                CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
                CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
                CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
                (CNPJ.length() != 14)) {
            throw new RuntimeException("CNPJ inválido!");
        }
        else {
            char dig13, dig14;
            int sm, i, r, num, peso;

            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {

                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            }
            else {
                dig13 = (char) ((11 - r) + 48);
            }
            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            }
            else {
                dig14 = (char) ((11 - r) + 48);
            }

            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {

            }
            else {
                throw new RuntimeException("CNPJ inválido!");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cnpj)) return false;

        Cnpj cnpj1 = (Cnpj) o;

        return cnpj != null ? cnpj.equals(cnpj1.cnpj) : cnpj1.cnpj == null;

    }

    @Override
    public int hashCode() {
        return cnpj != null ? cnpj.hashCode() : 0;
    }
}

