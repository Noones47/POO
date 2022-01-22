package projeto;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FuncAdd {

	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	public static ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
	public static ArrayList<Professor> professores = new ArrayList<Professor>();
	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static boolean voltar = true;

	public static void GUARDARFILES() {
		File ficheiroscursos = new File("cursos.dat");
		try {

			FileOutputStream FOficheirocursos = new FileOutputStream(ficheiroscursos);
			ObjectOutputStream OOficheirocursos = new ObjectOutputStream(FOficheirocursos);

			// ObjectOutputStream OOficheirocursos = new ObjectOutputStream(new
			// FileOutputStream(new File("cursos.dat")));

			OOficheirocursos.writeObject(cursos);
			OOficheirocursos.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// -------------------
		// guardar cadeiras
		File ficheiroscadeiras = new File("cadeiras.dat");
		try {

			FileOutputStream FOficheirocadeira = new FileOutputStream(ficheiroscadeiras);
			ObjectOutputStream OOficheirocadeira = new ObjectOutputStream(FOficheirocadeira);

			// ObjectOutputStream OOficheirocursos = new ObjectOutputStream(new
			// FileOutputStream(new File("cursos.dat")));

			OOficheirocadeira.writeObject(cadeiras);
			OOficheirocadeira.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// -------------------------
		// guardar professores
		File ficheirosprofessores = new File("professores.dat");
		try {

			FileOutputStream FOficheiroprofessor = new FileOutputStream(ficheirosprofessores);
			ObjectOutputStream OOficheiroprofessor = new ObjectOutputStream(FOficheiroprofessor);

			// ObjectOutputStream OOficheirocursos = new ObjectOutputStream(new
			// FileOutputStream(new File("cursos.dat")));
			OOficheiroprofessor.writeInt(Professor.getUltimop());
			OOficheiroprofessor.writeObject(professores);
			OOficheiroprofessor.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// -------------------------
		// guardar alunos
		File ficheirosalunos = new File("alunos.dat");
		try {

			FileOutputStream FOficheiroaluno = new FileOutputStream(ficheirosalunos);
			ObjectOutputStream OOficheiroaluno = new ObjectOutputStream(FOficheiroaluno);

			// ObjectOutputStream OOficheirocursos = new ObjectOutputStream(new
			// FileOutputStream(new File("cursos.dat")));
			OOficheiroaluno.writeInt(Aluno.getUltimoa());
			OOficheiroaluno.writeObject(alunos);
			OOficheiroaluno.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// -------------------------
	}

	public static void BUSCARFILES() {
		// FICHEIRO CURSO-------------------

		try {
			File ficheiroteste = new File("cursos.dat");
			FileInputStream FOteste = new FileInputStream(ficheiroteste);
			ObjectInputStream ObjectIs = new ObjectInputStream(FOteste);

			cursos = (ArrayList<Curso>) ObjectIs.readObject();
			ObjectIs.close();
		} catch (IOException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não existente - " + e.getMessage());
		}

		// -----------------------------------

		// FICHEIRO PROFESSORES---------------

		try {
			File ficheiroteste = new File("professores.dat");
			FileInputStream FOteste = new FileInputStream(ficheiroteste);
			ObjectInputStream ObjectIs = new ObjectInputStream(FOteste);

			int ultp = ObjectIs.readInt();
			Professor.setUltimop(ultp);
			professores = (ArrayList<Professor>) ObjectIs.readObject();
			ObjectIs.close();
		} catch (IOException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não existente - " + e.getMessage());
		}
		// -------------------------------------
		// FICHEIRO ALUNOS----------------------

		try {
			File ficheiroteste = new File("alunos.dat");
			FileInputStream FOteste = new FileInputStream(ficheiroteste);
			ObjectInputStream ObjectIs = new ObjectInputStream(FOteste);

			int ulta = ObjectIs.readInt();
			Aluno.setUltimoa(ulta);
			alunos = (ArrayList<Aluno>) ObjectIs.readObject();
			ObjectIs.close();
		} catch (IOException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não existente - " + e.getMessage());
		}
		// -------------------------------------
		// FICHEIRO CADEIRA----------------------
		try {
			File ficheiroteste = new File("cadeiras.dat");
			FileInputStream FOteste = new FileInputStream(ficheiroteste);
			ObjectInputStream ObjectIs = new ObjectInputStream(FOteste);
			cadeiras = (ArrayList<Cadeira>) ObjectIs.readObject();
			ObjectIs.close();
		} catch (IOException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não existente - " + e.getMessage());
		}
		// -------------------------------------
	}

	public static void ALUNO() {
		BUSCARFILES();
		Aluno a = new Aluno();

		String nomealuno = JOptionPane.showInputDialog("Nome do aluno: ");
		a.setNome(nomealuno);

		String idadealuno = JOptionPane.showInputDialog(null, "Idade do aluno: ");
		int idade = Integer.parseInt(idadealuno);
		a.setIdade(idade);

		String mediaaluno = JOptionPane.showInputDialog(null, "Média do aluno: ");
		double media = Double.parseDouble(mediaaluno);
		a.setMedia(media);

		String localidadealuno = JOptionPane.showInputDialog("Localidade do aluno: ");
		a.setLocalidade(localidadealuno);

		String cursosmostrar = "Lista de Cursos\n------------------\n";
		for (int i = 0; i < cursos.size(); i++) {
			cursosmostrar = cursosmostrar + "Nome: " + cursos.get(i).getNome() + "\nNúmero: "
					+ cursos.get(i).getCodigo() + "\n\n";
			System.out.println(cursos.get(i).getNome());
		}
		cursosmostrar = cursosmostrar + "Da lista de cursos, escolha um nome: ";
		String escolha = JOptionPane.showInputDialog(cursosmostrar);

		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getNome().equals(escolha)) {
				a.setCurso(cursos.get(i));

			}
		}
		alunos.add(a);
		GUARDARFILES();
	}

	public static void PROF() {

		BUSCARFILES();
		Professor p = new Professor();

		String nomeprof = JOptionPane.showInputDialog("Nome do professor: ");
		p.setNome(nomeprof);

		String idadeprof = JOptionPane.showInputDialog(null, "Idade do professor: ");
		int idade = Integer.parseInt(idadeprof);
		p.setIdade(idade);

		String salarioprof = JOptionPane.showInputDialog(null, "Salário do professor: ");
		double salario = Double.parseDouble(salarioprof);
		p.setSalario(salario);

		String moradaprof = JOptionPane.showInputDialog("Morada do professor: ");
		p.setMorada(moradaprof);

		professores.add(p);
		GUARDARFILES();
	}

	public static void CURSO() {

		BUSCARFILES();
		Curso c = new Curso();

		String nomecurso = JOptionPane.showInputDialog("Nome do curso: ");
		c.setNome(nomecurso);

		String codcurso = JOptionPane.showInputDialog(null, "Código do curso: ");
		int codigo = Integer.parseInt(codcurso);
		c.setCodigo(codigo);

		String horascurso = JOptionPane.showInputDialog(null, "Horas do curso: ");
		int horas = Integer.parseInt(horascurso);
		c.setHoras(horas);

		String regentecurso = JOptionPane.showInputDialog("Regente do curso: ");
		c.setRegente(regentecurso);

		String propinascurso = JOptionPane.showInputDialog(null, "Propinas do curso: ");
		double propinas = Double.parseDouble(propinascurso);
		c.setPropinas(propinas);

		ArrayList<Cadeira> cadeirasnull = new ArrayList<Cadeira>();
		c.setCadeiras(cadeirasnull);

		cursos.add(c);
		GUARDARFILES();
	}

	public static void CADEIRAS() {
		BUSCARFILES();
		Cadeira cads = new Cadeira();

		String nomecadeiras = JOptionPane.showInputDialog("Nome do cadeiras: ");
		cads.setNome(nomecadeiras);

		String codigocadeira = JOptionPane.showInputDialog(null, "Codigo da cadeira: ");
		int codigo = Integer.parseInt(codigocadeira);
		cads.setCodigo(codigo);

		ArrayList<Professor> professoresnull = new ArrayList<Professor>();
		cads.setProfessores(professoresnull);
		cads.setTaxadeaprovacao(0.0);

		cadeiras.add(cads);
		GUARDARFILES();
	}
}