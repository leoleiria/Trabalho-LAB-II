package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AviaoDAO;
import model.BilheteDAO;
import model.Cliente;
import model.ClienteDAO;
import model.VooDAO;
import view.Console;

public class deleta {
	public static void DeletarCliente() {
		ClienteDAO.select();
		int id = Console.scanInt("Digite ID da pessoa desejada: ");
		System.out.println("Deletar esse cliente?\n[1] Sim\n[2] Não");
		int resposta = Console.scanInt("Opção > ");
		if (resposta == 1) {
			ClienteDAO.deleta(id);
		}
	}

	public static void DeletarAviao() {
		AviaoDAO.select();
		int id = Console.scanInt("Digite ID do aviao desejado: ");
		System.out.println("Deletar esse aviao?\n[1] Sim\n[2] Não");
		int resposta = Console.scanInt("Opção > ");
		if (resposta == 1) {
			AviaoDAO.deleta(id);
		}
	}

	public static void DeletarVoo() {
		VooDAO.select();
		int id = Console.scanInt("Digite ID do voo desejado: ");
		System.out.println("Deletar esse voo?\n[1] Sim\n[2] Não");
		int resposta = Console.scanInt("Opção > ");
		if (resposta == 1) {
			VooDAO.deleta(id);
		}
	}	public static void DeletarBilhete() {
		BilheteDAO.select();
		int id = Console.scanInt("Digite ID do voo desejado: ");
		System.out.println("Deletar esse bilhete?\n[1] Sim\n[2] Não");
		int resposta = Console.scanInt("Opção > ");
		if (resposta == 1) {
			BilheteDAO.deleta(id);
		}
	}
}
