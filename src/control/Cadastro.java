package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
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
		Cliente c = new Cliente(rg, nome, telefone);
		ClienteDAO dao = new ClienteDAO();
		dao.create(c);
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
		String horario;
		int idaviao;
		System.out.println("_______________________________");
		System.out.println("Cadastro de Voo:");
		do {
			prefixo = Console.scanString("Digite o prefixo do voo: ");
			origem = Console.scanString("Digite a origem: ");
			destino = Console.scanString("Digite o destino: ");
			horario = Console.scanString("Digite o horário de partida(hh:mm): ");
			Consulta.ConsultaAviao();
			idaviao = Console.scanInt("Digite o id do avião desejado: ");			
		} while (prefixo.isEmpty() || origem.isEmpty() || destino.isEmpty());
		
		Voo v = new Voo( prefixo, origem, destino, horario, idaviao);
		VooDAO dao = new VooDAO();
		dao.create(v);
		
	}

	public static void cadastrarVenda() {
		System.out.println("_______________________________");
		System.out.println("Emissão de Bilhete:");
		String localizador;
		int cliente;
		int voo;
		String dataHora;
		
		do {
			localizador = localizador(6);
			Consulta.ConsultaCliente();
			cliente = Console.scanInt("Digite o ID do cliente: ");
			Consulta.ConsultaVoo();
			voo = Console.scanInt("Digite o ID do Vôo: ");
			dataHora = LocalDate.now().toString();
		} while (cliente==0 || voo==0);
		
		Bilhete b = new Bilhete(localizador,cliente, voo,dataHora);
		BilheteDAO dao = new BilheteDAO();
		dao.create(b);

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