package juegoPPT;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * Implementa una versión del clásico juego de Piedra, Papel, Tijeras con una
 * interfaz gráfica. Al iniciarse muestra un mensaje de bienvenida, dando paso a
 * un menú interactivo donde el usuario puede elegir entre piedra, papel o
 * tijeras. La lógica del juego compara la elección del jugador con la elección
 * de la CPU, muestra el resultado y suma, en su caso, un punto al ganador de la
 * ronda. Al hacer clic en el botón de Nueva Partida se reinician los
 * contadores.
 * 
 * @author Daniel Pacheco <cloudxdam@gmail.com>
 * @version 2.0 since 2025/09/11
 * 
 */
public class JuegoPPT {
	private static JFrame ventana; // ventana principal del juego
	private static int eleccion; // elección del jugador
	private static JTextArea textArea_1; // área para mostrar información del juego
	private static JTextArea textArea_2; // para mostrar la elección del jugador
	private static JTextArea textArea_3; // para mostrar la elección de la CPU
	private static int contadorP1; // contador de rondas ganadas por el jugador
	private static JTextArea textArea_contP1; // para mostrar el contador de rondas ganadas por el jugador
	private static int contadorCPU; // coptador de rondas ganadas por la CPU
	private static JTextArea textArea_contCPU; // para mostrar las rondas ganadas por la CPU

	/**
	 * Punto de entrada principal del programa. Inicializa la ventana del juego y
	 * muestra un mensaje de bienvenida al usuario.
	 *
	 * @param args Argumentos de la línea de comandos (no utilizados).
	 * @throws IOException Si ocurre un error al cargar la imagen de fondo.
	 */
	public static void main(String[] args) throws IOException {
		JOptionPane.showMessageDialog(ventana,
				"Bienvenido al clásico juego de Piedra, Papel, Tijeras.\n     Elige haciendo clic en el icono correspondiente");
		ventana = new JFrame("Piedra - Papel - Tijeras!");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(640, 500);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		iniciarNuevaPartida();
		ventana.setVisible(true);
	}

	/**
	 * Inicializa una nueva partida, reiniciando los contadores y configurando la
	 * interfaz gráfica con paneles, botones, etiquetas y áreas de texto.
	 *
	 * @throws IOException Si ocurre un error al cargar la imagen de fondo.
	 */
	public static void iniciarNuevaPartida() throws IOException {
		contadorP1 = 0;
		contadorCPU = 0;

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setBackground(new Color(74, 117, 224));
		ventana.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 12, 616, 444);
		panel.add(panel_1);

		BufferedImage image1 = ImageIO.read(new File("resources/images/image1.png"));
		JLabel picLabel = new JLabel(new ImageIcon(image1));
		picLabel.setBounds(0, 0, image1.getWidth(), image1.getHeight());
		picLabel.isOptimizedDrawingEnabled();
		panel_1.setLayout(null);

		textArea_1 = new JTextArea("Información del juego");
		textArea_1.setBounds(262, 163, 120, 49);
		panel_1.add(textArea_1);
		textArea_1.setText("        ¡Es tu turno!\n    elige con cabeza\n      o la perderás!!");
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("SansSerif", Font.BOLD, 12));

		textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		textArea_2.setBounds(48, 293, 151, 36);
		panel_1.add(textArea_2);

		textArea_3 = new JTextArea();
		textArea_3.setLineWrap(true);
		textArea_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		textArea_3.setBounds(432, 293, 151, 36);
		panel_1.add(textArea_3);

		textArea_contP1 = new JTextArea("Rondas ganadas por el\n Jugador: 0");
		textArea_contP1.setLineWrap(true);
		textArea_contP1.setFont(new Font("SansSerif", Font.BOLD, 12));
		textArea_contP1.setBounds(48, 362, 151, 36);
		panel_1.add(textArea_contP1);

		textArea_contCPU = new JTextArea("Rondas ganadas por la\nMáquina: 0");
		textArea_contCPU.setLineWrap(true);
		textArea_contCPU.setFont(new Font("SansSerif", Font.BOLD, 12));
		textArea_contCPU.setBounds(432, 362, 151, 36);
		panel_1.add(textArea_contCPU);

		JLabel lblNewLabel_1 = new JLabel("Jugador");
		lblNewLabel_1.setBounds(91, 265, 80, 27);
		lblNewLabel_1.setForeground(new Color(74, 117, 224));
		lblNewLabel_1.setFont((new Font("SansSerif", Font.BOLD, 16)));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPU");
		lblNewLabel_2.setBounds(492, 265, 80, 27);
		lblNewLabel_2.setForeground(new Color(74, 117, 224));
		lblNewLabel_2.setFont((new Font("SansSerif", Font.BOLD, 16)));
		panel_1.add(lblNewLabel_2);

		JButton btnPapel = new JButton("");
		btnPapel.setBounds(556, 71, 60, 83);
		btnPapel.setBorder(null);
		btnPapel.setForeground(new Color(150, 255, 0));
		btnPapel.setContentAreaFilled(false);
		panel_1.add(btnPapel);
		btnPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion = 2;
				contar();
			}
		});

		JButton btnTijeras = new JButton("");
		btnTijeras.setBounds(22, 22, 80, 63);
		btnTijeras.setBorder(null);
		btnTijeras.setForeground(new Color(150, 255, 0));
		btnTijeras.setContentAreaFilled(false);
		panel_1.add(btnTijeras);
		btnTijeras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion = 3;
				contar();
			}
		});

		JButton btnPiedra = new JButton("");
		btnPiedra.setBounds(298, 352, 79, 63);
		btnPiedra.setBorder(null);
		btnPiedra.setForeground(new Color(150, 255, 0));
		btnPiedra.setContentAreaFilled(false);
		panel_1.add(btnPiedra);
		btnPiedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eleccion = 1;
				contar();
			}
		});
		panel_1.add(picLabel);

		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.setBounds(262, 12, 120, 27);
		panel_1.add(btnNuevaPartida);
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					iniciarNuevaPartida();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textArea_1.setText("          Iniciando\n     Nueva partida\n             ¡Elige!");
			}
		});
	}

	/**
	 * Procesa la lógica del juego comparando la elección del jugador con la de la
	 * CPU. Actualiza las áreas de texto con las elecciones y el resultado (ganar,
	 * perder o empate).
	 *
	 * @param eleccion La elección del jugador (1 = Piedra, 2 = Papel, 3 = Tijeras).
	 */
	public static void jugar(int eleccion) {
		int eleccionJugador = eleccion;
		int eleccionCPU = (int) (Math.random() * 3) + 1;

		if ((eleccionJugador == 1) && (eleccionCPU == 2)) {
			textArea_2.setText("elegiste...\nPIEDRA");
			textArea_3.setText("la máquina eligió...\nPAPEL");
			perder();
		}

		else if ((eleccionJugador == 1) && (eleccionCPU == 3)) {
			textArea_2.setText("elegiste...\nPIEDRA");
			textArea_3.setText("la máquina eligió...\nTIJERAS");
			ganar();
		}

		else if ((eleccionJugador == 2) && (eleccionCPU == 1)) {
			textArea_2.setText("elegiste...\nPAPEL");
			textArea_3.setText("la máquina eligió...\nPIEDRA");
			ganar();
		}

		else if ((eleccionJugador == 2) && (eleccionCPU == 3)) {
			textArea_2.setText("elegiste...\nPAPEL");
			textArea_3.setText("la máquina eligió...\nTIJERAS");
			perder();
		}

		else if ((eleccionJugador == 3) && (eleccionCPU == 1)) {
			textArea_2.setText("elegiste...\nTIJERAS");
			textArea_3.setText("la máquina eligió...\nPIEDRA");
			perder();
		}

		else if ((eleccionJugador == 3) && (eleccionCPU == 2)) {
			textArea_2.setText("elegiste...\nTIJERAS");
			textArea_3.setText("la máquina eligió...\nPAPEL");
			ganar();
		}

		else {
			textArea_1.setForeground(Color.BLACK);
			textArea_1.setBackground(Color.WHITE);
			textArea_1.setText(" Eligieron lo mismo\n         ¡¡EMPATE!!");
			String eJ = switch (eleccionJugador) {
			case 1 -> "PIEDRA";
			case 2 -> "PAPEL";
			case 3 -> "TIJERAS";
			default -> "otro";
			};
			textArea_2.setText("elegiste...\n" + eJ);
			String eC = switch (eleccionJugador) {
			case 1 -> "PIEDRA";
			case 2 -> "PAPEL";
			case 3 -> "TIJERAS";
			default -> "otro";
			};
			textArea_3.setText("la máquina eligió...\n" + eC);
		}
	}

	/**
	 * Muestra un mensaje de victoria en la interfaz y actualiza el contador de
	 * rondas ganadas por el jugador.
	 */
	public static void ganar() {
		textArea_1.setForeground(new Color(150, 255, 0));
		textArea_1.setText("\n  *** YOU WIN!! ***");
		contadorP1++;
		String contadorP1Str = String.valueOf(contadorP1);
		textArea_contP1.setText("Rondas ganadas por el\n Jugador: " + contadorP1Str);
	}

	/**
	 * Muestra un mensaje de derrota en la interfaz y actualiza el contador de
	 * rondas ganadas por la CPU.
	 */
	public static void perder() {
		textArea_1.setForeground(Color.RED);
		textArea_1.setText("\n *** YOU LOSE!! ***");
		contadorCPU++;
		String contadorCPUStr = String.valueOf(contadorCPU);
		textArea_contCPU.setText("Rondas ganadas por la\nMáquina: " + contadorCPUStr);
	}

	/**
	 * Muestra un mensaje de cuenta regresiva y, tras una pausa de 1.5 segundos,
	 * ejecuta la lógica del juego llamando al método jugar.
	 */
	@SuppressWarnings("unused")
	public static void contar() {
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setText("\n       1,  2,  3,  YA!!");
		Timer timer = new Timer(1500, e -> jugar(eleccion));
		timer.setRepeats(false);
		timer.start(); 
	}
}
