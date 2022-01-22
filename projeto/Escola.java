package projeto;

public class Escola {
	private String nome;
	private String local;

	public Escola(String newnome, String newlocal) {
		nome = newnome;
		local = newlocal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}