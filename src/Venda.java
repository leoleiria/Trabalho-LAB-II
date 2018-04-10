import java.time.LocalDateTime;

import Model.Cliente;
import Model.Voo;

public class Venda {
	private static Cliente cliente;
	private static Voo voo;
	private static LocalDateTime dataCompra;
	private static int assentos;
	
	public Venda(Cliente cliente, Voo voo, LocalDateTime dataCompra, int assentos) {
		this.cliente = cliente;
		this.voo = voo;
		this.dataCompra = dataCompra;
		this.assentos = assentos;
	}

	public static Cliente getCliente() {
		return cliente;
	}

	public static Voo getVoo() {
		return voo;
	}

	public static LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public static int getAssentos() {
		return assentos;
	}
	 
}
