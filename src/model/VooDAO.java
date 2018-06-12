package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;

public class VooDAO {
		public void create(Voo v) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
		
			
			try {
				stmt = con.prepareStatement("INSERT INTO voo(prefixo, origem, destino, horario, aviao) VALUES (?,?,?,?,?)");
				stmt.setString(1, v.getPrefixo());
				stmt.setString(2, v.getOrigem());
				stmt.setString(3, v.getDestino());			
				stmt.setTime(4, Time.valueOf(v.getTime()));
				stmt.setInt(5, v.getAviao());
				
				
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
				
			} finally {
				ConnectionFactory.closeConnection(con,stmt);
			} 
		
		}
		
		public static void select() {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("select voo.*, aviao.nome from voo, aviao\r\n" + 
						"where voo.aviao=aviao.id");
							
				
				ResultSet resultado = stmt.executeQuery();
				while (resultado.next()) {
					System.out.print("ID: " + resultado.getInt("id"));
					System.out.print(" // Prefixo: " + resultado.getString("prefixo"));
					System.out.print(" // Origem: " + resultado.getInt("origem"));
					System.out.print(" // Destino: " + resultado.getInt("destino"));
					System.out.print(" // Hora: " + resultado.getInt("horario"));
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
