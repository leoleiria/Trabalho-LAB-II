package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
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
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "INSERT INTO aviao(nome, assentos) " + "VALUES ('" + nome + "','" + assentos + "')";
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
			consulta.ConsultaAviao();
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

	public static void cadastrarVenda() {
		String localizadorFinal;
		int cliente;
		int voo;
		LocalDateTime dataHora;
		System.out.println("_______________________________");
		System.out.println("Venda de Bilhete:");
	do {	localizadorFinal = localizador(6);
		consulta.ConsultaCliente();
		cliente = Console.scanInt("Digite o ID do cliente:");
		consulta.ConsultaVoo();
		voo = Console.scanInt("Digite o Id o Voo");
		dataHora = DateFormater.localDateTime().now();
	}while(cliente ==0 || voo == 0);
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "INSERT INTO bilhete(localizador, idcliente, idvoo, horacompra) " + "VALUES ('" + localizadorFinal + "','"
					+ cliente + "','" + voo + "','" + dataHora +"')";
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