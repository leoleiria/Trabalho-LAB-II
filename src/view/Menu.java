package view;

public class Menu {
	public static int menu() {
		System.out.println("Menu Principal:");
		System.out.println("[1] Cadastro");
		System.out.println("[2] Consultar");
		System.out.println("[3] Alterar");
		System.out.println("[4] Deletar");
		System.out.println("[0] Sair"); 
		return Console.scanInt("	Op��o: ");
	}
	public static int menuCadastro() {
		System.out.println("Menu Cadastros:");
		System.out.println("[1] Cliente");
		System.out.println("[2] Avi�o");
		System.out.println("[3] V�o");
		System.out.println("[4] Bilhete");
		return Console.scanInt("	Op��o: ");
	}

	public static int menuConsulta() {
		System.out.println("Menu Consultas:");
		System.out.println("[1] Cliente");
		System.out.println("[2] Avi�o");
		System.out.println("[3] V�o");
		System.out.println("[4] Bilhete");
		return Console.scanInt("	Op��o: ");
	}

	public static int menuAltera() {
		System.out.println("Menu de Altera��o:");
		System.out.println("[1] Cliente");
		System.out.println("[2] Avi�o");
		System.out.println("[3] V�o");
		System.out.println("[4] Bilhete");
		return Console.scanInt("	Op��o: ");
	}

	public static int menuDeleta() {
		System.out.println("Menu Deletar:");
		System.out.println("[1] Cliente");
		System.out.println("[2] Avi�o");
		System.out.println("[3] V�o");
		System.out.println("[4] Bilhete");
		return Console.scanInt("	Op��o: ");
	}
	
	
	
}
