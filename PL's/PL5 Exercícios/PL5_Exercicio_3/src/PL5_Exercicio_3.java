import java.util.Scanner;

/**
 * @author Jordão
 */
public class PL5_Exercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        int num, decimal, digito, a = 0, b;

        num = tec.nextInt();

        while (a != 0) {
            a = num(num);
        }
    }

    public static int num(int decimal) {

        int b = 0, c = 0, digito, a = 0;
        if (decimal > 0) {
            while (decimal != 0) {
                digito = decimal % 10;
                b++;
                if (digito != 9 && digito != 8) {
                    c++;
                }
                decimal = decimal / 10;
            }
            if (b != c) {
                a++;
            }
        }
    }
}
    

