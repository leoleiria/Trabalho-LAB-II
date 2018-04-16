import java.util.Random;

import Model.Aviao;
import Model.Bilhete;
import Model.Cliente;
import Model.Voo;
import View.Console;

public class Seleciona {
	static Aviao selecionaAviao() {
		System.out.println("Selecione o número do avião desejado: ");
		for(int i=0;i<SistemaDeVendas.vAviao.length;i++) {
			if(SistemaDeVendas.vAviao[0] == null) {
// Arrumar essa exception				
				System.out.println("Não existem Aviões Cadastrados"
						+ "\n acabou o Programa!");
				System.exit(0);
				
			}else if(SistemaDeVendas.vAviao[i] != null) {
				System.out.println(i+". "+SistemaDeVendas.vAviao[i].getNome());	
			}
		}
		int selecao = Console.scanInt("...");
		Aviao aviao = SistemaDeVendas.vAviao[selecao];
		return aviao;
	}

	
	static Cliente selecionaCliente() {
		System.out.println("Selecione o Cliente desejado: ");
		for(int i=0;i<SistemaDeVendas.vCliente.length;i++) {
			if(SistemaDeVendas.vCliente[0] == null) {
// Arrumar essa exception				
				System.out.println("Não existem Cliente Cadastrados"
						+ "\n acabou o Programa!");
				System.exit(0);
				
			}else if(SistemaDeVendas.vCliente[i] != null) {
				System.out.println(i+". "+SistemaDeVendas.vCliente[i].getNome());	
			}
		}
		int selecao = Console.scanInt("...");
		return SistemaDeVendas.vCliente[selecao];
	}
	
	static Voo selecionaVoo() {
		System.out.println("Selecione o número do vôo desejado: ");
		for(int i=0;i<SistemaDeVendas.vVoo.length;i++) {
			if(SistemaDeVendas.vVoo[0] == null) {
// Arrumar essa exception				
				System.out.println("Não existem Vôo Cadastrados"
						+ "\n acabou o Programa!");
				System.exit(0);
				
			}else if(SistemaDeVendas.vVoo[i] != null) {
				System.out.println(i+". "+SistemaDeVendas.vVoo[i]);	
			}
		}
		int selecao = Console.scanInt("...");
		return  SistemaDeVendas.vVoo[selecao];
	}

}
