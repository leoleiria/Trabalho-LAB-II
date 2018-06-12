package control;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import model.*;
import view.Console;

public class altera {
	public static void AlterarCliente() {
		ClienteDAO.select();
			int id = Console.scanInt("Digite ID da pessoa desejada: ");
			String novonome = Console.scanString("Digite o novo nome desejado: ");
			int rg = Console.scanInt("Digite o novo rg desejado: ");
			String novotelefone = Console.scanString("Digite novo telefone desejado: ");
			Cliente c = new Cliente(rg, novonome, novotelefone);
			ClienteDAO dao = new ClienteDAO();
			dao.altera(c, id);
	}

	public static void AlterarAviao() {
		AviaoDAO.select();
		int id = Console.scanInt("Digite ID do aviao desejado: ");
		String nome = Console.scanString("Digite o novo nome desejado: ");
		int assentos = Console.scanInt("Digite o novo nr de assentos desejado: ");
		Aviao c = new Aviao(nome, assentos);
		AviaoDAO dao = new AviaoDAO();
		dao.altera(c, id);
	}

	public static void AlterarVoo() {
		VooDAO.select();
			int id = Console.scanInt("Digite ID do voo desejado: ");
			String novoprefixo = Console.scanString("Digite o novo prefixo desejado: ");
			String novaorigem = Console.scanString("Digite a nova origem desejado: ");
			String novodestino = Console.scanString("Digite o novo destino desejado: ");
			String novohorario = Console.scanString("Digite o novo horário de partida(hh:mm): ");
			AviaoDAO.select();
			int novoaviao = Console.scanInt("Digite o ID do novo avião: ");
			Voo c = new Voo(novoprefixo, novaorigem, novodestino, novohorario, novoaviao);
			VooDAO dao = new VooDAO();
			dao.altera(c, id);
	}
}
