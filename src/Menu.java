
public class Menu {
	public static int menu() {
		System.out.println("Menu Principal:");
		System.out.println("[1] Cadastro");
		System.out.println("[2] Consultar");
		System.out.println("[0] Sair"); 
		return Console.scanInt("	Op��o: ");
	}
	public static int menuCadastro() {
		System.out.println("Menu Cadastros:");
		System.out.println("[1] Cliente");
		System.out.println("[2] Avi�o");
		System.out.println("[3] V�o");
		System.out.println("[4] Venda");
		return Console.scanInt("	Op��o: ");
	}
	
	public static int menuConsulta() {
		System.out.println("Menu Consultas:");
		System.out.println("[1] Cliente");
		System.out.println("[2] Avi�o");
		System.out.println("[3] V�o");
		System.out.println("[4] Venda");
		return Console.scanInt("	Op��o: ");
	}
}
