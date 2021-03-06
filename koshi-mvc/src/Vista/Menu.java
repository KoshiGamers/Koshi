package Vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame {
	
	private static int seleccionado=0;
	
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1024, 768));
		setTitle("Koshi y la Selva del Amazonas");
		// frame.getContentPane().add(grid);
		pack();
		getContentPane().setLayout(null);

		JButton btnNuevoJuego = new JButton("Nuevo Juego");
		btnNuevoJuego.setBounds(712, 326, 147, 72);
		btnNuevoJuego.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(e.getButton()==MouseEvent.BUTTON1){
					seleccionado=1;					
				}
			}
		});
		getContentPane().add(btnNuevoJuego);

		JButton btnCargarJuego = new JButton("Cargar Juego");
		btnCargarJuego.setBounds(712, 428, 147, 72);
		btnCargarJuego.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(e.getButton()==MouseEvent.BUTTON1){
					seleccionado=2;
				}
			}
		});
		
		getContentPane().add(btnCargarJuego);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(712, 534, 147, 72);
		btnSalir.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(e.getButton()==MouseEvent.BUTTON1){
					seleccionado=3;
				}
			}
		});
		getContentPane().add(btnSalir);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes\\MenuInicio.jpg"));
		lblNewLabel.setBounds(0, 0, 1018, 740);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		
	}


	static int getSeleccionado() {
		return seleccionado;
	}

	public static void setSeleccionado(int seleccionado) {
		Menu.seleccionado = seleccionado;
	}

}
// package Vista;
//
// import java.awt.Dimension;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
//
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
//
// public class Menu extends JFrame {
//
// public Menu() {
// setResizable(false);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setPreferredSize(new Dimension(1024, 768));
// // frame.getContentPane().add(grid);
// pack();
// getContentPane().setLayout(null);
//
// JButton btnNuevoJuego = new JButton("Nuevo Juego");
// btnNuevoJuego.setBounds(712, 326, 147, 72);
// // Le meti esto a c/u , el addActionListener
// btnNuevoJuego.addActionListener((ActionListener) this);
// getContentPane().add(btnNuevoJuego);
//
// JButton btnCargarJuego = new JButton("Cargar Juego");
// btnCargarJuego.setBounds(712, 428, 147, 72);
// btnCargarJuego.addActionListener((ActionListener) this);
// getContentPane().add(btnCargarJuego);
//
// JButton btnSalir = new JButton("Salir");
// btnSalir.setBounds(712, 534, 147, 72);
// btnSalir.addActionListener((ActionListener) this);
// getContentPane().add(btnSalir);
//
// JLabel lblNewLabel = new JLabel("");
// lblNewLabel.setIcon(new ImageIcon("imagenes\\MenuInicio.jpg"));
// lblNewLabel.setBounds(0, 0, 1018, 740);
// getContentPane().add(lblNewLabel);
// setVisible(true);
//
// }
//
// public void actionPerformed(ActionEvent evento) {
// if (evento.getSource() == btnNuevoJuego) {
// // Ac� llamas a la ventana que has creado con el juego
// VentanaJuego miVentanaJuego = new VentanaJuego();
// miVentanaJuego.setSize(1024, 768);
// miVentanaJuego.setVisible(true);
//
// } else if (evento.getSource() == btnCargarJuego) {
// // codigo de cargar XML y esa nota
//
// } else if (evento.getSource() == btnSalir) {
// String message = "Deseas salir de la partida?";
// String title = "Arrugon!";
// int reply = JOptionPane.showConfirmDialog(null, message, title,
// JOptionPane.YES_NO_OPTION);
// if (reply == JOptionPane.YES_OPTION) {
// System.exit(0);
// }
// }
// }
// }