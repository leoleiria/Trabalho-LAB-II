import Model.Cliente;

public class ConsultaCliente {
	public static void ListaTodos() {
		System.out.println("Nome: "+Cliente.getNome() + " RG: "+Cliente.getRg() +" Telefone: "+ Cliente.getTelefone());
	}
}
