package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Logger;

import model.*;
import view.Console;

public class Cadastro {

	public static void cadastrarCliente() {
		int rg;
		String nome;
		String telefone;
		System.out.println("_______________________________");
		System.out.println("Cadstro de Cliente:");
		do {
			rg = Console.scanInt("Digite o rg: ");
			nome = Console.scanString("Digite o nome: ");
			telefone = Console.scanString("Digite o numero de telefone: ");
		} while (nome.isEmpty() || telefone.isEmpty());
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "INSERT INTO cliente(rg,nomecliente,telefone) " + "VALUES ('" + rg + "','" + nome + "','" + telefone
					+ "')";
			Statement comando = conexao.createStatement();
			int numLinhas = comando.executeUpdate(sql);
			System.out.println("Numero de Linhas: " + numLinhas);
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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
		bilhete.getVoo().getAviao().setNroAssentos((bilhete.getVoo().getAviao().getNroAssentos()) - 1);
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