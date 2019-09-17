package minimax;

public class MiniMax {

    public static void main(String[] args) {
        int i, j;
        int niveis = 9;
        Nodo raiz;
        char firstP = 'X';
        char[][] tab = new char[3][3];
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                tab[i][j] = '-';
            }
        }
        raiz = new Nodo(tab, firstP, 9);
        Metodos.preencheArvore(raiz, niveis, firstP);
        //Metodos.printTab(raiz.filhos[3].filhos[0].filhos[0].filhos[0].filhos[0].filhos[0].filhos[0].filhos[0].copiaTabuleiro());
        System.out.println("Quantidade de estados: " + Metodos.contaNodos(raiz, niveis));
        System.out.println("Valor do minimax: " + Metodos.minimax(raiz, niveis, true));
        
    }
}
