package control;

import java.util.Random;

import model.*;
import view.Console;

public class Cadastro {

	public static Cliente cadastrarCliente() {
		System.out.println("_______________________________");
		System.out.println("Cadstro de Cliente:");
		Cliente cliente;
		do {
			do {
				cliente = new Cliente(Console.scanInt("Digite o rg: "), Console.scanString("Digite o nome: "),
					Console.scanString("Digite o numero de telefone: "));
			}while (cliente.getNome().isEmpty() || cliente.getTelefone().isEmpty());
		} while (ConsultaDuplicidade.cliente(cliente) == false);
		return cliente;
	}

	public static Aviao cadastrarAviao() {
		System.out.println("_______________________________");
		System.out.println("Cadstro de Avião:");
		Aviao aviao;
		do {
			aviao = new Aviao(Console.scanString("Digite o ID do avião: "),
					Console.scanString("Digite o nome do avião: "),
					Console.scanInt("Digite a quantidade de assentos: "));
		} while (ConsultaDuplicidade.aviao(aviao) == false);
		return aviao;
	}

	public static Voo cadastrarVoo() {
		System.out.println("_______________________________");
		System.out.println("Cadstro de Vôo:");
		Voo voo;
		do {
			voo = new Voo(Console.scanString("Digite o prefixo: "), Console.scanString("Digite a origem: "),
					Console.scanString("Digite o destino: "),
					DateFormater.localTime("Digite o horário de partida(hh:mm): "), Seleciona.selecionaAviao());
		} while (ConsultaDuplicidade.voo(voo) == false || voo.getData() == null);

		return voo;
	}

	public static Bilhete cadastrarVenda() {
		System.out.println("_______________________________");
		System.out.println("Emissão de Bilhete:");
		Bilhete bilhete;
		do {
			bilhete = new Bilhete(localizador(6), Seleciona.selecionaCliente(), Seleciona.selecionaVoo(),
					DateFormater.localDateTime());
		} while (ConsultaDuplicidade.bilhete(bilhete) == false);
	bilhete.getVoo().getAviao().setNroAssentos((bilhete.getVoo().getAviao().getNroAssentos())-1);
		return bilhete;

	}

	private static Random rand = new Random();
	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();

	public static String localizador(int nCaracteres) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nCaracteres; i++) {
			int ch = rand.nextInt(letras.length);
			sb.append(letras[ch]);
		}
		return sb.toString();
	}

}