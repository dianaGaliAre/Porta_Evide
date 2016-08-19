package utng.edu.mx.msaucedo.rompecabeza;

/**
 * Created by Mariana Saucedo on 20/06/2016.
 */
public class Puzzle {
    private int[] tablero = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private int[] solucion = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private int tiro1;
    private int tiro2;
    private boolean banTiro; //false = tiro1, true = tiro2

    public void setTiro1(int tiro1) {
        this.tiro1 = tiro1;
        banTiro = true;
    }

    public void setTiro2(int tiro2) {
        this.tiro2 = tiro2;
        banTiro = false;
        intercambiar();
    }

    public void setBanTiro(boolean banTiro) {
        this.banTiro = banTiro;
    }

    public boolean isBanTiro() {
        return banTiro;
    }

    public void intercambiar() {
        int tempo = 0;
        tempo = tablero[tiro1];
        tablero[tiro1] = tablero[tiro2];

        tablero[tiro2] = tempo;
    }

    public boolean yaGano() {
        boolean banOK = true;

        for (int i = 0; i < 16; i++) {
            if(tablero[i] != solucion[i]) {
                banOK = false;
                break;
            }
        }
        return banOK;
    }
}

