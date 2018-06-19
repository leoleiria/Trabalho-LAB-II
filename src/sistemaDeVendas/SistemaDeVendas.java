package sistemaDeVendas;

import control.Cadastro;
import control.Altera;
import control.Consulta;
import control.Deleta;
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
			case 3:
				Altera();
				break;
			case 4:	
				Deletar();
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
		System.out.println("_______________________________");
		switch (Menu.menuConsulta()) {
		case 1:
			Consulta.ConsultaCliente();
			break;
		case 2:
			Consulta.ConsultaAviao();
			break;
		case 3:
			Consulta.ConsultaVoo();
			break;
		case 4:
			Consulta.ConsultaBilhete();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}
	
	public static void Altera() {
		System.out.println("_______________________________");
		switch (Menu.menuAltera()) {
		case 1:
			Altera.AlterarCliente();
			break;
		case 2: 
			Altera.AlterarAviao();
			break;
		case 3:
			Altera.AlterarVoo();
			break;
		case 4:
			altera.AlterarBilhete();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}
	
	public static void Deletar() {
		System.out.println("_______________________________");
		switch (Menu.menuDeleta()) {
		case 1:
			Deleta.DeletarCliente();
			break;
		case 2:
			Deleta.DeletarAviao();
			break;
		case 3:
			Deleta.DeletarVoo();
			break;
		case 4:
			Deleta.DeletarBilhete();
			break;
		case 4:
			deleta.DeletarBilhete();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}
	
	
}
