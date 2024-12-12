package Entorns_MatrixDebugging;

import java.util.Scanner;
import java.util.Random;

public class Tres_en_raya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		        
		        Scanner scanner = new Scanner(System.in);
		       
		        Random random = new Random();

		        // Matriu 3x3 per representar el tauler
		        String[][] tauler = new String[3][3];
		        // Declaro les variables per als noms dels jugadors i el torn actual
		        String jugador1, jugador2;
		        String torn;
		        // Variable per controlar si el joc continua en curs
		        boolean jocEnCurs = true;

		        // Tauler amb espais buits
		        for (int i = 0; i < 3; i++) {
		            for (int j = 0; j < 3; j++) {
		                tauler[i][j] = " "; 
		            }
		        }

		        
		        System.out.println("Introdueix el nom del Jugador 1:");
		        jugador1 = scanner.nextLine();
		        
		        System.out.println("Introdueix el nom del Jugador 2:");
		        jugador2 = scanner.nextLine();

		        // Aleatòriament qui començarà
		        if (random.nextInt(2) == 0) {
		            torn = jugador1;  // Si el número aleatori és 0, el Jugador 1 començarà
		        } else {
		            torn = jugador2;  // Si el número aleatori és 1, el Jugador 2 començarà
		        }

		        // Bucle principal del joc
		        while (jocEnCurs) {
		            // Mostro el tauler després de cada moviment
		            System.out.println("Tauler:");
		            for (int i = 0; i < 3; i++) {
		                for (int j = 0; j < 3; j++) {
		                    System.out.print("[" + tauler[i][j] + "]");  //Cada casella del tauler
		                }
		                System.out.println();  // Salt de línia després de cada fila del tauler
		            }

		            // Demano al jugador actual que introdueixi el seu moviment
		            int fila, columna;
		            boolean movimentValid = false;
		            while (!movimentValid) {
		                // Sol·licito al jugador que introdueixi una fila i columna (1-3)
		                System.out.println(torn + ", introdueix fila (1-3) i columna (1-3) per posar la teva fitxa:");
		                fila = scanner.nextInt() - 1;  // Restem 1 per ajustar la entrada a índexs de matriu (0-2)
		                columna = scanner.nextInt() - 1;  // Faig el mateix amb la columna

		                // Verifico si la casella triada és vàlida, es a dir, dins del rang i buida
		                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tauler[fila][columna].equals(" ")) {
		                    // Si la casella està buida, posola fitxa del jugador en aquesta posició
		                    tauler[fila][columna] = torn.equals(jugador1) ? "X" : "O";  // "X" per al Jugador 1, "O" per al Jugador 2
		                    movimentValid = true; 
		                    
		                } else {
		                    
		                    System.out.println("Posició invàlida. La casella està ocupada o fora de rang. Intenta novament.");
		                }
		            }

		            // Comprovo si hi ha un guanyador després del moviment
		            boolean victoria = false;
		            // Comprovo les files i columnes per veure si hi ha tres fitxes iguals alineades
		            for (int i = 0; i < 3; i++) {
		                if ((tauler[i][0].equals(tauler[i][1]) && tauler[i][0].equals(tauler[i][2]) && !tauler[i][0].equals(" "))
		                    || (tauler[0][i].equals(tauler[1][i]) && tauler[0][i].equals(tauler[2][i]) && !tauler[0][i].equals(" "))) {
		                    victoria = true; 
		                    break;  
		                }
		            }
		            // Comprovem les dues diagonals per veure si hi ha tres fitxes iguals alineades
		            if ((tauler[0][0].equals(tauler[1][1]) && tauler[0][0].equals(tauler[2][2]) && !tauler[0][0].equals(" "))
		                || (tauler[0][2].equals(tauler[1][1]) && tauler[0][2].equals(tauler[2][0]) && !tauler[0][2].equals(" "))) {
		                victoria = true;  
		            }

		            // Si hi ha un guanyador
		            if (victoria) {
		                System.out.println(torn + " ha guanyat!");  
		                System.out.println("Vols jugar una altra vegada? (si/no)");
		                String resposta = scanner.next();  
		                if (resposta.equalsIgnoreCase("si")) {
		                    // Si volen jugar de nou, es reiniciarà el tauler i continuarà amb el joc
		                    for (int i = 0; i < 3; i++) {
		                        for (int j = 0; j < 3; j++) {
		                            tauler[i][j] = " ";  // Neteja del tauler
		                        }
		                    }
		                    continue;  // Reinicio el bucle per una nova partida
		                } else {
		                    jocEnCurs = false;  // Si no volen jugar de nou, acaba el joc
		                    System.out.println("Gràcies per jugar. Fins la propera!");
		                }
		            }

		            // Comprovació per si hi ha un empat
		            boolean empat = true;
		            for (int i = 0; i < 3; i++) {
		                for (int j = 0; j < 3; j++) {
		                    if (tauler[i][j].equals(" ")) {
		                        empat = false;  // Si es troba una casella buida, no és empat
		                        break;  
		                    }
		                }
		            }

		            if (empat) {
		                System.out.println("És un empat!");  
		                System.out.println("Vols jugar una altra vegada? (si/no)");
		                String resposta = scanner.next();  
		                if (resposta.equalsIgnoreCase("si")) {
		                    
		                    for (int i = 0; i < 3; i++) {
		                        for (int j = 0; j < 3; j++) {
		                            tauler[i][j] = " "; 
		                        }
		                    }
		                    continue;  // Reinicio el bucle per una nova partida
		                } else {
		                    jocEnCurs = false;  
		                    System.out.println("Gràcies per jugar. Fins la propera!");
		                }
		            }

		            // Canvi de torn al següent jugador
		            torn = (torn.equals(jugador1)) ? jugador2 : jugador1;  // Si el torn és del Jugador 1, passa al Jugador 2, i viceversa
		        }

		        // Tanco scanner per prevenir errors en el programa
		        scanner.close();
		    }
		}
