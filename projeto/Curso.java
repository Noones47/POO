package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Curso implements Serializable {
	private String nome;
	private int codigo;
	private int horas;
	private String regente;
	private ArrayList<Cadeira> cadeiras;
	private double propinas;

	public Curso() {
		nome = "";
		codigo = 0;
		horas = 0;
		regente = "";
		cadeiras = new ArrayList<Cadeira>();
		propinas = 0.0;
	}

	public Curso(String newnome, int newcodigo, int newhoras, String newregente, ArrayList<Cadeira> newcadeiras,
			double newpropinas) {
		nome = newnome;
		codigo = newcodigo;
		horas = newhoras;
		regente = newregente;
		cadeiras = newcadeiras;
		propinas = newpropinas;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getRegente() {
		return regente;
	}

	public void setRegente(String regente) {
		this.regente = regente;
	}

	public double getPropinas() {
		return propinas;
	}

	public void setPropinas(double propinas) {
		this.propinas = propinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Cadeira> getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(ArrayList<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}

	public Curso clone() {
		Curso copia = new Curso(this.nome, this.codigo, this.horas, this.regente, this.cadeiras, this.propinas);
		return copia;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Curso c = (Curso) obj;
			if (c.getCodigo() == this.getCodigo() && c.getHoras() == this.getHoras() && c.getNome().equals(this.getNome()) && c.getPropinas() == this.getPropinas() && c.getRegente().equals(this.getRegente()) && c.getCadeiras().equals(this.getCadeiras())){
				return true;
			}
		}
		return false;
	}
	public double MaiorAprov() {
		double maiortaxa = 0.0;
		for (int i = 0; i < cadeiras.size(); i++) {
			if (cadeiras.get(i).getTaxadeaprovacao() > maiortaxa) {
				maiortaxa = maiortaxa + cadeiras.get(i).getTaxadeaprovacao();
			}
		}
		maiortaxa = maiortaxa / (cadeiras.size() - 1);
		return maiortaxa;
	}

	public String toString() {
		String curso = "Nome: " + nome + " | Codigo: " + codigo + " | Horas: " + horas + " | Regente: " + regente
				+ " | Propinas: " + propinas + " | Cadeiras: ";
		for (int i = 0; i < cadeiras.size(); i++) {
			curso = curso + cadeiras.get(i).getNome() + ", ";
		}
		curso = curso + "\n";
		return curso;
	}

}