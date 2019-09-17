package minimax;

public class Metodos {

    static void preencheArvore(Nodo n, int nivel, char player) {
        int i;
        char nextP;
        if (nivel != 0) {
            for (i = 0; i < nivel; i++) {
                char tab[][] = n.copiaTabuleiro();
                if (player == 'O') {
                    nextP = 'X';
                } else {
                    nextP = 'O';
                }
                jogada(tab, player, i);
                if (verificaWin(n.getTabuleiro()) == 0) {
                    n.filhos[i] = new Nodo(tab, player, nivel - 1);
                    preencheArvore(n.filhos[i], nivel - 1, nextP);
                } else {
                    n.filhos[i] = null;//new Nodo(tab, '-', 0);
                }
            }
        }
    }

    static int contaNodos(Nodo n, int nivel) {
        int c = 0;
        if (nivel == 0) {
            return 1;
        } else {
            Nodo[] filhos = n.filhos;
            for (Nodo filho : filhos) {
                if (verificaWin(filho.getTabuleiro()) == 0) {
                    c += contaNodos(filho, nivel - 1);
                }
            }
        }
        return c;
    }

    static int verificaWin(char[][] tab) {
        int i;
        for (i = 0; i < 3; i++) {
            if ((tab[i][0] == tab[i][1]) && (tab[i][1] == tab[i][2])) {
                if (tab[i][0] == 'X') {
                    return 1;
                } else if (tab[i][0] == 'O') {
                    return -1;
                }
            }
        }
        for (i = 0; i < 3; i++) {
            if ((tab[0][i] == tab[1][i]) && (tab[1][i] == tab[2][i])) {
                if (tab[0][i] == 'X') {
                    return 1;
                } else if (tab[0][i] == 'O') {
                    return -1;
                }
            }
        }
        if (((tab[0][0] == tab[1][1]) && (tab[1][1] == tab[2][2]))
                || ((tab[0][2] == tab[1][1]) && (tab[1][1] == tab[2][0]))) {
            if (tab[1][1] == 'X') {
                return 1;
            } else if (tab[1][1] == 'O') {
                return -1;
            }
        }
        return 0;
    }

    static void jogada(char[][] tab, char jogador, int i) {
        int x = 0;
        int y = 0;
        int z = 0;
        while (x != i) {
            if (tab[y][z] == '-') {
                x++;
            }

            z++;
            if (z == 3) {
                y++;
                z = 0;
            }
        }
        while (y < 3) {
            if (tab[y][z] == '-') {
                tab[y][z] = jogador;
                break;
            }
            z++;
            if (z == 3) {
                y++;
                z = 0;
            }
        }
    }

    static void printTab(char[][] tab) {
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static int minimax(Nodo n, int nivel, boolean f) {
        Nodo[] filhos;
        if (n.nivel == 1) {
            return verificaWin(n.getTabuleiro());
        } else if (!f) {
            int alpha = 1;
            filhos = n.filhos;
            for (Nodo filho : filhos) {
                if (filho != null) {
                    alpha = Math.min(alpha, minimax(filho, nivel - 1, true));
                }
            }
            return alpha;
        } else {
            int alpha = -1;
            filhos = n.filhos;
            for (Nodo filho : filhos) {
                if (filho != null) {
                    alpha = Math.max(alpha, minimax(filho, nivel - 1, false));
                }
            }
            return alpha;
        }
    }

    static int comparaTab(char[][] a, char[][] b) {
        int i, j;
        boolean f = true;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (a[i][j] != b[i][j]) {
                    f = false;
                }
            }
        }
        if (f == true) {
            return 1;
        } else {
            return 0;
        }
    }
}