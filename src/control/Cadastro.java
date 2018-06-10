package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
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
		System.out.println("Cadastro de Cliente:");
		do {
			rg = Console.scanInt("Digite o rg: ");
			nome = Console.scanString("Digite o nome: ");
			telefone = Console.scanString("Digite o numero de telefone: ");
		} while (nome.isEmpty() || telefone.isEmpty());
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "INSERT INTO cliente(rg,nomecliente,telefone) " + "VALUES ('" + rg + "','" + nome + "','"
					+ telefone + "')";
			conexao.createStatement().executeUpdate(sql);
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void cadastrarAviao() {
		String nome;
		int assentos;
		System.out.println("_______________________________");
		System.out.println("Cadastro de Avião:");
		do {
			nome = Console.scanString("Digite o nome: ");
			assentos = Console.scanInt("Digite a quantidade de assentos: ");
		} while (nome.isEmpty() || assentos == 0);
		
		Aviao a = new Aviao(nome, assentos);
		AviaoDAO dao = new AviaoDAO();
		dao.create(a);
	}
		
		
	public static void cadastrarVoo() {
		String prefixo, origem, destino;
		LocalTime horario;
		int idaviao;
		System.out.println("_______________________________");
		System.out.println("Cadastro de Voo:");
		do {
			prefixo = Console.scanString("Digite o prefixo do voo: ");
			origem = Console.scanString("Digite a origem: ");
			destino = Console.scanString("Digite o destino: ");
			horario = DateFormater.localTime("Digite o horário de partida(hh:mm): ");
			idaviao = Console.scanInt("Digite o id do avião desejado: ");
		} while (prefixo.isEmpty() || origem.isEmpty() || destino.isEmpty());
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "INSERT INTO voo(prefixo, origem, destino, horario, aviao) " + "VALUES ('" + prefixo + "','"
					+ origem + "','" + destino + "','" + horario + "','" + idaviao + "')";
			conexao.createStatement().executeUpdate(sql);
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

//	public static Bilhete cadastrarVenda() {
//		System.out.println("_______________________________");
//		System.out.println("Emissão de Bilhete:");
//		Bilhete bilhete;
//		do {
//			bilhete = new Bilhete(localizador(6), Seleciona.selecionaCliente(), Seleciona.selecionaVoo(),
//					DateFormater.localDateTime());
//		} while (ConsultaDuplicidade.bilhete(bilhete) == false);
//		bilhete.getVoo().getAviao().setNroAssentos((bilhete.getVoo().getAviao().getNroAssentos()) - 1);
//		return bilhete;
//
//	}

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