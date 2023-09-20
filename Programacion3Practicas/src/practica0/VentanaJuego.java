package practica0;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaJuego extends JFrame{
	protected JPanel pnlCentro;
	protected JPanel pnlBotonera;
	protected JButton btnAcelera;
	protected JButton btnFrena;
	protected JButton btnIzq;
	protected JButton btnDrc;
	protected Thread hilo;
	protected static Coche miCoche;
	
	public VentanaJuego() {
		pnlCentro = new JPanel();
		pnlBotonera = new JPanel();
		miCoche = new Coche();
		
		btnAcelera = new JButton("Acelerar");
		btnAcelera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 miCoche.acelera(5);
			        System.out.println("Velocidad: " + miCoche.getMiVelocidad() + " píxeles/segundo");
			}
		});
		
		btnFrena = new JButton("Frenar");
		btnFrena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				miCoche.acelera(-5);
		        System.out.println("Velocidad: " + miCoche.getMiVelocidad() + " píxeles/segundo");
			}
		});
		
		btnIzq = new JButton("Girar Izq");
		btnIzq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				miCoche.gira(-10);
				
			}
		});
		
		btnDrc = new JButton("Girar Drc");
		btnDrc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				miCoche.gira(10);
				
			}
		});
		
		pnlBotonera.add(btnAcelera);
		pnlBotonera.add(btnFrena);
		pnlBotonera.add(btnIzq);
		pnlBotonera.add(btnDrc);
		
		 JLabelCoche cocheLabel = new JLabelCoche();
	     pnlCentro.add(cocheLabel);
		
		
		
		pnlCentro.add(pnlBotonera , BorderLayout.SOUTH);
		this.add(pnlCentro , BorderLayout.CENTER);
		

		
        miCoche.setPiloto("Juan");
        miCoche.setPosX(150);
        miCoche.setPosY(100);
       
        
		
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(false);
		
		
	}
	
	
	public void MovimientoCoche(Coche coche) {
		hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				 while (true) {
		                miCoche.mueve(0.04);
		                System.out.println("Posición: X=" + miCoche.getPosX() + ", Y=" + miCoche.getPosY());
		                try {
		                    Thread.sleep(40);
		                } catch (InterruptedException e) {
		                }
		             }
				 }
		});
	    hilo.start();
    }
    
	public static void main(String[] args) {
		VentanaJuego v = new VentanaJuego();
		v.setVisible(true);

		
		 	

        System.out.println(miCoche.toString());
	        

	        
	        

	}


}
