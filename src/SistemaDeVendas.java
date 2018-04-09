
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
			Cadastro.cadastrarCliente();
			break;
		case 2:
			Cadastro.cadastrarAviao();
			break;
		case 3:
			Cadastro.cadastrarVoo();
			break;
		case 4:
			Cadastro.cadastrarVenda();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	public static void Consulta() {
		switch (Menu.menuConsulta()) {
		case 1:
			ConsultaCliente.ListaTodos();
			break;
		case 2:
			ConsultaAviao.ListaTodos();
			break;
		case 3:
			ConsultaVoo.ListaTodos();
			break;
		case 4:
			// ConsultaVenda.ListaTodos(); implementação a fazer
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

}
