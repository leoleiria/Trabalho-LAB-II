package model;

import java.time.LocalDateTime;

import model.*;

public class Bilhete {
	private String localizador;
	private int cliente;
	private int voo;
	private LocalDateTime dataHora;

	public Bilhete(String localizador, int cliente, int voo, LocalDateTime dataHora) {
		this.localizador = localizador;
		this.cliente = cliente;
		this.voo = voo;
		this.dataHora = dataHora;
	}

	public String getLocalizador() {
		return localizador;
	}

	public int getCliente() {
		return cliente;
	}

	public int getVoo() {
		return voo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	@Override
	public String toString() {
		return "Localizador: " + localizador + ", cliente: " + cliente + ", voo: " + voo + "Data e hora: " + dataHora;
	}

}
