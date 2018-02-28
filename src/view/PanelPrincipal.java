package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel {
	
	private Ventana ventana;
	
	public PanelPrincipal(Ventana ventana) {
		setVisible(true);
		setSize(600, 550);
		setLayout(null);
		this.ventana = ventana;
		initComponents();
	}

	private void initComponents() {
		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setContentPane(new PanelVentas(ventana));
			}
		});
		btnVender.setBounds(74, 443, 89, 23);
		add(btnVender);
		
		JButton btnVerListaDe = new JButton("Registro de Ventas");
		btnVerListaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setContentPane(new PanelRegistro(ventana));
			}
		});
		btnVerListaDe.setBounds(348, 443, 161, 23);
		add(btnVerListaDe);
	}

}
