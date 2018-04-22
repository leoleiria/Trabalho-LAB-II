
import java.util.Random;

import model.*;
import view.Console;

public class Cadastro {
	
	public static Cliente cadastrarCliente() {
		Cliente cliente = new Cliente(Console.scanInt("Digite o rg: "), Console.scanString("Digite o nome: "),
				Console.scanString("Digite o numero de telefone: "));
		System.out.println("__________________");
		return cliente;
	}

	public static Aviao cadastrarAviao() {
		Aviao aviao = new Aviao(Console.scanString("Digite o ID do avião: "),
				Console.scanString("Digite o nome do avião: "), Console.scanInt("Digite a quantidade de assentos: "));
		System.out.println("__________________");
		return aviao;
	}

	public static Voo cadastrarVoo() {
		Voo voo = new Voo(Console.scanString("Digite o prefixo: "),Console.scanString("Digite a origem: "), Console.scanString("Digite o destino: "),
				DateFormater.localDate("Digite o horário de partida(dd/mm/aaaa): "), Seleciona.selecionaAviao());
		return voo;
	}
	public static Bilhete cadastrarVenda() {
		Bilhete bilhete = new Bilhete(localizador(6),Seleciona.selecionaCliente(),Seleciona.selecionaVoo());
		return bilhete;

	}
	private static Random rand = new Random();
	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
	public static String localizador (int nCaracteres) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i<nCaracteres; i++) {
	        int ch = rand.nextInt (letras.length);
	        sb.append (letras [ch]);
	    }    
	    return sb.toString();    
	}

}
