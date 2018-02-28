package view;

import java.util.ArrayList;

import javax.swing.JFrame;

import model.Venta;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	private ArrayList<Venta> listaVentas;
	public Ventana() {
		setVisible(true);
		setSize(600, 550);
		setContentPane(new PanelPrincipal(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public ArrayList<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(ArrayList<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public static void main(String[] args) {
		new Ventana();
	}
}
