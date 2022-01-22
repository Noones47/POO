package projeto;

import java.io.Serializable;

public class Professor implements Serializable {
	private static int ultimop = 1;
	private String nome;
	private String numero;
	private int idade;
	private double salario;
	private String morada;

	public Professor() {
		nome = "";
		numero = "";
		numero += ultimop;
		ultimop++;
		idade = 0;
		salario = 0;
		morada = "";
	}

	public Professor(String newnome, int newidade, double newsalario, String newmorada) {
		nome = newnome;
		numero = "p";
		numero += ultimop;
		ultimop++;
		idade = newidade;
		salario = newsalario;
		morada = newmorada;
	}

	public static int getUltimop() {
		return ultimop;
	}

	public static void setUltimop(int ultimop) {
		Professor.ultimop = ultimop;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public Professor clone() {
		Professor copia = new Professor(this.nome, this.idade, this.salario, this.morada);
		return copia;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Professor p = (Professor) obj;
			if (p.getIdade() == this.getIdade() && p.getMorada().equals(this.getMorada())
					&& p.getNome().equals(this.getNome()) && p.getNumero().equals(this.getNumero())
					&& p.getSalario() == this.getSalario()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return "Nome: " + nome + " | Número: " + numero + " | Idade: " + idade + " | Salário: " + salario
				+ " | Morada: " + morada + "\n";
	}

}