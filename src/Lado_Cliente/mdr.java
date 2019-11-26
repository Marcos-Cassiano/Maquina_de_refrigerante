package Lado_Cliente;

import java.util.ArrayList;
import java.util.Scanner;

import Lado_Proprietario.Produto;
import Lado_Proprietario.Troco;

public class mdr {

	private static boolean vazia = true;
	private static Produto bebida1, bebida2, bebida3, bebida4, bebida5;
	private static Troco troco;
	private static ArrayList<Produto> bebidas, vendas;
	private static double dinheiroInserido = 0;
	
	public static void main(String[] args) {
		
		
		
		if(vazia == true) {
			troco = new Troco(5, 10, 20, 50, 100);
			bebida1 = new Produto("Coca-Cola", "2L", 7.50);
			bebida2 = new Produto("Fanta Laranja", "Lata 350ml", 3.50);
			bebida3 = new Produto("Balada Laranja", "2L", 4.00);
			bebida4 = new Produto("Guaraná Antartica", "2L", 7.00);
			bebida5 = new Produto("Coca-Cola", "1L", 5.00);
			
			bebidas = new ArrayList<>();
			bebidas.add(bebida1);
			bebidas.add(bebida2);
			bebidas.add(bebida3);
			bebidas.add(bebida4);
			bebidas.add(bebida5);
			
			vazia = false;
			
			efetuarCompra();
		}
		

	}

	private static void efetuarCompra() {
		
		System.out.println("Lista de bebidas:\n1-"+bebida1.toString()+"\n2-"+bebida2.toString()+"\n3-"+
		bebida3.toString()+"\n4-"+bebida4.toString()+"\n5-"+bebida5.toString()+"\n6-Cancelar\n");
		
		System.out.println("Digite o número do item que deseja comprar: \n");
		Scanner s = new Scanner(System.in);
		int ie = s.nextInt();
		if(bebidas.isEmpty()) {
			System.out.println("A máquina de refrigetrante está vazia por favor coloque mais bebidas\n");
			vazia = true;
		}else {	
		if(ie >= 1 && ie <= 5) {
			vendas = new ArrayList<>();
			Scanner s2 = new Scanner(System.in);
			System.out.println("Insira o dinheiro: \n");
			double valorInserido = s2.nextDouble();
			switch (ie) {
				case 1:
					if(bebidas.contains(bebida1)) {
						System.out.println("Seu troco é de: "+calcularTroco(valorInserido, bebida1.getPreco())+"0R$");
						bebidas.remove(bebida1);
						vendas.add(bebida1);
						dinheiroInserido += valorInserido;
						efetuarCompra();
					} else {
						System.out.println("Esgotado");
						efetuarCompra();
					}
				case 2:
					if(bebidas.contains(bebida2)) {
						System.out.println("Seu troco é de: "+calcularTroco(valorInserido, bebida2.getPreco())+"0R$");
						bebidas.remove(bebida2);
						vendas.add(bebida2);
						dinheiroInserido += valorInserido;
						efetuarCompra();
					} else {
						System.out.println("Esgotado");
						efetuarCompra();
					}
				case 3:
					if(bebidas.contains(bebida3)) {
						System.out.println("Seu troco é de: "+calcularTroco(valorInserido, bebida3.getPreco())+"0R$");
						bebidas.remove(bebida3);
						vendas.add(bebida3);
						dinheiroInserido += valorInserido;
						efetuarCompra();
					} else {
						System.out.println("Esgotado");
						efetuarCompra();
					}
				case 4:
					if(bebidas.contains(bebida4)) {
						System.out.println("Seu troco é de: "+calcularTroco(valorInserido, bebida4.getPreco())+"0R$");
						bebidas.remove(bebida4);
						vendas.add(bebida4);
						dinheiroInserido += valorInserido;
						efetuarCompra();
					} else {
						System.out.println("Esgotado");
						efetuarCompra();
					}
				case 5:
					if(bebidas.contains(bebida5)) {
						System.out.println("Seu troco é de: "+calcularTroco(valorInserido, bebida5.getPreco())+"0R$");
						bebidas.remove(bebida5);
						vendas.add(bebida5);
						dinheiroInserido += valorInserido;
						efetuarCompra();
					} else {
						System.out.println("Esgotado");
						efetuarCompra();
					}
				case 6:
					efetuarCompra();
				default:
					break;
			}
		} else if(ie == 0){
			System.out.println("Relatório de Vendas: \n");
			for(int i=0;i < vendas.size();i++) {
				System.out.println(vendas.get(i).toString()+"\n");
			}
			System.out.println("Produtos no estoque: \n");
			for(int j = 0; j < bebidas.size(); j++) {
				System.out.println(bebidas.get(j).getNome()+" \n");
			}
			efetuarCompra();
		}else {
			System.out.println("Número inválido");
		}
		}
		
	}
	
	private static double calcularTroco(double valorInserido, double valorProduto) {
		
		double Rtroco = valorInserido-valorProduto;
		double aux = Rtroco;
		while(Rtroco >= 10.0) {
			if(troco.getDezR() != 0) {
				troco.setDezR(troco.getDezR()-1);
				Rtroco-=10.0;	
			}else{
				break;
			}
		}
		while(Rtroco >= 5.0) {
			if(troco.getCincoR() != 0) {
				troco.setCincoR(troco.getCincoR()-1);
				Rtroco-=5.0;	
			}else{
				break;
			}
		}
		while(Rtroco >= 2.0) {
			if(troco.getDoisR() != 0) {
				troco.setDoisR(troco.getDoisR()-1);
				Rtroco-=2.0;	
			}else{
				break;
			}
		}
		while(Rtroco >= 1.0) {
			if(troco.getUmR() != 0) {
				troco.setUmR(troco.getUmR()-1);
				Rtroco-=1.0;	
			}else{
				break;
			}
		}
		while(Rtroco >= 0.5) {
			if(troco.getCinquentaC() != 0) {
				troco.setCinquentaC(troco.getCinquentaC()-1);
				Rtroco-=0.5;	
			}else{
				break;
			}
		}
		
		return aux;
		
	} 
	
	

}
