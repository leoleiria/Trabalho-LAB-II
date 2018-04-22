package model;
import java.time.LocalDateTime;

import model.Cliente;
import model.Voo;

public class Venda {
	private model.Cliente cliente;
	private model.Voo voo;
	private LocalDateTime dataCompra;
	private int assentos;
	
	public Venda(model.Cliente cliente, model.Voo voo, LocalDateTime dataCompra, int assentos) {
		this.cliente = cliente;
		this.voo = voo;
		this.dataCompra = dataCompra;
		this.assentos = assentos;
	}

	public model.Cliente getCliente() {
		return cliente;
	}

	public model.Voo getVoo() {
		return voo;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public int getAssentos() {
		return assentos;
	}
	@Override
	public String toString() {
		return "Cliente: " + cliente.getNome() + ", Voo: " + voo.getPrefixo() + ", Data da compra: " + dataCompra+ ", Assentos: " + assentos;
	}
}
