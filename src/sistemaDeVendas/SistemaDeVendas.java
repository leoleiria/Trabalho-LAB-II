package sistemaDeVendas;

import control.Cadastro;
import control.consulta;
import model.*;
import view.Menu;

public class SistemaDeVendas {
	public static Voo vVoo[]= new Voo[30];
	public static int contVoo = 0;
	public static Cliente vCliente[]= new Cliente[30];
	public static int contCli = 0;
	public static Aviao vAviao[]= new Aviao[30];
	public static int contAvi = 0;
	public static Bilhete vBilhete[] = new Bilhete[30];
	public static int contBil = 0;
	
	static boolean fim = true;
	
	public static void main(String[] args) {
		do {
			System.out.println("_______________________________");
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
		System.out.println("_______________________________");
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
		System.out.println("_______________________________");
		switch (Menu.menuConsulta()) {
		case 1:
			consulta.ConsultaCliente();
			break;
		case 2:
			consulta.ConsultaAviao();
			break;
		case 3:
			consulta.ConsultaVoo();
			break;
		case 4:
			consulta.ConsultaBilhete();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	
}
