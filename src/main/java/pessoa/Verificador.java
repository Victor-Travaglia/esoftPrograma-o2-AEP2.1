package pessoa;

public class Verificador {

    public static void naoNulo(Object valor, String campo) {
        if (valor.equals(null)) {
            throw new RuntimeException("Campo " + campo + " é orbigatório.");
        }
    }

    public static void validarRg(String valor, String campo) {
        if (valor.length() > 9) {
            throw new RuntimeException("Campo " + campo + " não pode ser superior a 9.");
        }
    }

    public static void validarNome(String valor, String campo) {
        if (valor.length() < 2) {
            throw new RuntimeException("Campo " + campo + " não pode ser inferior a 2.");
        }
    }

    public static void maiorQueCem(Double valor, String campo) {
        if (valor > 100.00) {
            throw new RuntimeException("Campo " + campo + " não pode ser superior a 100%.");
        }
    }

    public static void menorQueZero(Double valor, String campo) {
        if (valor < 0.00) {
            throw new RuntimeException("Campo " + campo + " não pode ser inferior a 0");
        }
    }
}
