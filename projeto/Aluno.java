package projeto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Aluno implements Serializable {
	private static int ultimoa = 1;
	private String numero;
	private String nome;
	private Curso curso;
	private int idade;
	private double media;
	private String localidade;

	public Aluno() {
		nome = "";
		numero = "a";
		numero += ultimoa;
		ultimoa++;
		curso = new Curso();
		idade = 0;
		media = 0;
		localidade = "";
	}

	public Aluno(String newnome, Curso newcurso, int newidade, int newmedia, String newlocalidade) {
		nome = newnome;
		numero = "a";
		numero += ultimoa;
		ultimoa++;
		curso = newcurso;
		idade = newidade;
		media = newmedia;
		localidade = newlocalidade;
	}

	public static int getUltimoa() {
		return ultimoa;
	}

	public static void setUltimoa(int ultimoa) {
		Aluno.ultimoa = ultimoa;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Aluno clone() {
		Aluno copia = new Aluno(this.nome, this.curso, this.idade, this.idade, this.localidade);
		return copia;
	}

	public boolean equals(Object obj) {

		if (obj != null && obj.getClass() == this.getClass()) {
			Aluno a = (Aluno) obj;
			if (a.getNumero().equals(getNumero()) && a.getIdade() == this.getIdade()
					&& a.getLocalidade().equals(this.getLocalidade()) && a.getMedia() == this.getMedia()
					&& a.getNome().equals(this.getNome()) && a.getCurso().equals(this.getCurso())) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return "Numero: " + numero + " | Nome: " + nome + " | Curso: " + curso.getNome() + " | Idade: " + idade
				+ " | Média: " + media + "\n";

	}

}