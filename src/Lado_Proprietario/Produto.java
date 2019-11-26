package Lado_Proprietario;

public class Produto {
	
	private String nome, tipo;
	private double preco;
	
	public Produto(String nome, String tipo, double preco) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return getNome()+" - "+getTipo()+" - "+getPreco()+"0R$";
	}
	
	

}
