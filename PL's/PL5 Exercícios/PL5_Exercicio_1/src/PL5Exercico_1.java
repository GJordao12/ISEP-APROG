import java.util.Scanner;

/**
 * @author Jordão
 */
public class PL5Exercico_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        int digito, andar, n, a, digitoAnterior = 0, b = 1;

        System.out.print("Digite um número: ");
        n = tec.nextInt();

        for (a = 0; a < n; a++) {
            andar = tec.nextInt();
            digito = digito(andar);
            if (digito != digitoAnterior) {
                b++;
            }
            digitoAnterior = digito;
        }
        System.out.println(b);
    }

    public static int digito(int codigo) {
        int digito;

        digito = codigo / 10;

        return digito;
    }
}
        
