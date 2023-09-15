package Deberes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class VentanaConfirmacion {

	    // Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	    private static void procesoConfirmar() {
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	        }
	    }

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Ventana de Confirmación");

	        JTextField textField = new JTextField(20);
	        JButton confirmButton = new JButton("Confirmar");

	        confirmButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                confirmButton.setEnabled(false); // Desactiva el botón mientras se realiza el proceso
	                // Crea un hilo para realizar el proceso de confirmación
	                Thread confirmThread = new Thread(new Runnable() {
	                    @Override
	                    public void run() {
	                        procesoConfirmar();
	                        // Habilita nuevamente el botón después de que se complete el proceso
	                        SwingUtilities.invokeLater(new Runnable() {
	                            @Override
	                            public void run() {
	                                confirmButton.setEnabled(true);
	                            }
	                        });
	                    }
	                });
	                confirmThread.start();
	            }
	        });

	        JPanel panel = new JPanel();
	        panel.add(textField);
	        panel.add(confirmButton);

	        frame.add(panel);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	}

