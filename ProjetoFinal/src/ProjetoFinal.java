import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Jordão & António
 */
public class ProjetoFinal {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner text = new Scanner(System.in);

        File dados = new File("PracticalWork.csv");
        String[][] Grupo_Equipa = new String[32][2];
        int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao = new int[32][8];
        Scanner texto_dados = new Scanner(dados);
        int i = 0;  // o i vai servir para saber a quantidade de posições ja ocupadas no array, ou seja, número de equipas
        texto_dados.nextLine();
        while (texto_dados.hasNextLine()) {
            String linha = texto_dados.nextLine();
            String[] dados_Da_Equipa = linha.split(",");
            Grupo_Equipa[i][0] = dados_Da_Equipa[0];
            Grupo_Equipa[i][1] = dados_Da_Equipa[1];
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][0] = Integer.parseInt(dados_Da_Equipa[2]);
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][1] = Integer.parseInt(dados_Da_Equipa[3]);
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][2] = Integer.parseInt(dados_Da_Equipa[4]);
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][3] = Integer.parseInt(dados_Da_Equipa[5]);
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][4] = Integer.parseInt(dados_Da_Equipa[6]);
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][5] = Integer.parseInt(dados_Da_Equipa[7]);
            i++;
        }
        texto_dados.close();
        int opcao = 0;
        while (opcao != 99) {
            System.out.println();
            System.out.println("============================================================MENU============================================================");
            System.out.println();
            System.out.println("Bem-vindo ao Seleção3000! Escolha, através dos números, a opção que deseja!");
            System.out.println("1:  Ler a informação disponível sobre as equipas");
            System.out.println("2:  Insirir manualamente uma ou várias equipas");
            System.out.println("3:  Calcular e armazenar em memória a pontuação de todas as equipas");
            System.out.println("4:  Calcular e armazenar em memória a classificação de todas as equipas nos respetivos grupos");
            System.out.println("5:  Listar a classificação das equipas por grupo");
            System.out.println("6:  Listar as equipas com o máximo de golos marcados");
            System.out.println("7:  Listar as equipas que têm determinados golos sofridos");
            System.out.println("8:  Listar as equipas que têm mais golos sofridos que marcados");
            System.out.println("9:  Listar o primeiro classificado de cada grupo");
            System.out.println("10: Listar informação completa de uma equipa");
            System.out.println("11: Criar um ficheiro de texto (Statistics.txt) com estatísticas dos jogos");
            System.out.println("12: Remover da memória as equipas que não vão disputar a fase seguinte ");
            System.out.println("13: Criar um ficheiro de texto (FinalStage.csv) com as equipas que vão disputar a fase seguinte do campeonato");
            System.out.println("14: Criar um ficheiro de texto (FinalStageGames.txt) com os jogos da fase final");//falta
            System.out.println("99: Fechar o programa!");
            System.out.println();
            System.out.print("Insira a opção que pretende: ");
            opcao = text.nextInt();
            System.out.println();
            System.out.println("============================================================================================================================");
            System.out.println();
            switch (opcao) {
                case 1:
                    System.out.println("Informação armazenada com sucesso!");
                    break;
                case 2:
                    i = inserirEquipas(i, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                    break;
                case 3:
                    pontuacaoEquipas(Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 4:
                    classificacaoEquipas(Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, Grupo_Equipa, i);
                    break;
                case 5:
                    listarPorGrupo(Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 6:
                    listarGolosMarcados(Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 7:
                    listarGolosSofridos(Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, Grupo_Equipa, i);
                    break;
                case 8:
                    ListarMaisGolosSofridosQueMarcados(Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, Grupo_Equipa, i);
                    break;
                case 9:
                    PrimeiroLugarGrupo(Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 10:
                    InformacaoEquipa(Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 11:
                    Estatisticas(Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 12:
                    i = FaseSeguinte(Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 13:
                    FaseSeguinteFicheiro(Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    break;
                case 14:
                    JogosDaFaseFinalFicheiro(i, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                    break;
                case 99:
                    System.out.println("Fechando o programa...");
                    System.out.println();
                    System.out.println("============================================================================================================================");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente...");
                    break;
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void Armazenar(String linha, String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) {

        String[] dados_Da_Equipa = linha.split(",");
        Grupo_Equipa[i][0] = dados_Da_Equipa[0];
        Grupo_Equipa[i][1] = dados_Da_Equipa[1];
        Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][0] = Integer.parseInt(dados_Da_Equipa[2]);
        Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][1] = Integer.parseInt(dados_Da_Equipa[3]);
        Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][2] = Integer.parseInt(dados_Da_Equipa[4]);
        Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][3] = Integer.parseInt(dados_Da_Equipa[5]);
        Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][4] = Integer.parseInt(dados_Da_Equipa[6]);
        Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[i][5] = Integer.parseInt(dados_Da_Equipa[7]);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static int inserirEquipas(int i, String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao) {

        Scanner tec = new Scanner(System.in);

        if (i == 32) {
            System.out.println("Já foram inseridas todas as equipas!");
        } else {
            System.out.print("Quantos equipas pretende inserir? ");
            int num_Equipas = tec.nextInt();
            while (num_Equipas + i > 32) {
                System.out.println("O número de equipas que inserido excede o limite de equipas em " + (i + num_Equipas - 32) + "!");
                System.out.print("Insira novamente o número de equipas pretendido: ");
                num_Equipas = tec.nextInt();
            }
            tec.nextLine();
            for (int j = 0; j < num_Equipas; j++) {
                int existencia = 0; //serve para ver se a equipa já existe ou não
                System.out.println(" ");
                System.out.println("Por favor insira a informação da Seleção que deseja pela seguinte ordem:");
                System.out.println("Grupo,Equipa,Jogos,Vitorias,Empates,Derrotas,GolosMarcados,GolosSofridos");
                String info_Equipa = tec.nextLine();
                String[] dados_Da_Equipa = info_Equipa.split(",");
                String equipa_Inserida = dados_Da_Equipa[1];
                for (int aux = 0; aux < i; aux++) {
                    String Equipa = Grupo_Equipa[aux][1];
                    if (equipa_Inserida.equalsIgnoreCase(Equipa)) {
                        existencia = 1;
                        break;
                    }
                }
                if (existencia == 1) {
                    System.out.println("Equipa já inserida!");
                    j = j - 1;
                } else {
                    Armazenar(info_Equipa, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, i);
                    i++;
                    System.out.println("Equipa adicionada com sucesso!");
                }
            }
        }
        return i;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void pontuacaoEquipas(int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) {

        if (i != 32) {
            System.out.println("Ainda não foram inseridas todas as equipas! Por favor adicione as que faltam atráves da opção 2 do menu!");
        } else {
            for (int a = 0; a < i; a++) {
                Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][6] = (((Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][1]) * 3) + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][2]);
            }
            System.out.println("Pontuação das equipas calculada e armazenada com sucesso!");
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void classificacaoEquipas(int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, String[][] Grupo_Equipa, int i) {

        if (i != 32) {
            System.out.println("Ainda não foram inseridas todas as equipas! Por favor adicione as que faltam atráves da opção 2 do menu!");
        } else {
            for (int idx1 = 0; idx1 < i - 1; idx1++) {
                for (int idx2 = idx1 + 1; idx2 < i; idx2++) {
                    if (Grupo_Equipa[idx1][0].compareTo(Grupo_Equipa[idx2][0]) > 0) { //compara os Grupos
                        Ordenar(idx1, idx2, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                    } else {
                        if (Grupo_Equipa[idx1][0].compareTo(Grupo_Equipa[idx2][0]) == 0) {
                            if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][6] < Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][6]) { //compara pontos
                                Ordenar(idx1, idx2, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                            } else {
                                if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][6] == Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][6]) {
                                    if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][4] < Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][4]) { //comparar golosM
                                        Ordenar(idx1, idx2, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                                    } else {
                                        if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][4] == Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][4]) {
                                            if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][5] > Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][5]) { //comparar golosS
                                                Ordenar(idx1, idx2, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                                            } else {
                                                if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][5] == Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][5]) {
                                                    if (Grupo_Equipa[idx1][1].compareTo(Grupo_Equipa[idx2][1]) > 0) { //compara alfabeticamente
                                                        Ordenar(idx1, idx2, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            int posicao = 0;
            while (posicao < i) {
                int classificacao = 1;
                while (classificacao <= 4) {
                    Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][7] = classificacao;
                    classificacao++;
                    posicao++;
                }
            }
            System.out.println("Classificação das equipas calculada com sucesso!");
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void Ordenar(int idx1, int idx2, String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao) {
        //trocar Grupos e Equipas
        for (int colunas = 0; colunas < 2; colunas++) {
            String auxiliar = Grupo_Equipa[idx1][colunas];
            Grupo_Equipa[idx1][colunas] = Grupo_Equipa[idx2][colunas];
            Grupo_Equipa[idx2][colunas] = auxiliar;
        }
        //trocar Jogos,Vitórias,Empates,Derrotas,GolosM,GolosS,Pontos e Posição
        for (int colunas = 0; colunas < 8; colunas++) {
            int auxNota = Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][colunas];
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx1][colunas] = Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][colunas];
            Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[idx2][colunas] = auxNota;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void listarPorGrupo(String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) {

        if (i != 32) {
            System.out.println("Ainda não foram inseridas todas as equipas! Por favor adicione as que faltam atráves da opção 2 do menu!");
        } else {
            System.out.println("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD | ");
            System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
            for (int a = 0; a < i; a++) {
                Listar(a, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void listarGolosMarcados(String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) {

        int max_golos = -1;
        for (int a = 0; a < i; a++) {
            if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][4] > max_golos) {
                max_golos = Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][4];
            }
        }
        System.out.println("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD | ");
        System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
        for (int b = 0; b < i; b++) {
            if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[b][4] == max_golos) {
                Listar(b, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void listarGolosSofridos(int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, String[][] Grupo_Equipa, int i) {

        Scanner tec = new Scanner(System.in);

        System.out.print("Quer saber as equipas que sofreram quantos golos? ");
        int Golos_Sofridos = tec.nextInt();
        System.out.println();
        int qtd_Equipas = 0; //contador serve para caso não existir equipas com uma quantidade de golos sofridos inserida pelo utilizador aparecer uma mensagem de aviso
        for (int a = 0; a <= i - 1; a++) {
            if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][5] == Golos_Sofridos) {
                if (qtd_Equipas == 0) {
                    System.out.println("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD | ");
                    System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
                }
                Listar(a, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                qtd_Equipas++;
            }
        }
        if (qtd_Equipas == 0) {
            System.out.println("Não existem equipas com essa quantidade de golos sofridos!");
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void ListarMaisGolosSofridosQueMarcados(int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, String[][] Grupo_Equipa, int i) {

        String[][] aux = new String[32][2];
        int[][] aux2 = new int[32][8];
        int qtd_Equipas = 0;
        for (int a = 0; a <= i - 1; a++) {
            if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][5] > Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][4]) {
                for (int colunas = 0; colunas < 2; colunas++) {
                    aux[qtd_Equipas][colunas] = Grupo_Equipa[a][colunas];
                }
                for (int colunas = 0; colunas < 8; colunas++) {
                    aux2[qtd_Equipas][colunas] = Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][colunas];
                }
                qtd_Equipas++;
            }
        }
        if (qtd_Equipas == 0) {
            System.out.println("Não existem equipas com mais golos sofridos que marcados!");
        } else {
            for (int idx1 = 0; idx1 < qtd_Equipas - 1; idx1++) {
                for (int idx2 = idx1 + 1; idx2 < qtd_Equipas; idx2++) {
                    if (aux[idx1][1].compareTo(aux[idx2][1]) > 0) {
                        Ordenar(idx1, idx2, aux, aux2);
                    }
                }
            }
            System.out.println("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD | ");
            System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
            for (int b = 0; b < qtd_Equipas; b++) {
                Listar(b, aux, aux2);
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void PrimeiroLugarGrupo(String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) {

        if (i != 32) {
            System.out.println("Ainda não foram inseridas todas as equipas! Por favor adicione as que faltam através da opção 2 do menu!");
        } else {
            System.out.println("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD | ");
            System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
            for (int a = 0; a < i; a++) {
                {
                    if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][7] == 1) {
                        Listar(a, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
                    }
                }
            }
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void InformacaoEquipa(String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) {

        Scanner tec = new Scanner(System.in);

        System.out.print("Insira a equipa que deseja saber os dados: ");
        String Equipa = tec.nextLine();
        System.out.println();
        int posicao = -1;//a posição serve para guardar a posição do nome da equipa inserida pelo utilizador e está igualada a -1 apenas para comparação
        String Equipa_Array;
        for (int a = 0; a < i; a++) {
            Equipa_Array = Grupo_Equipa[a][1];
            if (Equipa_Array.equalsIgnoreCase(Equipa)) {
                posicao = a;
            }
        }
        if (posicao == -1) {
            System.out.println("A equipa que inseriu não existe!");
        } else {
            System.out.println("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD | ");
            System.out.println("|=====|=====|=================|====|====|====|====|====|====|====|====|");
            Listar(posicao, Grupo_Equipa, Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao);
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void Estatisticas(int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) throws FileNotFoundException {

        if (i != 32) {
            System.out.println("Ainda não foram inseridas todas as equipas! Por favor adicione as que faltam através da opção 2 do menu!");
        } else {
            PrintWriter out = new PrintWriter(new File("Statistics.txt"));

            int jogos = 0, vitorias = 0, empates = 0, derrotas = 0;
            double golosM = 0, golosS = 0;

            for (int a = 0; a < i; a++) {
                jogos = jogos + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][0];
                vitorias = vitorias + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][1];
                empates = empates + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][2];
                derrotas = derrotas + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][3];
                golosM = golosM + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][4];
                golosS = golosS + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][5];
            }
            out.println("Total de jogos= " + jogos / 2);
            out.println("Total de vitórias= " + vitorias);
            out.println("Total de empates= " + empates / 2);
            out.println("Total de derrotas= " + derrotas);
            out.println("Total de golos marcados= " + (int) golosM);
            out.println("Total de golos sofridos= " + (int) golosS);
            out.printf("Média de golos marcados por jogo= %.1f%n", (golosM / (jogos / 2)));
            out.printf("Média de golos sofridos por jogo= %.1f", (golosS / (jogos / 2)));
            out.close();
            System.out.println("Ficheiro guardado com sucesso!");
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------

    public static int FaseSeguinte(String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) {

        int c = i;
        if (i != 32) {
            System.out.println("Ainda não foram inseridas todas as equipas! Por favor adicione as que faltam através da opção 2 do menu!");
        } else {
            c = 0;
            int b;
            for (b = 0; b < i; b++) {
                if (Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[b][7] == 1 || Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[b][7] == 2) {
                    for (int colunas = 0; colunas <= 1; colunas++) {
                        Grupo_Equipa[c][colunas] = Grupo_Equipa[b][colunas];
                    }
                    for (int colunas = 0; colunas <= 7; colunas++) {
                        Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[c][colunas] = Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[b][colunas];
                    }
                    c++;
                }
            }
            for (int a = c + 1; a < i; a++) {
                for (int colunas = 0; colunas <= 1; colunas++) {
                    Grupo_Equipa[a][colunas] = "";
                }
                for (int colunas = 0; colunas <= 6; colunas++) {
                    Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][colunas] = 0;
                }
            }
            System.out.println("Equipas removidas com sucesso!");
        }
        return c;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void FaseSeguinteFicheiro(String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao, int i) throws FileNotFoundException {

        if (i != 16) {
            System.out.println("Por favor, elimine da memória as equipas que não passaram à fase seguinte através da opcção 12 do menu!");
        } else {
            PrintWriter out = new PrintWriter(new File("FinalStage.csv"));
            for (int a = 0; a < i; a++) {
                out.println(Grupo_Equipa[a][0] + "," + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][7] + "," + Grupo_Equipa[a][1] + "," + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[a][6]);
            }
            out.close();
            System.out.println("Ficheiro guardado com sucesso!");
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void Listar(int posicao, String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao) {

        System.out.printf("|%-5s", Grupo_Equipa[posicao][0]);
        System.out.printf("|%5s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][7]);
        System.out.printf("|%-17s", Grupo_Equipa[posicao][1]);
        System.out.printf("|%4s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][6]);
        System.out.printf("|%4s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][0]);
        System.out.printf("|%4s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][1]);
        System.out.printf("|%4s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][2]);
        System.out.printf("|%4s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][3]);
        System.out.printf("|%4s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][4]);
        System.out.printf("|%4s", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][5]);
        System.out.printf("|%4s|%n", Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][4] - Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][5]);
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void JogosDaFaseFinalFicheiro(int i, String[][] Grupo_Equipa, int[][] Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao) throws FileNotFoundException {

        if (i != 16) {
            System.out.println("Por favor, elimine da memória as equipas que não passaram à fase seguinte através da opcção 12 do menu!");
        } else {
            PrintWriter out = new PrintWriter(new File("FinalStageGames.txt"));
            int posicao = 0;
            for (int a = 1; a <= 4; a++) {
                out.printf(Grupo_Equipa[posicao][0] + "," + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][7] + "," + Grupo_Equipa[posicao][1] + "-");
                posicao++;
                posicao++;
                posicao++;
                out.printf(Grupo_Equipa[posicao][0] + "," + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][7] + "," + Grupo_Equipa[posicao][1] + "%n");
                posicao--;
                posicao--;
                out.printf(Grupo_Equipa[posicao][0] + "," + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][7] + "," + Grupo_Equipa[posicao][1] + "-");
                posicao++;
                out.printf(Grupo_Equipa[posicao][0] + "," + Jogos_Vitorias_Empates_Derrotas_GolosM_GolosS_Pontos_Posicao[posicao][7] + "," + Grupo_Equipa[posicao][1] + "%n");
                posicao++;
                posicao++;
            }
            out.close();
            System.out.println("Ficheiro guardado com sucesso!");
        }
    }
}
