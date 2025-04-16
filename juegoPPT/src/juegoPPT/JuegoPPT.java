package juegoPPT;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * la clase JuegoPPT simula el clásico juego de Piedra, Papel, Tijeras. Se compone de un método principal
 * que contiene el menu del juego (bucle do while con estructura switch, que tiene dos opciones: jugar y salir. 
 * Cada opción llama al método homónimo. 
 * 
 * @author Daniel Pacheco
 * @version 1.2
 * since 2025/03/31
 */

public class JuegoPPT {

	/**
	 * en el método main se ejecuta el juego. Contiene el menú, que llamará a los
	 * métodos jugar() o salir() dependiendo de la opción que el jugador elija
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int menu = 0; // esta variable almacenará, dentro del bucle, la opción del menú elegida

		System.out.println("\n............................\n        Juguemos a:\n\n"
				+ " Piedra - Papel - Tijeras!! \n............................");

		do {
			try {
				System.out.println(
						"\n        Selecciona: \n\n       [1] -> Jugar\n       [2] -> Salir \n............................");
				menu = scanner.nextInt();

				switch (menu) {
				case 1:
					jugar(scanner); // si el usuario introduce 1, se llama al método jugar()
					break;

				case 2:
					salir(); // si el usuario introduce 0, se llama al método salir()
					break;

				default:
					System.out.println("\n       ->> Error <<- \nIntroduce una opción válida \n............................");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("\n       ->> Error <<- \nIntroduce una opción válida \n............................");
				scanner.nextLine();
			}

		} while (menu != 2); // mientras el usuario no introduzca 0, el juego seguirá funcionando

		scanner.close();

	} // fin main

	/**
	 * el método jugar() contiene la lógica del juego. Se genera de forma aleatoria
	 * un valor entre 1 y 3 con el método Math.random(). Cada valor corresponde a
	 * una opción (1 para Piedra, 2 Papel, 3 Tijeras). El usuario introduce por
	 * teclado su elección y posteriormente se comparan las dos elecciones.
	 * Dependiendo del resultado de la comparación, el jugador gana, pierde o
	 * empata.
	 * 
	 * @param scanner - la elección que realiza el usuario (1 piedra, 2 papel o 3 tijeras)
	 */

	public static void jugar(Scanner scanner) { // pasamos scanner como parámetro, así cerramos scanner de una en el
												// main al finalizar el programa

		System.out.println(
				"       ¡Vamos allá!\n\n        Introduce:\n\n   [1] -> eliges PIEDRA \n   [2] -> eliges PAPEL \n   [3] -> eliges TIJERAS");
		int eleccionCPU = (int) (Math.random() * 3) + 1;

		int eleccionJugador = scanner.nextInt();

		if ((eleccionJugador > 3) || (eleccionJugador < 1)) {
			System.out.println("¡¡introduciste un valor no permitido!!");
		}

		else if ((eleccionJugador == 1) && (eleccionCPU == 2)) {
			System.out.println();
			System.out.println("elegiste... -> PIEDRA ");
			System.out.println("la máquina eligió... -> PAPEL");
			perder();
		}

		else if ((eleccionJugador == 1) && (eleccionCPU == 3)) {
			System.out.println();
			System.out.println("elegiste... -> PIEDRA");
			System.out.println("la máquina eligió... -> TIJERAS");
			ganar();
		}

		else if ((eleccionJugador == 2) && (eleccionCPU == 1)) {

			System.out.println("elegiste... -> PAPEL");
			System.out.println("la máquina eligió... -> PIEDRA");
			ganar();
		}

		else if ((eleccionJugador == 2) && (eleccionCPU == 3)) {
			System.out.println();
			System.out.println("elegiste... -> PAPEL");
			System.out.println("la máquina eligió... -> TIJERAS");
			perder();
		}

		else if ((eleccionJugador == 3) && (eleccionCPU == 1)) {
			System.out.println();
			System.out.println("elegiste... -> TIJERAS");
			System.out.println("la máquina eligió... -> PIEDRA");
			perder();
		}

		else if ((eleccionJugador == 3) && (eleccionCPU == 2)) {
			System.out.println();
			System.out.println("elegiste... -> TIJERAS\n");
			System.out.println("la máquina eligió... -> PAPEL\n");
			ganar();
		}

		else {
			System.out.println("  hábeis sacado lo mismo... \n        ¡¡EMPATE!!");
		}

	} // fin método jugar()
	
	/**
	 * método que muestra en pantalla el mensaje cuando el usuario gana
	 */
	public static void ganar() {
		System.out.println(" ..........................\n    ***** YOU WIN!! ***** \n ..........................");
	}

	/**
	 * método que muestra en pantalla el mensaje cuando el usuario pierde
	 */
	public static void perder() {
		System.out.println(" ..........................\n   ***** YOU LOSE!! ***** \n ..........................");
	}

	/**
	 * el método salir() muestra un mensaje de despedida cuando el usuario elige finalizar el juego.
	 */
	public static void salir() {
		System.out.println("¡Hasta la próxima!");

	} // fin método salir()

} // fin clase Juego
