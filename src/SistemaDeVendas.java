
import model.*;
import view.Menu;

public class SistemaDeVendas {
	static Voo vVoo[]= new Voo[30];
	static int contVoo = 0;
	static Cliente vCliente[]= new Cliente[30];
	static int contCli = 0;
	static Aviao vAviao[]= new Aviao[30];
	static int contAvi = 0;
	static Bilhete vBilhete[] = new Bilhete[30];
	static int contBil = 0;
	
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
			vAviao[contAvi++] = Cadastro.cadastrarAviao();
			break;
		case 3:
			vVoo[contVoo++] = Cadastro.cadastrarVoo();
			break;
		case 4:
			vBilhete[contBil++] = Cadastro.cadastrarVenda();
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
			ConsultaAviao();
			break;
		case 3:
			ConsultaVoo();
			break;
		case 4:
			ConsultaBilhete();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	private static void ConsultaCliente() {
		for(int i=0;i<contCli; i++) {
			if(vCliente[i] != null) {
				System.out.println(i+". "+vCliente[i]);
			}
		}
	}
	private static void ConsultaAviao() {
		for(int i=0;i<contAvi; i++) {
			if(vAviao[i] != null){
				System.out.println(vAviao[i].getId()+". "+vAviao[i]);
			}
		}
	}
	
	private static void ConsultaVoo() {
		for(int i=0;i<contVoo; i++) {
			if(vVoo[i] != null) {
				System.out.println(vVoo[i]);
			}
		}
	}
	
	private static void ConsultaBilhete() {
		for(int i=0;i<contBil; i++) {
			if(vBilhete[i] != null) {
				System.out.println(vBilhete[i]);
			}
		}
	}

}
