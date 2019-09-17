package minimax;

public class Nodo {

    private char[][] tabuleiro;
    private int valorMinimax;
    protected int nivel;
    private char jogador;
    protected Nodo[] filhos;

    public Nodo(char[][] tab, char jog, int nivel) {
        this.tabuleiro = tab;
        this.jogador = jog;
        this.nivel = nivel;
        this.filhos = new Nodo[nivel];
        this.valorMinimax = 11;
    }

    /**
     * @return the tabuleiro
     */
    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public char[][] copiaTabuleiro() {
        char[][] copy = new char[tabuleiro.length][];
        for (int i = 0; i < tabuleiro.length; i++) {
            char[] inner = tabuleiro[i];
            copy[i] = new char[inner.length];
            for (int j = 0; j < inner.length; j++) {
                copy[i][j] = inner[j];
            }
        }
        return copy;
    }

    /**
     * @param tabuleiro the tabuleiro to set
     */
    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    /**
     * @return the valorMinimax
     */
    public int getValorMinimax() {
        return valorMinimax;
    }

    /**
     * @param valorMinimax the valorMinimax to set
     */
    public void setValorMinimax(int valorMinimax) {
        this.valorMinimax = valorMinimax;
    }

    /**
     * @return the jogador
     */
    public char getJogador() {
        return jogador;
    }

    /**
     * @param jogador the jogador to set
     */
    public void setJogador(char jogador) {
        this.jogador = jogador;
    }

    /**
     * @return the filhos
     */
    public Nodo[] getFilhos() {
        return filhos;
    }

    /**
     * @param filhos the filhos to set
     */
    public void setFilhos(Nodo[] filhos) {
        this.filhos = filhos;
    }
}
