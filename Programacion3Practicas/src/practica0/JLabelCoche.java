package practica0;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;


import javax.swing.*;

public class JLabelCoche extends JLabel{
	 
	
	public JLabelCoche(){
		
		try {
			this.setIcon(new ImageIcon(JLabelCoche.class.getResource("coche.png").toURI().toURL()));
		} catch (Exception e) {
			
			this.setBounds(0,0,100,100);
		} 
	}
    
	public void paintComponent(Graphics g) {
		Image imagen = ((ImageIcon)
		this.getIcon()).getImage();
		Graphics2D gg = (Graphics2D)g;
		gg.drawImage(imagen, 0, 0, 100, 100, null);

        
    }
    
}
