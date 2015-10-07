

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.*;
import Modelo.*;
import Vista.*;
import java.awt.BorderLayout;
import javax.swing.JButton;


public class Principal {

	public static void main(String[] args) throws IOException {

																	//		ImageIcon sky = new ImageIcon ("/Users/alulab14.INF/Downloads/Koshi/imagenes/grasesito.jpg");
																	//
																	//	    JPanel grid = new JPanel();
																	//	    grid.setLayout(new GridLayout(12, 16));
																	//	    for (int i = 0; i < 12; i++) {
																	//	        for (int n = 0; n < 16; n++) {
																	//	            grid.add(new JLabel(sky));
																	//	        }
																	//	    }
																	//	    JFrame frame = new JFrame("Map");
																	//	    frame.setResizable(false);
																	//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
																	//	    frame.setPreferredSize(new Dimension(1024, 780));
																	//	    frame.getContentPane().add(grid);
																	//	    frame.pack();
																	//	    frame.setVisible(true);
		
//		Ventana v = new Ventana();
	
		
		
		Juego jueguito = new Juego();

		jueguito.jugar();

	}
}
