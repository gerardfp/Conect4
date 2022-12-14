import java.util.Scanner;

class Conecta4 {
    Scanner scanner = new Scanner(System.in);
    int[][] tablero = new int[6][7];
    int columna;
    int jugador = 1;
    boolean bingo;

    void mostrarTablero(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("⚪");
                } else if (tablero[i][j] == 1) {
                    System.out.print("🔴");
                } else {
                    System.out.print("🟡");
                }
            }
            System.out.println();
        }
    }

    void pedirColumna() {
        columna = scanner.nextInt();
    }


    void colocarFicha() {
        for (int i = 5; i >= 0; i--) {
            if (tablero[i][columna] == 0){
                tablero[i][columna] = jugador;
                break;
            }
        }    
    }

    void cambiarTurno() {
        if (jugador == 1) {
            jugador = 2;
        } else if (jugador == 2) {
            jugador = 1;
        }
    }

    void comprobarGanador() {
        int contador = 1;
        for (int j = 1; j < 7; j++) {
            if (tablero[5][j] == tablero[5][j-1] && tablero[5][j] != 0) {
                contador++;
            } else {
                contador = 1;
            }

            if (contador == 4) {
                bingo = true;
                break;
            }
        }

    }
}

public class Main {

    public static void main(String[] args) {

        Conecta4 conecta4 = new Conecta4();

        for(;;) {
            conecta4.mostrarTablero();
            conecta4.comprobarGanador();
            if (conecta4.bingo) {
                System.out.println("Ha ganado tal y cual");
                break;
            }
            conecta4.pedirColumna();
            conecta4.colocarFicha();
            conecta4.cambiarTurno();
        }
    }
}
