
public class SistemaDeVendas {
	static boolean fim = true;

	public static void main(String[] args) {
		do {
			switch (Menu.menu()) {
			case 1:
				Cadastro();
				break;
			case 2:
				Consulta();
				break;
			case 0:
				fim = false;
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (fim != false);
	}

	public static void Cadastro() {
		switch (Menu.menuCadastro()) {
		case 1:
			cadastrarCliente();
			break;
		case 2:
			cadastrarAviao();
			break;
		case 3:
			cadastrarVoo();
			break;
		case 4:
			cadastrarVenda();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	public static void Consulta() {
		ConsultaCliente.ListaTodos();
		ConsultaAviao.ListaTodos();
		//ConsultaVoo.ListaTodos();
	}

	public static void cadastrarCliente() {
		Cliente cliente = new Cliente(Console.scanInt("Digite o rg: "), Console.scanString("Digite o nome: "),
				Console.scanString("Digite o numero de telefone: "));
		System.out.println("__________________");
	}

	public static void cadastrarAviao() {
		Aviao aviao = new Aviao(Console.scanString("Digite o ID do avião: "),
				Console.scanString("Digite o nome do avião: "), Console.scanInt("Digite a quantidade de assentos: "));
		System.out.println("__________________");
	}

	public static void cadastrarVoo() {
		Voo voo = new Voo(Console.scanString("Digite a origem: "), Console.scanString("Digite o destino: "),
				DateFormater.localDate("Digite o horário de partida(dd/mm/aaaa): "), ConsultaAviao.EscolheAviao());
		
	}

	public static void cadastrarVenda() {

	}

}
