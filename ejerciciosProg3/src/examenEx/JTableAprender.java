package examenEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class JTableAprender {
	
	private static JFrame vent;
	private static JTable tabla;
	private static DefaultTableModel modelo;
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ventana
		vent = new JFrame();
		vent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vent.setSize(800,600);
		
		//Tabla
		modelo = new DefaultTableModel(new Object[] { "Nom", "Cod"}, 0 ) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if(column == 0) return false;
				else return super.isCellEditable(row, column);
			}
			
		};
		tabla = new JTable(modelo);
		vent.getContentPane().add(new JScrollPane(tabla), BorderLayout.CENTER);
		
		tabla.getTableHeader().setReorderingAllowed(false);
		
		//Datos
		modelo.addRow(new Object[] { "Itziar", 70});
		modelo.addRow(new Object[] { "Andoni", 120});
		modelo.addRow(new Object[] { "Xabi", 220});
		
		
		
		//Renderers
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			@Override
			public void setForeground(Color c) {
				// TODO Auto-generated method stub
				super.setForeground(c);
			}

			@Override
			public void setBackground(Color c) {
				// TODO Auto-generated method stub
				super.setBackground(c);
			}

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// TODO Auto-generated method stub
				Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				JLabel label = (JLabel) comp;
				if(row == 0) {
					label.setBackground(Color.red);
				}
				if(isSelected) {
					label.setBackground(Color.yellow);
					if(hasFocus) {
						label.setBorder(BorderFactory.createLineBorder(Color.cyan, 1));
					}else {
						label.setBackground(Color.white);
					}
				}
				return comp;
			}
			
		});
		
		tabla.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField() ) {
			Component ret;
			int valorAnt;
			JTextField tf;
			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				ret = super.getTableCellEditorComponent(table, value, isSelected, row, column);
				if(column==1) {
					tf = null;
					int valor = Integer.parseInt(value.toString());
					ret = new JSlider(0,255, valor);
					((JSlider)ret).addChangeListener(new ChangeListener() {
						
						@Override
						public void stateChanged(ChangeEvent e) {
							// TODO Auto-generated method stub
							valorAnt = ((JSlider)ret).getValue();
						}
					});
				}
				return ret;
			}
			@Override
			public Object getCellEditorValue() {
				if(tf!=null) {
					return tf.getText();
				}else {
					return valorAnt;
				}
			} 	
		});	
		
		tabla.addMouseListener(new MouseListener() {
			int filaPre;
			int filaPost;
			int colPre;
			int colPost;
			@Override
			public void mouseReleased(MouseEvent e) {
				filaPost = tabla.rowAtPoint(e.getPoint());
				colPost = tabla.columnAtPoint(e.getPoint());
				filaPre = filaPost;
				colPre = colPost;
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				filaPre = tabla.rowAtPoint(e.getPoint());
				colPre = tabla.columnAtPoint(e.getPoint());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		vent.setVisible(true);
	}

}
