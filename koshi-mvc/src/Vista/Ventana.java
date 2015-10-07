package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Ventana() {
		super();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1230, 800));
		// frame.getContentPane().add(grid);
		pack();
		getContentPane().setLayout(null);

		// ImageIcon sky = new ImageIcon
		// ("/Users/alulab14.INF/Downloads/Koshi/imagenes/grasesito.jpg");
		// for (int i = 0; i < 12; i++) {
		// for (int n = 0; n < 16; n++) {
		// panel.add(new JLabel(sky));
		// //grid.add(new JLabel(sky));
		// }
		// }
		// JLabel lblTest = new JLabel("TEST");
		// lblTest.setIcon(new
		// ImageIcon("C:\\temp\\koshi-mvc\\imagenes\\grasesito.jpg"));
		// lblTest.setBounds(603, 169, 59, 45);
		// getContentPane().add(lblTest);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(1025, 0, 200, 768);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel textito1 = new JLabel("Personaje 1:");
		textito1.setBounds(26, 94, 80, 14);
		panel_1.add(textito1);

		JLabel textito2 = new JLabel("Personaje 2:");
		textito2.setBounds(27, 144, 80, 14);
		panel_1.add(textito2);

		JLabel lblNombre1 = new JLabel("xxxxxx");
		lblNombre1.setBounds(100, 94, 80, 14);
		panel_1.add(lblNombre1);

		JLabel labelNombre2 = new JLabel("xxxxxx");
		labelNombre2.setBounds(100, 144, 80, 14);
		panel_1.add(labelNombre2);

		JLabel Corazoncito = new JLabel("");
		Corazoncito.setIcon(new ImageIcon("imagenes\\corazoncito de vida.png"));
		Corazoncito.setBounds(26, 207, 64, 54);
		panel_1.add(Corazoncito);

		JLabel lblHP = new JLabel("New label");
		lblHP.setBounds(100, 222, 70, 39);
		panel_1.add(lblHP);

		JLabel lblSecuenciaDeComndos = new JLabel("Secuencia de comandos:");
		lblSecuenciaDeComndos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecuenciaDeComndos.setBounds(10, 298, 180, 17);
		panel_1.add(lblSecuenciaDeComndos);

		JLabel lblXxxxxx = new JLabel("xxxxxx");
		lblXxxxxx.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblXxxxxx.setBounds(20, 326, 86, 29);
		panel_1.add(lblXxxxxx);

		JEditorPane dtrpnInstruccionespp = new JEditorPane();
		dtrpnInstruccionespp.setText(
				"INSTRUCCIONES:\r\n\r\n-P1:\t-P2:\r\n\r\nw\ti        Arriba\r\na\tj        Derecha\r\nd\tl        Izquierda\r\ns\tk       Abajo");
		dtrpnInstruccionespp.setBounds(0, 390, 237, 152);
		panel_1.add(dtrpnInstruccionespp);

		JLabel textitoNvl = new JLabel("NIVEL:");
		textitoNvl.setBounds(26, 57, 46, 14);
		panel_1.add(textitoNvl);

		JLabel lblNivel = new JLabel();
		lblNivel.setBounds(100, 57, 46, 14);
		panel_1.add(lblNivel);

		JLabel p1 = new JLabel("p1");
		p1.setIcon(new ImageIcon("imagenes\\koshi-quieto-respirando.gif"));
		p1.setBounds(0, 0, 0, 0);
		getContentPane().add(p1);

		JLabel p2 = new JLabel("p2");
		p2.setIcon(new ImageIcon("imagenes\\GIF-MONO-DERECHA.gif"));
		p2.setBounds(0, 0, 0, 0);
		getContentPane().add(p2);

		setVisible(true);
	}
}
