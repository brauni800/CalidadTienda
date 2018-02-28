package view;

import java.awt.Color;
import java.util.ArrayList;

import model.Venta;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelFactura extends PanelPrincipal {

	private ArrayList<Venta> listaFacturaFecha;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollpane;
	
	public PanelFactura(Ventana ventana, ArrayList<Venta> listaFacturaFecha) {
		super(ventana);
		this.listaFacturaFecha = listaFacturaFecha;
		setBackground(new Color(147, 112, 219));
		setSize(600, 550);
		
		modelo = new DefaultTableModel();
		table = new JTable();
		modelo.addColumn("Nombre");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio Individual");
		modelo.addColumn("Precio Total");
		cargarTabla();
		table.setModel(modelo);
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(86, 88, 404, 226);
		add(scrollpane);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setContentPane(new PanelRegistro(ventana));
			}
		});
		btnRegresar.setBounds(38, 43, 89, 23);
		add(btnRegresar);
		setVisible(true);
		repaint();
		
		
	}
	
	private void cargarTabla() {
		Object[] datos = new Object[4];
		for (Venta venta : listaFacturaFecha) {
			datos[0] = venta.getNombre();
			datos[1] = venta.getCantidad();
			datos[2] = venta.getPrecio();
			datos[3] = venta.getPrecio() * venta.getCantidad();
			System.out.println(datos[0] + " - " + datos[1] + " - " + datos[2] + " - " + datos[3]);
			modelo.addRow(datos);
		}
	}

}
