import java.util.Scanner;

public class Teatri {
    public static void main(String[] args) {
        int[][] tabelaUleseve = {
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {10, 0, 10, 10, 10, 10, 10, 10, 10, 10},
                {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
                {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
                {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
                {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
                {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
                {30, 40, 50, 50, 50, 50, 50, 50, 40, 30}
        };

        afishoUlese(tabelaUleseve);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Rezervimin deshironi ta realizoni nepermjet cmimit(shkruani 1) apo nepermjet pozicionit (shkruani 2)?");
        int zgjedhja = scanner.nextInt();

        if (zgjedhja == 1) {
            System.out.println("Ju lutem zgjidhni nje cmim: 10, 20, 30, 40, 50");
            int cmimi = scanner.nextInt();
            rezervoSipasCmimit(tabelaUleseve, cmimi);
        } else if (zgjedhja == 2) {
            System.out.println("Ju lutem jepni rreshtin dhe kolonen e uleses se deshiruar (p.sh. '2 3'):");
            int rreshti = scanner.nextInt();
            int kolona = scanner.nextInt();
            rezervoSipasPozicionit(tabelaUleseve, rreshti, kolona);
        } else {
            System.out.println("Zgjedhje e pavlefshme.");
        }

        afishoUlese(tabelaUleseve);
    }

    private static void afishoUlese(int[][] tabela) {
        System.out.println("Pershendetje, uleset e teatrit jane:");
        System.out.print(" Rreshti\n");
        for (int i = 0; i < tabela.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tabela[i].length; j++) {
                System.out.print(tabela[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void rezervoSipasCmimit(int[][] tabela, int cmimi) {
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela[i].length; j++) {
                if (tabela[i][j] == cmimi) {
                    System.out.println("Deshironi te rezervoni karrigen me numer " + (j + 1) + " ne rreshtin e " + (i + 1) + " (p/J)?");
                    Scanner scanner = new Scanner(System.in);
                    String pergjigja = scanner.nextLine();
                    if (pergjigja.equalsIgnoreCase("p")) {
                        tabela[i][j] = 0;
                        System.out.println("Rezervimi u realizua me sukses!");
                        return;
                    } else {
                        System.out.println("Rezervimi u anullua.");
                        return;
                    }
                }
            }
        }
        System.out.println("Nuk ka uleshe te lira me kete cmim.");
    }

    private static void rezervoSipasPozicionit(int[][] tabela, int rreshti, int kolona) {
        if (rreshti >= 1 && rreshti <= tabela.length && kolona >= 1 && kolona <= tabela[0].length) {
            if (tabela[rreshti - 1][kolona - 1] != 0) {
                System.out.println("Deshironi te rezervoni karrigen me numer " + kolona + " ne rreshtin e " + rreshti + " (p/J)?");
                Scanner scanner = new Scanner(System.in);
                String pergjigja = scanner.nextLine();
                if (pergjigja.equalsIgnoreCase("p")) {
                    tabela[rreshti - 1][kolona - 1] = 0;
                    System.out.println("Rezervimi u realizua me sukses!");
                } else {
                    System.out.println("Rezervimi u anullua.");
                }
            } else {
                System.out.println("Ulesja eshte e zene.");
            }
        } else {
            System.out.println("Pozicioni i zgjedhur nuk eshte i vlefshem.");
        }
    }
}