package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Fecha;
import model.Venta;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelRegistro extends PanelPrincipal {
	
	private JTable table;
	private DefaultTableModel modelo;
	private JComboBox<Fecha> comboBox;
	private DefaultComboBoxModel<Fecha> comboModel;
	private JScrollPane scrollpane;
	private Ventana ventana;

	public PanelRegistro(Ventana ventana) {
		super(ventana);
		this.ventana = ventana;
		setBackground(Color.PINK);
		setSize(600, 550);
		setVisible(true);
		repaint();

		modelo = new DefaultTableModel();
		table = new JTable();
		modelo.addColumn("Nombre");
		modelo.addColumn("Fecha");
		modelo.addColumn("Cantidad");
		cargarTabla();
		table.setModel(modelo);
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(86, 88, 404, 226);
		add(scrollpane);

		comboBox = new JComboBox<>();
		comboModel = new DefaultComboBoxModel<>();
		colocarFechasNoRepetidas();
		comboBox.setModel(comboModel);
		comboBox.setBounds(96, 326, 169, 20);
		add(comboBox);

		JButton btnVer = new JButton("Ver Factura");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fecha fechaSeleccionada = comboBox.getItemAt(comboBox.getSelectedIndex());
				ArrayList<Venta> listaFacturaFecha = new ArrayList<>();
				for (Venta venta : ventana.getListaVentas()) {
					if ((venta.getFecha().toString()).equals(fechaSeleccionada.toString())) {
						listaFacturaFecha.add(venta);
						ventana.setContentPane(new PanelFactura(ventana, listaFacturaFecha));
					}
				}
				System.out.println(fechaSeleccionada);
			}
		});
		btnVer.setBounds(360, 325, 100, 23);
		add(btnVer);
		repaint();

	}

	private void colocarFechasNoRepetidas() {
		if (ventana.getListaVentas() != null) {
			ArrayList<Fecha> listaFechasNoRepetidas = new ArrayList<>();
			for (Venta venta : ventana.getListaVentas()) {
				if (!listaFechasNoRepetidas.isEmpty()) {
					for (Fecha fechaEnListaNoRepetidas : listaFechasNoRepetidas) {
						if (!(venta.getFecha().toString()).equals(fechaEnListaNoRepetidas.toString())) {
							listaFechasNoRepetidas.add(venta.getFecha());
							comboModel.addElement(venta.getFecha());
						}
					}
				} else {
					listaFechasNoRepetidas.add(venta.getFecha());
					comboModel.addElement(venta.getFecha());
				}
			}
		}
	}

	private void cargarTabla() {
		Object[] datos = new Object[3];
		if (ventana.getListaVentas() != null) {
			for (Venta venta : ventana.getListaVentas()) {
				datos[0] = venta.getNombre();
				datos[1] = venta.getFecha();
				datos[2] = venta.getCantidad();
				System.out.println(datos[0] + " - " + datos[1] + " - " + datos[2]);
				modelo.addRow(datos);
			}
		} else {
			System.out.println("Lista vacia");
		}
	}
}
