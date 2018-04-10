package Model;

public class Cliente {
	private static int rg;
	private static String nome;
	private static String telefone;

	public Cliente(int rg, String nome, String telefone) {
		this.rg = rg;
		this.nome = nome;
		this.telefone = telefone;
	}

	public static int getRg() {
		return rg;
	}

	public static String getNome() {
		return nome;
	}

	public static String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		return getNome()+"    "+getRg()+"    "+getTelefone();

	
	}	

}
