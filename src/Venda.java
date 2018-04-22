import java.time.LocalDateTime;

import model.Cliente;
import model.Voo;

public class Venda {
	private static model.Cliente cliente;
	private static model.Voo voo;
	private static LocalDateTime dataCompra;
	private static int assentos;
	
	public Venda(model.Cliente cliente, model.Voo voo, LocalDateTime dataCompra, int assentos) {
		this.cliente = cliente;
		this.voo = voo;
		this.dataCompra = dataCompra;
		this.assentos = assentos;
	}

	public static model.Cliente getCliente() {
		return cliente;
	}

	public static model.Voo getVoo() {
		return voo;
	}

	public static LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public static int getAssentos() {
		return assentos;
	}
	 
}
