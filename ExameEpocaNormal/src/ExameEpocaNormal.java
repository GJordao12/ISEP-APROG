import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jordão
 */
public class ExameEpocaNormal {

    static Scanner tec = new Scanner(System.in);
    static int LUGARES = 30;
    static int FILAS = 24;
    static String FICHEIRO = "ocupacacaoSala2020-01-14.txt";

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("============================================================TEATRO SÁ DA BANDEIRA============================================================");
        int[][] lugares;
        lugares = lerOcupacaoDaSala();
        int valor = calcularBilheteira(lugares);
        System.out.println("Valor da Bilheteira = " + valor + "€");
        System.out.print("Insira a quantidade de lugares consecutivos que pretende: ");
        int qtdLugares = tec.nextInt();
        int fila = informarLugares(lugares, qtdLugares);
        if (fila == -1) {
            System.out.println("Não existem filas com essas quantidadde de lugares livres consecutivos!");
        } else {
            System.out.println("Existe essas quantidade de lugares livres consecutivos na fila " + fila + "!");
        }
        System.out.println("=============================================================================================================================================");
    }

    //lerOcupaçãoDaSala)---------------------------------------------------------------------------------------------------------------------------------------------------------
    public static int[][] lerOcupacaoDaSala() throws FileNotFoundException {
        int[][] lugares = new int[FILAS][LUGARES];
        File dados = new File(FICHEIRO);
        Scanner textoDados = new Scanner(dados);
        while (textoDados.hasNextLine()) {
            String linha = textoDados.nextLine();
            String[] aux = linha.split(";");
            int fila = Integer.parseInt(aux[0]);
            for (int i = 0; i < LUGARES; i++) {
                lugares[fila - 1][i] = Integer.parseInt(aux[i + 1]);
            }
        }
        textoDados.close();
        return lugares;
    }

    //calcularBilheteira)---------------------------------------------------------------------------------------------------------------------------------------------------------
    public static int calcularBilheteira(int[][] lugares) {

        int valor1 = 0, valor2 = 0, valor3 = 0, valorTotal;

        for (int i = 0; i < (FILAS / 3); i++) {
            for (int j = 0; j < LUGARES; j++) {
                if (lugares[i][j] == 1) {
                    valor1 = valor1 + 20;
                }
            }
        }
        for (int i = (FILAS / 3); i < ((FILAS / 3) * 2); i++) {
            for (int j = 0; j < LUGARES; j++) {
                if (lugares[i][j] == 1) {
                    valor2 = valor2 + 15;
                }
            }
        }
        for (int i = ((FILAS / 3) * 2); i < ((FILAS / 3) * 3); i++) {
            for (int j = 0; j < LUGARES; j++) {
                if (lugares[i][j] == 1) {
                    valor3 = valor3 + 10;
                }
            }
        }
        valorTotal = valor1 + valor2 + valor3;
        return valorTotal;
    }

    //informarLugares)---------------------------------------------------------------------------------------------------------------------------------------------------------
    public static int informarLugares(int[][] lugares, int qtdLugares) {

        int lugaresConsecutivos = 0, qtdFilas = FILAS - 1, fila = -1;

        while (qtdFilas >= 0 && fila == -1) {
            for (int i = 0; i < LUGARES; i++) {
                if (lugaresConsecutivos == qtdLugares) {
                    fila = qtdFilas;
                } else {
                    if (lugares[qtdFilas][i] == 0) {
                        lugaresConsecutivos++;
                    } else {
                        lugaresConsecutivos = 0;
                    }
                }
            }
            lugaresConsecutivos = 0;
            qtdFilas--;
        }
        return fila;
    }
}
