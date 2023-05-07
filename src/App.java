/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 * 
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love  
 *   30 - Love  
 *   30 - 15    
 *   30 - 30    
 *   40 - 30    
 *   Deuce      
 *   Ventaja P1 
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.   
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.   
 */


import java.util.*;

public class App {

    // Enumeración para representar a los jugadores
    enum Player {
        P1,
        P2
    }

    // Función que simula un juego de tenis a partir de una lista de puntos jugados
    public static void tenis_game(List<Player> points) {

//..............................................................

        // Array de cadenas de texto que representa el marcador del juego
        String[] game = {"Love", "15", "30", "40"};
        // Variables para llevar la cuenta de los puntos de cada jugador
        int p1_points = 0;
        int p2_points = 0;
        // Bandera que indica si el juego ha terminado
        boolean finished = false;
        // Bandera que indica si se ha producido un error en la entrada de los puntos
        boolean error = false;

        // Se recorre la lista de puntos jugados
        for (Player player : points) {
            // Se comprueba si ya se ha terminado el juego
            error = finished;

            // Se incrementa el contador de puntos del jugador correspondiente
            if (player == Player.P1) {
                p1_points++;
            } else if (player == Player.P2) {
                p2_points++;
            }

            // Si ambos jugadores tienen al menos 3 puntos, se comprueba si hay ventaja o deuce
            if (p1_points >= 3 && p2_points >= 3) {
                // Si el juego no ha terminado y la diferencia de puntos es de uno o menos, se muestra la ventaja o deuce
                if (!finished && Math.abs(p1_points - p2_points) <= 1) {
                    if (p1_points == p2_points) {
                        System.out.println("Deuce");
                    } else if (p1_points > p2_points) {
                        System.out.println("Ventaja P1");
                    } else {
                        System.out.println("Ventaja P2");
                    }
                } else {
                    // Si el juego ha terminado o la diferencia de puntos es mayor que uno, se establece la bandera de juego terminado
                    finished = true;
                }
            } else {
                // Si ningún jugador tiene 4 puntos, se muestra el marcador actual
                if (p1_points < 4 && p2_points < 4) {
                    System.out.println(game[p1_points] + " - " + game[p2_points]);
                } else {
                    // Si algún jugador tiene 4 puntos, se establece la bandera de juego terminado
                    finished = true;
                }
            }
        }

        // Se muestra el resultado final del juego
        if (error || !finished) {
            System.out.println("Los puntos jugados no son correctos");
        } else if (p1_points > p2_points) {
            System.out.println("Ha ganado el P1");
        } else {
            System.out.println("Ha ganado el P2");
        }

//........................................................................

    }

    public static void main(String[] args) {
        // Ejemplos de juego de tenis
        tenis_game(Arrays.asList(Player.P1, Player.P1, Player.P2, Player.P2,
                Player.P1, Player.P2, Player.P1, Player.P1));

        tenis_game(Arrays.asList(Player.P1, Player.P1, Player.P2, Player.P2,
                Player.P1, Player.P2, Player.P1, Player.P1, Player.P2, Player.P1));

        tenis_game(Arrays.asList(Player.P1, Player.P1, Player.P1));

}



}
