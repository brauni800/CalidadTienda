package view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Fecha;
import model.Venta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelVentas extends PanelPrincipal {
	
	private JTextField textFieldNombre;
	private JTextField textFieldPrecio;
	private JTextField textFieldCantidad;

	public PanelVentas(Ventana ventana) {
		super(ventana);
		if (ventana.getListaVentas() == null) {
			ventana.setListaVentas(new ArrayList<>());
		}
		setBackground(Color.CYAN);
		setSize(600, 550);
		repaint();
		
		JLabel lblNombreDelArticulo = new JLabel("Nombre del articulo");
		lblNombreDelArticulo.setBounds(52, 65, 123, 14);
		add(lblNombreDelArticulo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(52, 112, 71, 14);
		add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(52, 160, 71, 14);
		add(lblCantidad);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(200, 62, 200, 20);
		add(textFieldNombre);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(200, 109, 200, 20);
		add(textFieldPrecio);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(200, 157, 200, 20);
		add(textFieldCantidad);
		
		JButton btnRealizarVenta = new JButton("Realizar venta");
		btnRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean nombreVacio = textFieldNombre.getText().equals(""), precioVacio = textFieldPrecio.getText().equals(""), cantidadVacio = textFieldCantidad.getText().equals("");
				System.out.println(nombreVacio);
				System.out.println(precioVacio);
				System.out.println(cantidadVacio);
				if (!nombreVacio && !precioVacio && !cantidadVacio) {
					Calendar calendar = Calendar.getInstance();
					int dia = calendar.get(Calendar.DATE), mes = calendar.get(Calendar.MONTH), anio = calendar.get(Calendar.YEAR);
					ventana.getListaVentas().add(new Venta(textFieldNombre.getText(), Double.parseDouble(textFieldPrecio.getText()), Integer.parseInt(textFieldCantidad.getText()), new Fecha(dia, mes, anio)));
					JOptionPane.showMessageDialog(null, "La venta se realizo con exito", "Venta exitosa", JOptionPane.INFORMATION_MESSAGE);
					resetComponents();
				} else {
					JOptionPane.showMessageDialog(null, "Un campo esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRealizarVenta.setBounds(200, 221, 146, 23);
		add(btnRealizarVenta);
		setVisible(true);
	}
	
	private void resetComponents() {
		textFieldNombre.setText("");
		textFieldPrecio.setText("");
		textFieldCantidad.setText("");
	}
}
