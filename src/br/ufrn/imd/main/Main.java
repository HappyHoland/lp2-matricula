package br.ufrn.imd.main;

import java.util.Calendar;
import java.util.Scanner;

import br.ufrn.imd.domain.Aluno;
import br.ufrn.imd.domain.Curso;
import br.ufrn.imd.domain.Disciplina;
import br.ufrn.imd.domain.Pessoa;

public class Main {

	public static void main(String[] args) {
		Aluno user = new Aluno();
		Pessoa professor = new Pessoa();
		Curso curso = new Curso();
		int escolha, result;
		Calendar dOB = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		boolean end = false;
		
		try {
		
			System.out.println("Informe o nome do aluno:");
			user.setNome(sc.nextLine());
		
			System.out.println("Informe o cpf do aluno:");
			user.setCpf(sc.nextLine());
		
			System.out.println("Informe o ano de nascimento:");
			dOB.set(Calendar.YEAR, sc.nextInt());
		
			System.out.println("Informe o mes de nascimento:");
			dOB.set(Calendar.MONTH, sc.nextInt());
		
			System.out.println("Informe o dia de nascimento:");
			dOB.set(Calendar.DATE, sc.nextInt());
		
			user.setDataDeNascimento(dOB.getTime());
		
			System.out.println("Informe a matricula:");
			user.setMatricula(sc.nextLine()+ sc.nextLine());
			
			System.out.println("Informe o ira do aluno:");
			user.setIra(sc.nextDouble());
			
			System.out.println("Informe o curso: ");
			curso.setDescricao(sc.nextLine() + sc.nextLine());
			
			user.setCurso(curso);
			
			while (!end) {
				Disciplina d = new Disciplina();
				
				System.out.println("Escolha uma alternativa: ");
				System.out.println("1 - Matricular numa disciplina");
				System.out.println("2 - Trancar uma disciplina");
				System.out.println("0 - Sair");
				
				do {
					escolha = sc.nextInt();
				}while (escolha > 2 || escolha < 0);
				
				switch (escolha) {
					case 1:
						
						System.out.println("Informe o nome da disciplina:");
						d.setDescricao(sc.nextLine() + sc.nextLine());
						
						System.out.println("Informe a id da disciplina:");
						d.setId(sc.nextInt());
						
						System.out.println("Informe a carga horaria da disciplina:");
						d.setCargaHora(sc.nextInt());
						
						System.out.println("Informe o professor:");
						professor.setNome(sc.nextLine() + sc.nextLine());
						d.setProfessor(professor);
						
						d.setCurso(curso);
						
						result = user.solicitarMatricula(d);
						
						switch (result) {
							case 0: 
								System.out.println("Matricula feita com sucesso.");
								break;
								
							case -1:
								System.out.println("Disciplina invalida.");
								break;
								
							case -2:
								System.out.println("O aluno ja esta matriculado nesta disciplina.");
								break;
								
							case -3:
								System.out.println("O aluno ultrapassou a sua carga horaria limite.");
								break;
						}
						
						break;
					
					case 2: 
						System.out.println("Informe a id da disciplina:");
						d.setId(sc.nextInt());
						
						result = user.trancarMatricula(d);
						
						switch (result) {
						case 0: 
							System.out.println("Matricula trancada com sucesso.");
							break;
							
						case -1:
							System.out.println("Disciplina invalida.");
							break;
							
						case -2:
							System.out.println("O aluno nao esta matriculado nesta disciplina.");
							break;
						}
					
						break;
					case 0:
						System.out.println("Saindo... \n");
						end = true;
				}
			}
			
			System.out.println(user);
			
			for (Disciplina dis : user.getDisciplinas()) {
				System.out.println(dis);
			}
		
		} finally {
			sc.close();
		}
		
	}

}
