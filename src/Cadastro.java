
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
				DateFormater.localDate("Digite o horário de partida(dd/mm/aaaa): "), selecionaAviao());
		return voo;
	}

	private static Aviao selecionaAviao() {
		System.out.println("Selecione o número do avião desejado: ");
		for(int i=0;i<SistemaDeVendas.vAviao.length;i++) {
			if(SistemaDeVendas.vAviao[0] == null) {
// Arrumar essa exception				
				System.out.println("Não existem Aviões Cadastrados"
						+ "\n acabou o Programa!");
				System.exit(0);
				
			}else if(SistemaDeVendas.vAviao[i] != null) {
				System.out.println(i+". "+SistemaDeVendas.vAviao[i].getNome());	
			}
		}
		int selecao = Console.scanInt("...");
		Aviao aviao = SistemaDeVendas.vAviao[selecao];
		return aviao;
	}

	public static Bilhete cadastrarVenda() {
		Bilhete bilhete = new Bilhete(localizador(6),selecionaCliente(),selecionaVoo());
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
	
	private static Cliente selecionaCliente() {
		System.out.println("Selecione o Cliente desejado: ");
		for(int i=0;i<SistemaDeVendas.vCliente.length;i++) {
			if(SistemaDeVendas.vCliente[0] == null) {
// Arrumar essa exception				
				System.out.println("Não existem Cliente Cadastrados"
						+ "\n acabou o Programa!");
				System.exit(0);
				
			}else if(SistemaDeVendas.vCliente[i] != null) {
				System.out.println(i+". "+SistemaDeVendas.vCliente[i].getNome());	
			}
		}
		int selecao = Console.scanInt("...");
		return SistemaDeVendas.vCliente[selecao];
	}
	
	private static Voo selecionaVoo() {
		System.out.println("Selecione o número do vôo desejado: ");
		for(int i=0;i<SistemaDeVendas.vVoo.length;i++) {
			if(SistemaDeVendas.vVoo[0] == null) {
// Arrumar essa exception				
				System.out.println("Não existem Vôo Cadastrados"
						+ "\n acabou o Programa!");
				System.exit(0);
				
			}else if(SistemaDeVendas.vVoo[i] != null) {
				System.out.println(i+". "+SistemaDeVendas.vVoo[i]);	
			}
		}
		int selecao = Console.scanInt("...");
		return  SistemaDeVendas.vVoo[selecao];
	}

}
