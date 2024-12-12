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

		            
		    }
		}
