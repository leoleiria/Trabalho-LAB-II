package model;

public class Aviao {
	private static String id;
	private static String nome;
	private static int nroAssentos;
	
	public Aviao(String id, String nome, int nroAssentos) {
		this.id = id;
		this.nome = nome;
		this.nroAssentos = nroAssentos;
	}

	public static String getId() {
		return id;
	}

	public static String getNome() {
		return nome;
	}

	public static int getNroAssentos() {
		return nroAssentos;
	}
	
	
}
