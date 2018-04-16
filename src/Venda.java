import java.time.LocalDateTime;

import Model.Cliente;
import Model.Voo;

public class Venda {
	private static Model.Cliente cliente;
	private static Model.Voo voo;
	private static LocalDateTime dataCompra;
	private static int assentos;
	
	public Venda(Model.Cliente cliente, Model.Voo voo, LocalDateTime dataCompra, int assentos) {
		this.cliente = cliente;
		this.voo = voo;
		this.dataCompra = dataCompra;
		this.assentos = assentos;
	}

	public static Model.Cliente getCliente() {
		return cliente;
	}

	public static Model.Voo getVoo() {
		return voo;
	}

	public static LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public static int getAssentos() {
		return assentos;
	}
	 
}
