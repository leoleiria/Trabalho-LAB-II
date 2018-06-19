package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AviaoDAO;
import model.BilheteDAO;
import model.ClienteDAO;
import model.VooDAO;
import sistemaDeVendas.SistemaDeVendas;

public class Consulta {
	public static void ConsultaCliente() {
		System.out.println("Consulta Clientes:");
		ClienteDAO.select();
	}

	public static void ConsultaAviao() {
		System.out.println("Consulta Avião:");
		AviaoDAO.select();
	}

	public static void ConsultaVoo() {
		System.out.println("Consulta Vôo:");
		VooDAO.select();
	}

	public static void ConsultaBilhete() {
		System.out.println("Consulta Bilhetes:");
		BilheteDAO consulta = new BilheteDAO();
		consulta.select();
		}
}
