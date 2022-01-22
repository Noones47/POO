package projeto;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncMod {

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
		// guardar professores
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

	public static void REPOR() {
		BUSCARFILES();

		// cadeiras
		ArrayList<Cadeira> cadeirastemp = cadeiras;
		for (int i = 0; i < cadeirastemp.size(); i++) {
			ArrayList<Professor> tempprof = cadeirastemp.get(i).getProfessores();
			ArrayList<Integer> exprof = new ArrayList<Integer>();
			for (int k = 0; k < professores.size(); k++) {
				int ex = 0;
				for (int j = 0; j < tempprof.size(); j++) {
					if (tempprof.get(j).getNumero().equals(professores.get(k).getNumero())) {
						ex = ex + 1;
					}
				}
				exprof.add(ex);
			}
			ArrayList<Professor> tempprof2 = new ArrayList<Professor>();
			for (int j = 0; j < professores.size(); j++) {
				if (exprof.get(j) != 0) {
					tempprof2.add(professores.get(j));
				}
			}
			int cadeiratemounao = 0;
			for (int j = 0; j < exprof.size(); j++) {
				if (exprof.get(j) != 0) {
					cadeiratemounao = 1;
				}
			}
			if (cadeiratemounao == 1) {
				cadeirastemp.get(i).setProfessores(tempprof2);
			}
		}
		cadeiras = cadeirastemp;
		// cursos
		ArrayList<Curso> cursostemp = cursos;
		for (int i = 0; i < cursos.size(); i++) {
			ArrayList<Cadeira> tempcadeiras = cursos.get(i).getCadeiras();
			ArrayList<Integer> excadeiras = new ArrayList<Integer>();

			for (int k = 0; k < cadeiras.size(); k++) {
				int ex = 0;
				for (int j = 0; j < tempcadeiras.size(); j++) {
					if (tempcadeiras.get(j).getCodigo() == cadeiras.get(k).getCodigo()) {
						ex = ex + 1;
					}
				}
				excadeiras.add(ex);
			}
			ArrayList<Cadeira> tempcadeiras2 = new ArrayList<Cadeira>();
			for (int j = 0; j < cadeiras.size(); j++) {
				if (excadeiras.get(j) != 0) {
					tempcadeiras2.add(cadeiras.get(j));
				}
			}
			int cursotemounao = 0;
			for (int j = 0; j < excadeiras.size(); j++) {
				if (excadeiras.get(j) != 0) {
					cursotemounao = 1;
				}
			}
			if (cursotemounao == 1) {
				cursostemp.get(i).setCadeiras(tempcadeiras2);
			}
		}
		cursos = cursostemp;

		// alunos

		ArrayList<Aluno> alunostemp = alunos;

		for (int i = 0; i < alunos.size(); i++) {
			Curso tempcurso = alunos.get(i).getCurso();
			int excurso = 0;
			for (int j = 0; j < cursos.size(); j++) {
				int ex = 0;
				if (tempcurso.getCodigo() == cursos.get(j).getCodigo()) {
					ex = ex + 1;
				}
				excurso = ex;
			}
			alunos.get(i).setCurso(tempcurso);

			Curso cursotemp2 = new Curso();
			for (int j = 0; j < cursos.size(); j++) {
				if (excurso != 0) {
					cursotemp2 = cursos.get(j);
				}
			}
			int alunotemounao = 0;
			if (excurso != 0) {
				alunotemounao = 1;
			}
			if (alunotemounao == 1) {
				alunostemp.get(i).setCurso(cursotemp2);
			}

		}
		alunos = alunostemp;
		GUARDARFILES();
	}

	public static void GUARDARFILESEREPOR() {
		GUARDARFILES();
		REPOR();
	}

	public static void ALUNOMOD() {
		REPOR();
		BUSCARFILES();
		int posaluno = 0;
		String modalunos = "Lista dos alunos\n-------------------\n";
		for (int i = 0; i < alunos.size(); i++) {
			modalunos = modalunos + "Numero: " + alunos.get(i).getNumero() + "\nNome" + alunos.get(i).getNome()
					+ "\n\n";
		}
		modalunos = modalunos + "Qual o numero de aluno que deseja modificar?";
		String idaluno = JOptionPane.showInputDialog(modalunos);

		for (int i = 0; i < alunos.size(); i++) {
			if (idaluno == alunos.get(i).getNumero()) {
				posaluno = i;
			}
		}

		String atribalunos = JOptionPane.showInputDialog(
				"Atributos que pode modificar\n1- Nome\n2- Curso\n3- Idade\n4- Media\n5- Cancelar\nQual o atributo que deseja modificar?");
		int numatri2 = Integer.parseInt(atribalunos);

		voltar = true;
		switch (numatri2) {
		case 1:
			ALUNOMODNOME(posaluno);
			GUARDARFILES();
			REPOR();
			ALUNOMOD();
			voltar = true;
			break;
		case 2:
			ALUNOMODCURSO(posaluno, idaluno);
			GUARDARFILES();
			REPOR();
			ALUNOMOD();
			voltar = true;
			break;
		case 3:
			ALUNOMODIDADE(posaluno);
			GUARDARFILES();
			REPOR();
			ALUNOMOD();
			voltar = true;
			break;
		case 4:
			ALUNOMODMEDIA(posaluno);
			GUARDARFILES();
			REPOR();
			ALUNOMOD();
			voltar = true;
			break;
		case 5:
			voltar = false;
			break;
		default:
			voltar = true;
			break;
		}

	}

	public static void ALUNOMODNOME(int posaluno) {
		String nomenovoaluno = JOptionPane
				.showInputDialog("Nome atual: " + alunos.get(posaluno).getNome() + "\nNome Novo: ");
		alunos.get(posaluno).setNome(nomenovoaluno);
		GUARDARFILES();
	}

	public static void ALUNOMODCURSO(int posaluno, String idaluno) {
		String mostraralunos = "Curso atual: " + alunos.get(posaluno).getCurso() + "\nCurso que pode escolher: \n";

		for (int i = 0; i < cursos.size(); i++) {
			if (!cursos.get(i).equals(alunos.get(posaluno).getCurso())) {
				mostraralunos = mostraralunos + "Nome: " + cursos.get(i).getNome() + " | Codigo: "
						+ cursos.get(i).getCodigo() + "\n";
			}
		}
		mostraralunos = mostraralunos + "\nEscolha um curso por codigo: ";
		String codigocursoparaaluno = JOptionPane.showInputDialog(mostraralunos);

		int codigoparaaluno = Integer.parseInt(codigocursoparaaluno);
		for (int i = 0; i < cursos.size(); i++) {
			if (codigoparaaluno == cursos.get(i).getCodigo()) {
				alunos.get(posaluno).setCurso(cursos.get(i));
				GUARDARFILES();
				voltar = false;
			}
		}

	}

	public static void ALUNOMODIDADE(int posaluno) {

		String idadenovoaluno = JOptionPane
				.showInputDialog("Idade atual: " + alunos.get(posaluno).getIdade() + "\nIdade Novo: ");
		int idadenova = Integer.parseInt(idadenovoaluno);
		alunos.get(posaluno).setIdade(idadenova);
		GUARDARFILES();

	}

	public static void ALUNOMODMEDIA(int posaluno) {
		String medianovoaluno = JOptionPane
				.showInputDialog("Média atual: " + alunos.get(posaluno).getMedia() + "\nMedia Novo: ");
		double medianova = Double.parseDouble(medianovoaluno);
		alunos.get(posaluno).setMedia(medianova);
		GUARDARFILES();

	}

	public static void CURSOMOD() {
		REPOR();
		BUSCARFILES();
		int poscurso = 0;

		String modcursos = "Lista dos cursos\n---------------------\n";
		for (int i = 0; i < cursos.size(); i++) {
			modcursos = modcursos + "Codigo: " + cursos.get(i).getCodigo() + "\nNome: " + cursos.get(i).getNome()
					+ "\n\n";
		}

		modcursos = modcursos + "Qual o codigo do curso que deseja modificar?";
		String idcursoS = JOptionPane.showInputDialog(modcursos);
		int idcurso = Integer.parseInt(idcursoS);
		for (int i = 0; i < cursos.size(); i++) {
			if (idcurso == cursos.get(i).getCodigo()) {
				poscurso = i;
			}
		}

		String atibcursos = JOptionPane.showInputDialog(
				"Atributos que pode modificar\n1- Nome\n2- Horas\n3- Regente\n4- Cadeiras\n5- Propinas\n6- Cancelar\nQual o atributo que deseja modificar?  ");

		int numatri2 = Integer.parseInt(atibcursos);

		voltar = true;
		switch (numatri2) {
		case 1:
			CURSOMODNOME(poscurso);
			REPOR();
			CURSOMOD();
			voltar = true;
			break;
		case 2:
			CURSOMODHORAS(poscurso);
			REPOR();
			CURSOMOD();
			voltar = true;
			break;
		case 3:
			CURSOMODREGENTE(poscurso);
			REPOR();
			CURSOMOD();
			voltar = true;
			break;
		case 4:
			CURSOMODCADEIRAS(poscurso);
			REPOR();
			CURSOMOD();
			voltar = false;
			break;
		case 5:
			CURSOMODPROPINAS(poscurso);
			REPOR();
			CURSOMOD();
			voltar = false;
			break;
		case 6:
			voltar = false;
			break;
		default:
			voltar = true;
			break;
		}

	}

	public static void CURSOMODNOME(int poscurso) {
		String nomenovocurso = JOptionPane
				.showInputDialog("Nome atual: " + cursos.get(poscurso).getNome() + "\nNome Novo: ");
		cursos.get(poscurso).setNome(nomenovocurso);
		GUARDARFILES();

	}

	public static void CURSOMODCODIGO(int poscurso) {
		String nomenovocurso = JOptionPane
				.showInputDialog("Codigo atual: " + cursos.get(poscurso).getCodigo() + "\nCodigo Novo: ");
		int codigonovo = Integer.parseInt(nomenovocurso);
		cursos.get(poscurso).setCodigo(codigonovo);
		GUARDARFILES();

	}

	public static void CURSOMODHORAS(int poscurso) {
		String horasnovocurso = JOptionPane
				.showInputDialog("Horas atuais: " + cursos.get(poscurso).getHoras() + "\nHoras Novas: ");
		int codigonovo = Integer.parseInt(horasnovocurso);
		cursos.get(poscurso).setHoras(codigonovo);
		GUARDARFILES();

	}

	public static void CURSOMODREGENTE(int poscurso) {
		String regentenovocurso = JOptionPane
				.showInputDialog("Regente atual: " + cursos.get(poscurso).getRegente() + "Regente Novo: ");
		cursos.get(poscurso).setRegente(regentenovocurso);
		GUARDARFILES();

	}

	public static void CURSOMODPROPINAS(int poscurso) {
		String propinasnovocurso = JOptionPane
				.showInputDialog("Propinas atuais: " + cursos.get(poscurso).getPropinas() + "Propinas Novas: ");
		double propinasnovas = Double.parseDouble(propinasnovocurso);
		cursos.get(poscurso).setPropinas(propinasnovas);
		GUARDARFILES();

	}

	public static void CURSOMODCADEIRAS(int poscurso) {

		String cadscurso = "Cadeiras atuais do curso: \n-----------------------------\n";
		for (int i = 0; i < cursos.get(poscurso).getCadeiras().size(); i++) {
			cadscurso = cadscurso + "Codigo: " + cursos.get(poscurso).getCadeiras().get(i).getCodigo() + "\nNome: "
					+ cursos.get(poscurso).getCadeiras().get(i).getNome() + "\n\n";
		}
		cadscurso = cadscurso + "Operações:\n1- Adicionar\n2- Remover\n3- Cancelar";
		voltar = true;
		while (voltar) {
			String opcaoS = JOptionPane.showInputDialog(cadscurso);
			int opcaomodcadeiras = Integer.parseInt(opcaoS);
			switch (opcaomodcadeiras) {
			case 1:
				CURSOMODCADEIRASADD(poscurso);
				voltar = false;
				break;
			case 2:
				CURSOMODCADEIRASREM(poscurso);
				voltar = false;
				break;
			case 3:
				CURSOMOD();
				voltar = false;
				break;
			default:
				voltar = true;
				break;
			}
		}
		GUARDARFILES();
	}

	public static void CURSOMODCADEIRASADD(int poscurso) {
		ArrayList<Integer> cadeirasporcurso = new ArrayList<Integer>();
		for (int k = 0; k < cadeiras.size(); k++) {
			int numdevezescadeiras = 0;

			for (int j = 0; j < cursos.get(poscurso).getCadeiras().size(); j++) {

				if (cursos.get(poscurso).getCadeiras().get(j).equals(cadeiras.get(k))) {
					numdevezescadeiras = numdevezescadeiras + 1;
				}
			}
			cadeirasporcurso.add(numdevezescadeiras);
		}
		String cadsatuais = "Cadeiras atuais do curso: \n------------------------------\n";
		for (int i = 0; i < cursos.get(poscurso).getCadeiras().size(); i++) {
			cadsatuais = cadsatuais + "Codigo: " + cursos.get(poscurso).getCadeiras().get(i).getCodigo() + "\nNome: "
					+ cursos.get(poscurso).getCadeiras().get(i).getNome() + "\n\n";
		}
		cadsatuais = cadsatuais + "Cadeiras que pode adicionar: \n--------------------------\n";
		for (int i = 0; i < cadeirasporcurso.size(); i++) {
			if (cadeirasporcurso.get(i) == 0) {
				cadsatuais = cadsatuais + "Codigo: " + cadeiras.get(i).getCodigo() + "\nNome: "
						+ cadeiras.get(i).getNome() + "\n\n";
			}
		}
		cadsatuais = cadsatuais + "Escolha uma cadeira por codigo para adicionar";
		String escolhacadieraS = JOptionPane.showInputDialog(cadsatuais);
		int escolhacadeira = Integer.parseInt(escolhacadieraS);
		int poscadeira = 0;
		for (int i = 0; i < cadeiras.size(); i++) {
			if (escolhacadeira == cadeiras.get(i).getCodigo()) {
				poscadeira = i;
			}
		}
		for (int i = 0; i < cadeiras.size(); i++) {
			if (cadeiras.get(i).getCodigo() == escolhacadeira) {
				cursos.get(poscurso).getCadeiras().add(cadeiras.get(poscadeira));

			}
		}
		GUARDARFILES();
	}

	public static void CURSOMODCADEIRASREM(int poscurso) {

		String cadsremover = "Cadeiras que pode remover do curso: \n------------------------------------\n";
		for (int i = 0; i < cursos.get(poscurso).getCadeiras().size(); i++) {
			cadsremover = cadsremover + "Codigo: " + cursos.get(poscurso).getCadeiras().get(i).getCodigo() + "\nNome: "
					+ cursos.get(poscurso).getCadeiras().get(i).getNome() + "\n\n";
		}
		cadsremover = cadsremover + "Escolha uma cadeira por codigo para remover";
		String escolhacadeiraS = JOptionPane.showInputDialog(cadsremover);
		int escolhacadeira = Integer.parseInt(escolhacadeiraS);
		int poscadeiranocurso = 0;
		for (int i = 0; i < cursos.get(poscurso).getCadeiras().size(); i++) {
			if (cursos.get(poscurso).getCadeiras().get(i).getCodigo() == escolhacadeira) {
				poscadeiranocurso = i;
			}
		}
		for (int i = 0; i < cadeiras.size(); i++) {
			if (cadeiras.get(i).getCodigo() == escolhacadeira) {
				cursos.get(poscurso).getCadeiras().remove(poscadeiranocurso);
			}
		}
		GUARDARFILES();
	}

	public static void CADEIRAMOD() {
		REPOR();
		BUSCARFILES();
		int poscadeira = 0;

		String modcadeiras = "Lista das cadeiras\n--------------------\n";
		for (int i = 0; i < cadeiras.size(); i++) {
			modcadeiras = modcadeiras + "Codigo: " + cadeiras.get(i).getCodigo() + "\nNome" + cadeiras.get(i).getNome()
					+ "\n\n";
		}

		modcadeiras = modcadeiras + "Qual o codigo da cadeira que deseja modificar?";
		String idcadeiraS = JOptionPane.showInputDialog(modcadeiras);
		int idcadeira = Integer.parseInt(idcadeiraS);
		for (int i = 0; i < cadeiras.size(); i++) {
			if (idcadeira == cadeiras.get(i).getCodigo()) {
				poscadeira = i;
			}
		}
		String atribcadeiras = JOptionPane.showInputDialog(
				"Atributos que pode modificar\n1- Nome\n2- Taxa de Aprovação\n3- Professores\n4- Cancelar\nQual o atributo que deseja modificar?");

		int numatri = Integer.parseInt(atribcadeiras);

		voltar = true;
		switch (numatri) {
		case 1:
			CADEIRAMODNOME(poscadeira);
			GUARDARFILESEREPOR();
			CADEIRAMOD();
			voltar = true;
			break;
		case 2:
			CADEIRAMODTAXAAPROV(poscadeira);
			GUARDARFILESEREPOR();
			CADEIRAMOD();
			voltar = true;
			break;
		case 3:
			CADEIRAMODPROF(poscadeira);
			GUARDARFILESEREPOR();
			CADEIRAMOD();
			voltar = true;
			break;
		case 4:
			voltar = false;
			break;
		default:
			voltar = true;
			break;
		}

	}

	public static void CADEIRAMODNOME(int poscadeira) {
		String nomenovocurso = JOptionPane
				.showInputDialog("Nome atual: " + cadeiras.get(poscadeira).getNome() + "\nNome Novo: ");
		cadeiras.get(poscadeira).setNome(nomenovocurso);
		GUARDARFILES();

	}

	public static void CADEIRAMODTAXAAPROV(int poscadeira) {
		String nomenovocurso = JOptionPane.showInputDialog("Taxa de aprovação atual: "
				+ cadeiras.get(poscadeira).getTaxadeaprovacao() + "\nTaxa de aprovação Novo: ");
		double taxanovo = Double.parseDouble(nomenovocurso);
		cadeiras.get(poscadeira).setTaxadeaprovacao(taxanovo);
		GUARDARFILES();
	}

	public static void CADEIRAMODPROF(int poscadeira) {
		BUSCARFILES();
		String profsatuaiscad = "Professores atuais da cadeira: \n------------------------------------\n";
		for (int i = 0; i < cadeiras.get(poscadeira).getProfessores().size(); i++) {
			profsatuaiscad = profsatuaiscad + "Numero: " + cadeiras.get(poscadeira).getProfessores().get(i).getNumero()
					+ " | Nome: " + cadeiras.get(poscadeira).getProfessores().get(i).getNome() + "\n\n";
		}
		profsatuaiscad = profsatuaiscad + "Opeçãoes: \n1- Adicionar\n2- Remover\n3- Cancelar";
		voltar = true;
		while (voltar) {
			String opmodcad = JOptionPane.showInputDialog(profsatuaiscad);
			int opcaomodcadeiras = Integer.parseInt(opmodcad);
			switch (opcaomodcadeiras) {
			case 1:
				CADEIRAMODPROFADD(poscadeira);
				voltar = false;
				break;
			case 2:
				CADEIRAMODPROFREM(poscadeira);
				voltar = false;
				break;
			case 3:
				CURSOMOD();
				voltar = false;
				break;
			default:
				voltar = true;
				break;
			}

		}
		GUARDARFILES();

	}

	public static void CADEIRAMODPROFADD(int poscadeira) {

		ArrayList<Integer> professoresporcadeira = new ArrayList<Integer>();
		for (int k = 0; k < professores.size(); k++) {
			int numdevezesprofessores = 0;
			for (int j = 0; j < cadeiras.get(poscadeira).getProfessores().size(); j++) {
				if (cadeiras.get(poscadeira).getProfessores().get(j).equals(professores.get(k))) {
					numdevezesprofessores = numdevezesprofessores + 1;
				}
			}
			professoresporcadeira.add(numdevezesprofessores);
		}

		for (int i = 0; i < professoresporcadeira.size(); i++) {
			System.out.println(professoresporcadeira.get(i));

		}
		String profsadicionar = "Professores atuais da cadeira: \n----------------------------------\n";
		System.out.println("Professores atuais da cadeira: \n");
		for (int i = 0; i < cadeiras.get(poscadeira).getProfessores().size(); i++) {
			profsadicionar = profsadicionar + "Numero: " + cadeiras.get(poscadeira).getProfessores().get(i).getNumero()
					+ "\nNome: " + cadeiras.get(poscadeira).getProfessores().get(i).getNome() + "\n\n";
		}
		profsadicionar = profsadicionar + "Cadeiras que pode adicionar: \n-------------------------------\n";
		for (int i = 0; i < professoresporcadeira.size(); i++) {
			if (professoresporcadeira.get(i) == 0) {
				profsadicionar = profsadicionar + "Numero: " + professores.get(i).getNumero() + "\nNome: "
						+ professores.get(i).getNome() + "\n\n";
			}
		}
		profsadicionar = profsadicionar + "Escolha um prof por numero para adicionar";
		String escolhaprof = JOptionPane.showInputDialog(profsadicionar);

		int posprof = 0;
		for (int i = 0; i < professores.size(); i++) {
			if (escolhaprof.equals(professores.get(i).getNumero())) {
				posprof = i;
			}
		}
		for (int i = 0; i < cadeiras.size(); i++) {
			if (professores.get(i).getNumero().equals(escolhaprof)) {
				cadeiras.get(poscadeira).getProfessores().add(professores.get(posprof));

			}
		}
		GUARDARFILES();

	}

	public static void CADEIRAMODPROFREM(int poscadeira) {

		String profsremover = "Professores que pode remover da cadeira: \n--------------------------------\n";
		for (int i = 0; i < cadeiras.get(poscadeira).getProfessores().size(); i++) {
			profsremover = profsremover + "Numero: " + cadeiras.get(poscadeira).getProfessores().get(i).getNumero()
					+ "\nNome: " + cadeiras.get(poscadeira).getProfessores().get(i).getNome() + "\n\n";
		}
		profsremover = profsremover + "Escolha um professor por codigo para remover";

		String escolhaprof = JOptionPane.showInputDialog(profsremover);
		int posprofnacadeira = 0;
		for (int i = 0; i < cadeiras.get(poscadeira).getProfessores().size(); i++) {
			if (cadeiras.get(poscadeira).getProfessores().get(i).getNumero() == escolhaprof) {
				posprofnacadeira = i;
			}
		}
		for (int i = 0; i < professores.size(); i++) {
			if (professores.get(i).getNumero() == escolhaprof) {
				cadeiras.get(poscadeira).getProfessores().remove(posprofnacadeira);
			}
		}
		GUARDARFILES();
	}

	public static void PROFMOD() {

		REPOR();
		BUSCARFILES();
		int posprof = 0;

		String modprofs = "Lista dos professores\n------------------------\n";

		for (int i = 0; i < professores.size(); i++) {
			modprofs = modprofs + "Numero: " + professores.get(i).getNumero() + "\nNome" + professores.get(i).getNome()
					+ "\n\n";
		}

		modprofs = modprofs + "Qual o codigo do professor que deseja modificar?";
		String idprof = JOptionPane.showInputDialog(modprofs);
		for (int i = 0; i < professores.size(); i++) {
			if (idprof.equals(professores.get(i).getNumero())) {
				posprof = i;
			}
		}
		String atribprofs = JOptionPane.showInputDialog(
				"Atributos que pode modificar\n1- Nome\n2- Idade\n3- Salario\n4- Morada\n5- Cancelar\nQual o atributo que deseja modificar?");

		int numatri = Integer.parseInt(atribprofs);

		voltar = true;
		switch (numatri) {
		case 1:
			PROFMODNOME(posprof);
			GUARDARFILESEREPOR();
			PROFMOD();
			voltar = true;
			break;
		case 2:
			PROFMODIDADE(posprof);
			GUARDARFILESEREPOR();
			PROFMOD();
			voltar = true;
			break;
		case 3:
			PROFMODSALARIO(posprof);
			GUARDARFILESEREPOR();
			PROFMOD();
			voltar = true;
			break;
		case 4:
			PROFMODMORADA(posprof);
			GUARDARFILESEREPOR();
			PROFMOD();
			voltar = true;
			break;
		case 6:
			voltar = false;
			break;
		default:
			voltar = true;
			break;
		}

	}

	public static void PROFMODNOME(int posprof) {
		String nomenovoprof = JOptionPane
				.showInputDialog("Nome atual: " + professores.get(posprof).getNome() + "\nNome Novo: ");
		professores.get(posprof).setNome(nomenovoprof);
		GUARDARFILES();
	}

	public static void PROFMODIDADE(int posprof) {
		String idadenovoprof = JOptionPane
				.showInputDialog("Idade atual: " + professores.get(posprof).getIdade() + "\nIdade Novo: ");
		int idadenovo = Integer.parseInt(idadenovoprof);
		professores.get(posprof).setIdade(idadenovo);
		GUARDARFILES();
	}

	public static void PROFMODSALARIO(int posprof) {
		String salarionovoprof = JOptionPane
				.showInputDialog("Salario atual: " + professores.get(posprof).getSalario() + "\nSalario Novo: ");
		double salarionovo = Double.parseDouble(salarionovoprof);
		professores.get(posprof).setSalario(salarionovo);
		GUARDARFILES();
	}

	public static void PROFMODMORADA(int posprof) {
		String moradanovoprof = JOptionPane
				.showInputDialog("Morada atual: " + professores.get(posprof).getMorada() + "\nMorada Novo: ");

		professores.get(posprof).setNome(moradanovoprof);
		GUARDARFILES();
	}
}
