
import model.Aviao;
import model.Cliente;
import model.Voo;
import view.Console;

public class Cadastro {
	
	public static Cliente cadastrarCliente() {
		Cliente cliente = new Cliente(Console.scanInt("Digite o rg: "), Console.scanString("Digite o nome: "),
				Console.scanString("Digite o numero de telefone: "));
		System.out.println("__________________");
		return cliente;
	}

	public static void cadastrarAviao() {
		Aviao aviao = new Aviao(Console.scanString("Digite o ID do avião: "),
				Console.scanString("Digite o nome do avião: "), Console.scanInt("Digite a quantidade de assentos: "));
		System.out.println("__________________");
	}

	public static void cadastrarVoo() {// não esta funcionando para inserir a data ou para consultar o aviao
		Voo voo = new Voo(Console.scanString("Digite a origem: "), Console.scanString("Digite o destino: "),
				DateFormater.localDate("Digite o horário de partida(dd/mm/aaaa): "), ConsultaAviao.EscolheAviao());

	}

	public static void cadastrarVenda() {

	}

}
