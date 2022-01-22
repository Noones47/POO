package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Cadeira implements Serializable {
	private int codigo;
	private String nome;
	private ArrayList<Professor> professores;
	private double taxadeaprovacao;

	public Cadeira() {
		codigo = 0;
		nome = "";
		professores = new ArrayList<Professor>();
		taxadeaprovacao = 0;
	}

	public Cadeira(int newcodigo, String newnome, ArrayList<Professor> newprofessores, double newtaxadeaprovacao) {
		codigo = newcodigo;
		nome = newnome;
		professores = newprofessores;
		taxadeaprovacao = newtaxadeaprovacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(int newCodigo) {
		codigo = newCodigo;
	}

	public void setNome(String newNome) {
		nome = newNome;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}

	public double getTaxadeaprovacao() {
		return taxadeaprovacao;
	}

	public void setTaxadeaprovacao(double taxadeaprovacao) {
		this.taxadeaprovacao = taxadeaprovacao;
	}
	public Cadeira copia() {
		Cadeira copia = new Cadeira(this.codigo, this.nome, this.professores, this.taxadeaprovacao);
		return copia;
	}
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Cadeira ca = (Cadeira) obj;
			if (ca.getCodigo() == this.getCodigo() && ca.getNome().equals(this.getNome()) && ca.getProfessores().equals(this.getProfessores()) && ca.getTaxadeaprovacao() == this.getTaxadeaprovacao()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String cadeira = "Codigo: " + codigo + " | Nome: " + nome + " | Taxa de Aprovacao: " + taxadeaprovacao
				+ " | Professores: ";
		for (int i = 0; i < professores.size(); i++) {
			cadeira = cadeira + professores.get(i).getNome() + ", ";
		}
		cadeira = cadeira + "\n";
		return cadeira;
	}

}