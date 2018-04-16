package Model;
import java.time.LocalDateTime;

import Model.Cliente;
import Model.Voo;

public class Venda {
	private Model.Cliente cliente;
	private Model.Voo voo;
	private LocalDateTime dataCompra;
	private int assentos;
	
	public Venda(Model.Cliente cliente, Model.Voo voo, LocalDateTime dataCompra, int assentos) {
		this.cliente = cliente;
		this.voo = voo;
		this.dataCompra = dataCompra;
		this.assentos = assentos;
	}

	public Model.Cliente getCliente() {
		return cliente;
	}

	public Model.Voo getVoo() {
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
