
import View.Menu;
import Model.Cliente;

public class SistemaDeVendas {
	static int vVoo[]= new int [30];
	static int contVoo = 0;
	static Cliente vCliente[]= new Cliente [30];
	static int contCli = 0;
	static int vAviao[]= new int [30];
	int contAvi = 0;
	static int vBilhete[] = new int [30];
	int contBil = 0;
	
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
			vCliente[contCli++] = Cadastro.cadastrarCliente();
			
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
			ConsultaCliente();
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

	private static void ConsultaCliente() {
		for(int i=0;i<contCli; i++) {
			if(vCliente[i] != null) {
				System.out.println(vCliente[i].getNome());
			}
		}
		
	}

}
