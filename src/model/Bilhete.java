package model;

import model.*;

public class Bilhete {
	private String localizador;
	private Cliente cliente;
	private Voo voo;
	// assento???

	public Bilhete(String localizador, Cliente cliente, Voo voo) {
		this.localizador = localizador;
		this.cliente = cliente;
		this.voo = voo;
	}

	public String getLocalizador() {
		return localizador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Voo getVoo() {
		return voo;
	}

	@Override
	public String toString() {
		return "Localizador: " + localizador + ", cliente: " + cliente + ", voo: " + voo;
	}

}
