package control;

import sistemaDeVendas.SistemaDeVendas;

public class consulta {
	public static void ConsultaCliente() {
		for(int i=0;i<SistemaDeVendas.contCli; i++) {
			if(SistemaDeVendas.vCliente[i] != null) {
				System.out.println(i+". "+SistemaDeVendas.vCliente[i]);
			}
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
