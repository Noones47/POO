package projeto;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//                     IMPORTANTE!!!!
// es nao aparecer nada nas listas, é porque por alguma razao os 
// files não tem nada e tem que se dar "run" ao "GerarFiles.java"

public class Main {

	public static Escola escola = new Escola("Escola Profissional da Pinguinha", "Marte");
	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	public static ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
	public static ArrayList<Professor> professores = new ArrayList<Professor>();
	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static boolean voltar = true;

//a funçao LISTA() e so de teste, nao tem efeito sobre o resto do trabalho
	public static void LISTA(String s) {

		JFrame window = new JFrame("JScrollBar example");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea textArea = new JTextArea(10, 20);
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		textArea.setText(s);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		window.add(scroll);
		window.setSize(500, 500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		try {
			System.in.read();
		} catch (Exception e) {
		}
		return;
	}

	public static void MENSAGEMERRO() {
		JOptionPane.showMessageDialog(null,
				"--------------ERRO!!!--------------\nEssa opção não existe,\npor favor escolha outra opção.");
	}

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

	public static void MENU() {
		voltar = true;
		while (voltar) {
			voltar = false;
			String op = JOptionPane.showInputDialog(null,
					"-----------MENU-----------\n1 : Informações\n2 : Edição\n3 : Sair.");
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				INFO();
				break;
			case 2:
				EDIT();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				MENSAGEMERRO();
				voltar = true;
				break;
			}
		}
	}

	// MENU PARA A INFORMACAO---------------------------------------
	public static void INFO() {
		REPOR();
		BUSCARFILES();
		voltar = true;
		while (voltar) {
			String op = JOptionPane.showInputDialog(null,
					"-----------INFO-----------\n1 : Cursos\n2 : Alunos\n3 : Professores\n4 : Cadeiras\n5 : Voltar");
			voltar = false;
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				INFCURSOS();
				break;
			case 2:
				INFALUNOS();
				break;
			case 3:
				INFPROFS();
				break;
			case 4:
				BUSCARFILES();
				String listadecursos = "Lista de Cadeiras\n----------------------\n";
				for (int i = 0; i < cadeiras.size(); i++) {
					listadecursos = listadecursos + cadeiras.get(i).toString();
				}
				JOptionPane.showMessageDialog(null, listadecursos);
				INFO();
				break;
			case 5:
				MENU();
				break;
			default:
				MENSAGEMERRO();
				voltar = true;
				break;
			}
		}
	}

	// MENU INFOCURSOS-----------------------------------------
	public static void INFCURSOS() {
		voltar = true;
		while (voltar) {
			String op = JOptionPane.showInputDialog(null,
					"-----------CURSOS-----------\n1 : Lista\n2 : Procurar\n3 : Estatisticas\n4 : Voltar");
			voltar = false;
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				String listacursos = "";
				for (int i = 0; i < cursos.size(); i++) {
					listacursos = listacursos + cursos.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null, listacursos);
				// LISTA(listacursos);
				INFCURSOS();
				break;
			case 2:
				String nomecurso = JOptionPane.showInputDialog("Qual o nome do curso que quer encontrar?");
				String listacursosencontrados = "";
				for (int i = 0; i < cursos.size(); i++) {
					if (cursos.get(i).getNome().equals(nomecurso)) {
						listacursosencontrados = listacursosencontrados + cursos.get(i).toString() + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, listacursosencontrados);
				INFCURSOS();
				break;
			case 3:
				STATS_C();
				break;
			case 4:
				INFO();
				break;
			default:
				MENSAGEMERRO();
				voltar = true;
				break;
			}
		}
	}

	// MENU INFOALUNOS-----------------------------------------
	public static void INFALUNOS() {
		voltar = true;
		while (voltar) {
			String op = JOptionPane.showInputDialog(null,
					"-----------ALUNOS-----------\n1 : Lista\n2 : Procurar\n3 : Estatisticas\n4 : Voltar");
			voltar = false;
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				String listaalunos = "";
				for (int i = 0; i < alunos.size(); i++) {
					listaalunos = listaalunos + alunos.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null, listaalunos);
				INFALUNOS();
				break;
			case 2:
				String nomealuno = JOptionPane.showInputDialog("Qual o nome do aluno que quer encontrar?");
				String listaalunosencontrados = "";
				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getNome().equals(nomealuno)) {
						listaalunosencontrados = listaalunosencontrados + alunos.get(i).toString() + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, listaalunosencontrados);
				INFALUNOS();
				break;
			case 3:
				STATS_A();
				break;
			case 4:
				INFO();
				break;
			default:
				MENSAGEMERRO();
				voltar = true;
				break;
			}
		}
	}

	// MENU INFOPROFS-----------------------------------------
	public static void INFPROFS() {
		voltar = true;
		while (voltar) {
			String op = JOptionPane.showInputDialog(null,
					"-----------PROFESSORES-----------\n1 : Lista\n2 : Procurar\n3 : Estatisticas\n4 : Voltar");
			voltar = false;
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				String listaprofessores = "";
				for (int i = 0; i < professores.size(); i++) {
					listaprofessores = listaprofessores + professores.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null, listaprofessores);
				INFPROFS();
				break;

			case 2:
				String nomeprofessor = JOptionPane.showInputDialog("Qual o nome do professor que quer encontrar?");
				String listaprofessorsencontrados = "";
				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getNome().equals(nomeprofessor)) {
						listaprofessorsencontrados = listaprofessorsencontrados + alunos.get(i).toString() + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, listaprofessorsencontrados);
				INFPROFS();
				break;
			case 3:
				STATS_P();
				break;
			case 4:
				INFO();
				break;
			default:
				MENSAGEMERRO();
				voltar = true;
				break;
			}
		}
	}

	// MENU STATSCURSOS-----------------------------------------
	public static void STATS_C() {
		voltar = true;
		while (voltar) {
			String op = JOptionPane.showInputDialog(null,
					"-----------ESTATÍSTICAS CURSOS-----------\n1 : Curso mais frequentado\n2 : Curso menos frequentado\n3 : Curso com maior taxa de aprovação\n4 : Curso com menor taxa de aprovação\n5 : Voltar");
			voltar = false;
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				int maiornumcad = 0;
				ArrayList<Integer> alunosporcur = new ArrayList<Integer>();
				for (int i = 0; i < cursos.size(); i++) {
					int numcad = 0;
					for (int j = 0; j < alunos.size(); j++) {
						if (alunos.get(j).getCurso().equals(cursos.get(i))) {
							numcad = numcad + 1;
						}
					}
					alunosporcur.add(numcad);
				}
				for (int i = 0; i < alunosporcur.size(); i++) {
					if (alunosporcur.get(i) > maiornumcad) {
						maiornumcad = alunosporcur.get(i);
					}
				}
				String listaprofsmaiscads = "Curso mais frequentados:\n-----------------------------------\n";
				for (int i = 0; i < cursos.size(); i++) {
					if (alunosporcur.get(i) == maiornumcad) {

						listaprofsmaiscads = listaprofsmaiscads + "Nome: " + cursos.get(i).getNome()
								+ "\nNúmero de Alunos: " + alunosporcur.get(i) + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, listaprofsmaiscads);
				STATS_C();
				break;
			case 2:
				int menornumcad = 10;
				ArrayList<Integer> alunosporcur1 = new ArrayList<Integer>();
				for (int i = 0; i < cursos.size(); i++) {
					int numcad = 0;
					for (int j = 0; j < alunos.size(); j++) {
						if (alunos.get(j).getCurso().equals(cursos.get(i))) {
							numcad = numcad + 1;
							System.out.println(numcad);
						}
					}
					alunosporcur1.add(numcad);
				}
				for (int i = 0; i < alunosporcur1.size(); i++) {
					if (alunosporcur1.get(i) < menornumcad) {
						menornumcad = alunosporcur1.get(i);
					}
				}
				String listaprofsmenoscads = "Curso menos frequentados:\n-----------------------------------\n";
				for (int i = 0; i < cursos.size(); i++) {
					if (alunosporcur1.get(i) == menornumcad) {

						listaprofsmenoscads = listaprofsmenoscads + "Nome: " + cursos.get(i).getNome()
								+ "\nNúmero de Alunos: " + alunosporcur1.get(i) + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, listaprofsmenoscads);
				STATS_C();
				break;
			case 3:
				double maiortaxa = 0;
				for (int i = 0; i < cursos.size(); i++) {
					if (cursos.get(i).MaiorAprov() > maiortaxa) {
						maiortaxa = cursos.get(i).MaiorAprov();
					}
				}
				String cursomaiortaxa = "Curso com maior taxa de aprovação\n-----------------------------------\n";
				for (int i = 0; i < cursos.size(); i++) {
					if (cursos.get(i).MaiorAprov() == maiortaxa) {
						cursomaiortaxa = cursomaiortaxa + "Nome: " + cursos.get(i).getNome() + "\nTaxa de Aprovação: "
								+ cursos.get(i).MaiorAprov() + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, cursomaiortaxa);
				STATS_C();
				break;
			case 4:
				double menortaxa = 100.0;
				for (int i = 0; i < cursos.size(); i++) {
					if (cursos.get(i).MaiorAprov() < menortaxa) {
						menortaxa = cursos.get(i).MaiorAprov();
					}
				}
				String cursomenortaxa = "Curso com menor taxa de aprovação\n-----------------------------------\n";
				for (int i = 0; i < cursos.size(); i++) {
					if (cursos.get(i).MaiorAprov() == menortaxa) {
						cursomenortaxa = cursomenortaxa + "Nome: " + cursos.get(i).getNome() + "\nTaxa de Aprovação: "
								+ cursos.get(i).MaiorAprov() + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, cursomenortaxa);
				STATS_C();
				break;
			case 5:
				INFCURSOS();
				break;
			default:
				voltar = true;
				break;
			}
		}
	}

	// MENU STATSALUNOS-----------------------------------------
	public static void STATS_A() {
		voltar = true;
		while (voltar) {
			String op = JOptionPane.showInputDialog(null,
					"-----------ESTATÍSTICAS ALUNOS-----------\n1 : Aluno(s) que moram na mesma cidade que a escola\n2 : Aluno(s) com maior média\n3 : Aluno(s) com menor média\n4 : Voltar");
			voltar = false;
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				ArrayList<Aluno> localescalun = new ArrayList<Aluno>();
				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getLocalidade().equals(escola.getLocal())) {
						localescalun.add(alunos.get(i));
					}
				}
				String alunosescola = "Aluno(s) que moram na mesma cidade que a escola\n------------------------------------------\n";
				for (int i = 0; i < localescalun.size(); i++) {
					alunosescola = alunosescola + localescalun.get(i).getNome() + "\n\n";
				}
				JOptionPane.showMessageDialog(null, alunosescola);
				STATS_A();
				break;
			case 2:
				double maiornota = 0;

				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getMedia() > maiornota) {
						maiornota = alunos.get(i).getMedia();
					}

				}
				String alunosmaiormedia = "Aluno(s) com maior média\n------------------------------------------\n";
				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getMedia() == maiornota) {
						alunosmaiormedia = alunosmaiormedia + "Nome: " + alunos.get(i).getNome() + "\nMédia: "
								+ alunos.get(i).getMedia() + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, alunosmaiormedia);
				STATS_A();
				break;
			case 3:
				double menornota = 200;

				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getMedia() < menornota) {
						menornota = alunos.get(i).getMedia();
					}
				}

				String alunosmenosmedia = "Aluno(s) com maior média\n------------------------------------------\n";
				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getMedia() == menornota) {
						alunosmenosmedia = alunosmenosmedia + "Nome: " + alunos.get(i).getNome() + "\nMédia: "
								+ alunos.get(i).getMedia() + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, alunosmenosmedia);
				STATS_A();
				break;

			case 4:
				INFALUNOS();
				break;

			default:
				voltar = true;
				break;

			}
		}
	}

	// MENU STATSPROFS-----------------------------------------
	public static void STATS_P() {
		voltar = true;
		while (voltar) {
			String op = JOptionPane.showInputDialog(null,
					"-----------ESTATÍSTICAS PROFESSORES-----------\n1 : Professor que leciona mais cadeiras\n2 : Professor com maior salário\n3 : Professor com menor salário\n4 : Voltar");
			voltar = false;
			int opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				int maiornumcad = 0;
				ArrayList<Integer> cadsporprof = new ArrayList<Integer>();
				for (int i = 0; i < professores.size(); i++) {
					int numcad = 0;
					for (int j = 0; j < cadeiras.size(); j++) {
						for (int k = 0; k < cadeiras.get(j).getProfessores().size(); k++) {
							if (cadeiras.get(j).getProfessores().get(k).equals(professores.get(i))) {
								numcad = numcad + 1;
							}
						}
					}
					cadsporprof.add(numcad);
				}
				for (int i = 0; i < cadsporprof.size(); i++) {
					if (cadsporprof.get(i) > maiornumcad) {
						maiornumcad = cadsporprof.get(i);
					}
				}
				String profsmaiscadeiras = "Professore(s) com mais cadeiras\n-----------------------------------\n";
				for (int i = 0; i < professores.size(); i++) {
					if (cadsporprof.get(i) == maiornumcad) {
						profsmaiscadeiras = profsmaiscadeiras + "Nome: " + professores.get(i).getNome()
								+ "\nNúmero de Cadeiras: " + cadsporprof.get(i) + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, profsmaiscadeiras);
				STATS_P();
				break;

			case 2:
				double maiorsal = 0.0;
				for (int i = 0; i < professores.size(); i++) {
					if (professores.get(i).getSalario() > maiorsal) {
						maiorsal = professores.get(i).getSalario();
					}
				}
				String profsmenossal = "Professore(s) com maior salário\n----------------------------------------\n";
				for (int i = 0; i < professores.size(); i++) {
					if (professores.get(i).getSalario() == maiorsal) {
						profsmenossal = profsmenossal + "Nome: " + professores.get(i).getNome() + "\nSalário: "
								+ professores.get(i).getSalario() + "\n\n";
					}

				}
				JOptionPane.showMessageDialog(null, profsmenossal);
				STATS_P();
				break;

			case 3:
				double menorsal = 1000000.0;
				for (int i = 0; i < professores.size(); i++) {
					if (professores.get(i).getSalario() < menorsal) {
						menorsal = professores.get(i).getSalario();
					}
				}
				String profsmaissal = "Professore(s) com menor salário\n----------------------------------------\n";
				for (int i = 0; i < professores.size(); i++) {
					if (professores.get(i).getSalario() == menorsal) {
						profsmaissal = profsmaissal + "Nome: " + professores.get(i).getNome() + "\nSalário: "
								+ professores.get(i).getSalario() + "\n\n";
					}
				}
				JOptionPane.showMessageDialog(null, profsmaissal);
				STATS_P();
				break;
			case 4:
				INFPROFS();
				break;
			default:
				voltar = true;
				break;
			}
		}
	}

	// MENU PARA EDIT-----------------------------------------------------
	public static void EDIT() {
		int opcao;

		voltar = true;
		while (voltar) {
			voltar = false;
			String op = JOptionPane.showInputDialog(
					"-----------EDIÇÃO-----------\n1 : Adição\n2 : Remoção\n3 : Modificar\n4 : Voltar");

			opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				ADD();
				break;

			case 2:
				REM();
				break;
			case 3:
				MOD();
				break;

			case 4:
				MENU();
				break;

			default:
				MENSAGEMERRO();
				voltar = true;
				break;

			}
		}
	}

	// MENU PARA ADICAO--------------------------------------------------
	public static void ADD() {
		int opcao;

		voltar = true;
		while (voltar) {
			voltar = false;
			String op = JOptionPane.showInputDialog(null,
					"-----------ADIÇÃO-----------\n1 : Cursos\n2 : Alunos\n3 : Cadeiras\n4 : Professores\n5 : Voltar");

			opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				FuncAdd.CURSO();
				BUSCARFILES();
				ADD();
				break;

			case 2:
				FuncAdd.ALUNO();
				BUSCARFILES();
				ADD();
				break;

			case 3:
				FuncAdd.CADEIRAS();
				BUSCARFILES();
				ADD();
				break;
			case 4:
				FuncAdd.PROF();
				BUSCARFILES();
				ADD();
				break;
			case 5:
				EDIT();
				break;

			default:
				voltar = true;
				break;

			}
		}
	}

	// MENU PARA REMOCAO---------------------------------------------------
	public static void REM() {
		REPOR();
		BUSCARFILES();
		int opcao;

		voltar = true;
		while (voltar) {
			voltar = false;
			String op = JOptionPane.showInputDialog(null,
					"-----------REMOÇÃO-----------\n1 : Cursos\n2 : Alunos\n3 : Cadeiras\n4 : Professores\n5 : Voltar");
			opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				String cursomostrar = "Lista de cursos\n----------------------\n";
				for (int i = 0; i < cursos.size(); i++) {
					cursomostrar = cursomostrar + "Nome: " + cursos.get(i).getNome() + "\nCódigo: "
							+ cursos.get(i).getCodigo() + "\n\n";
				}
				cursomostrar = cursomostrar + "Escreva o nome do curso que deseja remover:";
				String nomecurso = JOptionPane.showInputDialog(cursomostrar);
				for (int i = 0; i < cursos.size(); i++) {
					if (cursos.get(i).getNome().equals(nomecurso)) {
						cursos.remove(i);
						GUARDARFILES();
					}
				}
				REM();
				break;

			case 2:
				String alunomostrar = "Lista de alunos\n----------------------\n";
				for (int i = 0; i < alunos.size(); i++) {
					alunomostrar = alunomostrar + "Nome: " + alunos.get(i).getNome() + "\nNúmero: "
							+ alunos.get(i).getNumero() + "\n\n";
				}
				alunomostrar = alunomostrar + "Escreva o nome do aluno que deseja remover:";
				String nomealuno = JOptionPane.showInputDialog(alunomostrar);

				for (int i = 0; i < alunos.size(); i++) {
					if (alunos.get(i).getNome().equals(nomealuno)) {
						alunos.remove(i);
						GUARDARFILES();
					}
				}
				REM();
				break;

			case 3:
				// Mostrar cadeiras
				String cadeirasmostrar = "Lista de cadeiras\n----------------------\n";
				for (int i = 0; i < cadeiras.size(); i++) {
					cadeirasmostrar = cadeirasmostrar + "Nome: " + cadeiras.get(i).getNome() + "\nCódigo: "
							+ cadeiras.get(i).getCodigo() + "\n\n";
				}
				cadeirasmostrar = cadeirasmostrar + "Escreva o nome da cadeira que deseja remover:";
				String nomecadeira = JOptionPane.showInputDialog(cadeirasmostrar);

				for (int i = 0; i < cadeiras.size(); i++) {
					if (cadeiras.get(i).getNome().equals(nomecadeira)) {
						cadeiras.remove(i);
						GUARDARFILES();
					}
				}
				REM();
				break;
			case 4:

				String profsmostrar = "Lista de professores\n----------------------\n";
				for (int i = 0; i < professores.size(); i++) {
					profsmostrar = profsmostrar + "Nome: " + professores.get(i).getNome() + "\nNúmero: "
							+ professores.get(i).getNumero() + "\n\n";
				}
				profsmostrar = profsmostrar + "Escreva o nome do professor que deseja remover:";
				String nomeprof = JOptionPane.showInputDialog(profsmostrar);

				for (int i = 0; i < professores.size(); i++) {
					if (professores.get(i).getNome().equals(nomeprof)) {
						professores.remove(i);
						GUARDARFILES();
					}
				}

				REM();
				break;

			case 5:
				EDIT();
				break;

			default:
				voltar = true;
				break;

			}
		}

	}

	public static void MOD() {
		int opcao;
		voltar = true;
		while (voltar) {
			voltar = false;

			String op = JOptionPane.showInputDialog(null,
					"-----------MODIFICAÇÃO-----------\n1 : Cursos\n2 : Alunos\n3 : Cadeiras\n4 : Professores\n5 : Voltar");
			opcao = Integer.parseInt(op);
			switch (opcao) {
			case 1:
				FuncMod.CURSOMOD();
				BUSCARFILES();
				MOD();
				break;

			case 2:
				FuncMod.ALUNOMOD();
				BUSCARFILES();
				MOD();

			case 3:
				FuncMod.CADEIRAMOD();
				BUSCARFILES();
				MOD();
				break;
			case 4:
				FuncMod.PROFMOD();
				BUSCARFILES();
				MOD();
				break;
			case 5:
				EDIT();
				break;

			default:
				voltar = true;
				break;
			}

		}

	}

	public static void main(String[] args) {

		BUSCARFILES();
		MENU();
		GUARDARFILES();
	}
}
