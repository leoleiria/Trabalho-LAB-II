package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;

public class AviaoDAO {
	
	public void create(Aviao a) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO aviao (nome, assentos) VALUES (?,?)");
			stmt.setString(1, a.getNome());
			stmt.setInt(2, a.getNroAssentos());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			ConnectionFactory.closeConnection(con,stmt);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
			ConnectionFactory.closeConnection(con,stmt);
		}		
	}
	
	public static void select() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("select * from aviao");
						
			
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				System.out.print("ID: " + resultado.getInt("id"));
				System.out.print(" // Nome: " + resultado.getString("nome"));
				System.out.print(" // Assentos: " + resultado.getInt("assentos"));
				System.out.println("");
			}
			System.out.println("");
			ConnectionFactory.closeConnection(con,stmt);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar: "+ex);
			ConnectionFactory.closeConnection(con,stmt);
		}		
	}
	
}
