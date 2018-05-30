package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sistemaDeVendas.SistemaDeVendas;

public class consulta {
	public static void ConsultaCliente() {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho01LB2",
					"postgres", "admin");
			String sql = "SELECT * FROM cliente";
	         PreparedStatement comando = conexao.prepareStatement(sql);
	         
	         ResultSet resultado = comando.executeQuery();
	         while(resultado.next()){
	             System.out.print("ID: "+resultado.getInt("id"));
	             System.out.print(" // RG: "+resultado.getString("rg"));
	             System.out.print(" // Nome: "+resultado.getString("nomecliente"));
	             System.out.println(" // Telefone: "+resultado.getString("telefone"));
	         }
	         
			conexao.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
	}
	public static void ConsultaAviao() {
		for(int i=0;i<SistemaDeVendas.contAvi; i++) {
			if(SistemaDeVendas.vAviao[i] != null){
				System.out.println(SistemaDeVendas.vAviao[i].getId()+". "+SistemaDeVendas.vAviao[i]);
			}
		}
	}
	
	public static void ConsultaVoo() {
		for(int i=0;i<SistemaDeVendas.contVoo; i++) {
			if(SistemaDeVendas.vVoo[i] != null) {
				System.out.println(SistemaDeVendas.vVoo[i]);
			}
		}
	}
	
	public static void ConsultaBilhete() {
		for(int i=0;i<SistemaDeVendas.contBil; i++) {
			if(SistemaDeVendas.vBilhete[i] != null) {
				System.out.println(SistemaDeVendas.vBilhete[i]);
			}
		}
	}

}
