package projeto;

import java.io.*;
import java.util.ArrayList;

public class GerarFiles {
	public static void main(String[] args) {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
		ArrayList<Professor> professores = new ArrayList<Professor>();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();

		// Professor p1 = new Professor("Nome do professor", (idade do professor),
		// (salario), "Morada");
		// ...
		Professor p1 = new Professor("João Reis", 28, 1350.00, "Rua Das Mil Fontes nº17");
        Professor p2 = new Professor("Alexandre Santos", 32, 1001.37, "Praceta Do Panadinho nº8");
        Professor p3 = new Professor("Tony Estrela", 47, 2250.57, "Ruela Das Quintinhas nº21");
        Professor p4 = new Professor("Bruce Bano", 53, 1703.89, "Rua Do Antonio Montanelas nº1");
        Professor p5 = new Professor("Marco Paulo", 61, 3150.20, "Praceta do Santo Escobar nº7");
        Professor p6 = new Professor("Ana Caxo", 31, 1450.00, "Rua Das Santas nº9");
        Professor p7 = new Professor("Itachi Uchiha", 35, 1795.10, "Rua Dos Cavaleiros nº22");
        Professor p8 = new Professor("Diana Melancia", 45, 2350.00, "Rua Dos Piplups nº15");
        Professor p9 = new Professor("Sofia Souza", 32, 3750.50, "Praceta do Natal nº10");
        Professor p10 = new Professor("Cátia Bartelos", 47, 5150.69, "Rua das Dragon Lores nº11");

		professores.add(p1);
		professores.add(p2);
		professores.add(p3);
		professores.add(p4);
		professores.add(p5);
		professores.add(p6);
		professores.add(p7);
		professores.add(p8);
		professores.add(p9);
		professores.add(p10);

		// ...
		ArrayList<Professor> profc1 = new ArrayList<Professor>();
        ArrayList<Professor> profc2 = new ArrayList<Professor>();
        ArrayList<Professor> profc3 = new ArrayList<Professor>();
        ArrayList<Professor> profc4 = new ArrayList<Professor>();
        ArrayList<Professor> profc5 = new ArrayList<Professor>();
        ArrayList<Professor> profc6 = new ArrayList<Professor>();
        ArrayList<Professor> profc7 = new ArrayList<Professor>();
        ArrayList<Professor> profc8 = new ArrayList<Professor>();
        ArrayList<Professor> profc9 = new ArrayList<Professor>();
        ArrayList<Professor> profc10 = new ArrayList<Professor>();
        // professores da cadeira 1

        profc1.add(p1);
        profc1.add(p9);
        
        profc2.add(p7);
        profc2.add(p5);
        
        profc3.add(p10);
        
        profc4.add(p3);
        profc4.add(p4);
        
        profc5.add(p2);
        
        profc6.add(p1);
        profc6.add(p8);
        
        profc7.add(p7);
        profc7.add(p6);
        
        profc8.add(p4);
        
        profc9.add(p8);
        
        profc10.add(p9);

        Cadeira ca1 = new Cadeira(1009, "Relatório", profc1,34.12);
        Cadeira ca2 = new Cadeira(1120, "Hacker Man",profc2,86.88);
        Cadeira ca3 = new Cadeira(1290, "Terminal", profc3,69.42);
        Cadeira ca4 = new Cadeira(1345, "Scripts", profc4,41.55);
        Cadeira ca5 = new Cadeira(1420, "Ética", profc5,80.12);
        Cadeira ca6 = new Cadeira(1582, "Hacking",profc6,34.22);
        Cadeira ca7 = new Cadeira(1680, "Laboratório de Hacking", profc7,95.99);
        Cadeira ca8 = new Cadeira(1710, "Segurança de hardware", profc8,59.45);
        Cadeira ca9 = new Cadeira(1840, "Ameaças Virtuais", profc9,65.96);
        Cadeira ca10 = new Cadeira(1900, "Projeto", profc10,51.00);

		cadeiras.add(ca1);
		cadeiras.add(ca2);
		cadeiras.add(ca3);
		cadeiras.add(ca4);
		cadeiras.add(ca5);
		cadeiras.add(ca6);
		cadeiras.add(ca7);
		cadeiras.add(ca8);
		cadeiras.add(ca9);
		cadeiras.add(ca10);

		// Curso cu1 = new Curso([Atributos]);
		// ...
		ArrayList<Cadeira> cadecu1 = new ArrayList<Cadeira>();
        ArrayList<Cadeira> cadecu2 = new ArrayList<Cadeira>();
        ArrayList<Cadeira> cadecu3 = new ArrayList<Cadeira>();
        ArrayList<Cadeira> cadecu4 = new ArrayList<Cadeira>();
        // cadeiras do curso 1
        cadecu1.add(ca1);
        cadecu1.add(ca8);
        cadecu1.add(ca3);
        cadecu1.add(ca4);
        cadecu1.add(ca2);
        // ...
        cadecu2.add(ca7);
        cadecu2.add(ca9);
        cadecu2.add(ca5);
        cadecu2.add(ca6);
        cadecu2.add(ca3);
        // ...
        cadecu3.add(ca4);
        cadecu3.add(ca10);
        cadecu3.add(ca9);
        cadecu3.add(ca2);
        cadecu3.add(ca3);
        // ...
        cadecu4.add(ca6);
        cadecu4.add(ca5);
        cadecu4.add(ca9);
        cadecu4.add(ca8);
        cadecu4.add(ca4);

        // Curso cu1 = new Curso("Nome do curso",(codigo do curso), (numero de horas),
        // "nome do regente de curso",(cadeiras ja la estao), (propinas));
       Curso cu1 = new Curso("Informatica Web", 4713, 251, "Nuno Garcia", cadecu1, 957.34);
        Curso cu2 = new Curso("Redes", 1838, 150, "Rogerio Berrincha", cadecu2, 687.94);
        Curso cu3 = new Curso("Engenharia Informatica", 2730, 220, "António Zubarrata", cadecu3, 980);
        Curso cu4 = new Curso("Segurança Informatica", 3940, 250, "Pedro Inácio", cadecu4,  1050);

        cursos.add(cu1);
        cursos.add(cu2);
        cursos.add(cu3);
        cursos.add(cu4);
		// Aluno a1 = new Aluno("nome do aluno",(curso em que ele esta
		// inscrito),(idade), (media));
		// ...
		Aluno a1 = new Aluno("André Pais", cu1, 19, 153,"Covilhã");
		Aluno a2 = new Aluno("Guilherme Nunes", cu2, 19, 115,"Fundão");
		Aluno a3 = new Aluno("Miguel Pereira", cu3, 20, 137,"Évora");
		Aluno a4 = new Aluno("Miguel Pais", cu4, 19, 153,"Covilhã");
		Aluno a5 = new Aluno("Desmond Newton", cu4, 23, 143,"Boston");
		Aluno a6 = new Aluno("Michael Yackson", cu2, 15, 140,"Texas");
		Aluno a7 = new Aluno("Patricia Goode", cu4, 18, 153,"Wall Street");
		Aluno a8 = new Aluno("Diogo Bataguas", cu1, 36, 152,"Almada");
		Aluno a9 = new Aluno("Morgan Freeman", cu2, 42, 200,"Marte");
		Aluno a10 = new Aluno("Mike Tyson", cu1, 45, 157,"New York");

		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		alunos.add(a4);
		alunos.add(a5);
		alunos.add(a6);
		alunos.add(a7);
		alunos.add(a8);
		alunos.add(a9);
		alunos.add(a10);

		// guardar cursos
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
}
