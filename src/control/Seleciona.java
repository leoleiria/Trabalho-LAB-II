package control;

import java.util.Random;

import model.Aviao;
import model.Bilhete;
import model.Cliente;
import model.Voo;
import sistemaDeVendas.SistemaDeVendas;
import view.Console;

public class Seleciona {
	static Aviao selecionaAviao() {
		System.out.println("Selecione o número do avião desejado: ");
		for (int i = 0; i < SistemaDeVendas.vAviao.length; i++) {
			if (SistemaDeVendas.vAviao[0] == null) {
				// Arrumar essa exception
				System.out.println("Não existem Aviões Cadastrados" + "\n acabou o Programa!");
				System.exit(0);

			} else if (SistemaDeVendas.vAviao[i] != null) {
				System.out.println(i + ". " + SistemaDeVendas.vAviao[i].getNome());
			}
		}
		int selecao = Console.scanInt("...");
		Aviao aviao = SistemaDeVendas.vAviao[selecao];
		return aviao;
	}

	static Cliente selecionaCliente() {
		System.out.println("Selecione o Cliente desejado: ");
		for (int i = 0; i < SistemaDeVendas.vCliente.length; i++) {
			if (SistemaDeVendas.vCliente[0] == null) {
				// Arrumar essa exception
				System.out.println("Não existem Cliente Cadastrados" + "\n acabou o Programa!");
				System.exit(0);

			} else if (SistemaDeVendas.vCliente[i] != null) {
				System.out.println(i + ". " + SistemaDeVendas.vCliente[i].getNome());
			}
		}
		int selecao = Console.scanInt("...");
		return SistemaDeVendas.vCliente[selecao];
	}

	static Voo selecionaVoo() {
		boolean testeAssentos = true;
		int selecao;
		do {
			System.out.println("Selecione o número do vôo desejado: ");
			for (int i = 0; i < SistemaDeVendas.vVoo.length; i++) {

				if (SistemaDeVendas.vVoo[0] == null) {
					// Arrumar essa exception
					System.out.println("Não existem Vôo Cadastrados" + "\n acabou o Programa!");
					System.exit(0);

				} else if (SistemaDeVendas.vVoo[i] != null) {
					System.out.println(i + ". " + SistemaDeVendas.vVoo[i]);
				}
			}
			selecao = Console.scanInt("...");
			if (SistemaDeVendas.vVoo[selecao].getAviao().getNroAssentos() < 1) {
				System.out.println("Vôo não disponivel para reserva!");
			} else {
				testeAssentos = false;
			}
		} while (testeAssentos == true);
		return SistemaDeVendas.vVoo[selecao];

	}

}
