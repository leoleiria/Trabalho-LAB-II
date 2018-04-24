package model;

import java.time.LocalDateTime;

import model.*;

public class Bilhete {
	private String localizador;
	private Cliente cliente;
	private Voo voo;
	private LocalDateTime dataHora;

	public Bilhete(String localizador, Cliente cliente, Voo voo, LocalDateTime dataHora) {
		this.localizador = localizador;
		this.cliente = cliente;
		this.voo = voo;
		this.dataHora = dataHora;
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

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	@Override
	public String toString() {
		return "Localizador: " + localizador + ", cliente: " + cliente + ", voo: " + voo + "Data e hora: " + dataHora;
	}

}
