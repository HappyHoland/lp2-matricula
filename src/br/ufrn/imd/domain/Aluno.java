package br.ufrn.imd.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Aluno extends Pessoa {
	private String matricula;
	private double ira;
	private Curso curso;
	private List <Disciplina> disciplinas; 
	
	public Aluno() {
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
	public Aluno(String nome, String cpf, String matricula, Date dataDeNascimento, Curso curso) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDataDeNascimento(dataDeNascimento);
		this.curso = curso;
		this.matricula = matricula;
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getIra() {
		return ira;
	}

	public void setIra(double ira) {
		this.ira = ira;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public int horasPreenchidas() {
		int res = 0;
		
		for (Disciplina d : disciplinas) {
			res += d.getCargaHora();
		}
		
		return res;
	}
	
	public int solicitarMatricula(Disciplina d) {
		if (d == null) {
			return -1;
		} else if (disciplinas.contains(d)) {
			return -2;
		} else if (horasPreenchidas() + d.getCargaHora() > curso.getChMaxPorSemestre()) {
			return -3;
		} else {
			disciplinas.add(d);
			return 0;
		}
	}
	
	public int trancarMatricula(Disciplina d) {
		if (d == null) {
			return -1;
		} else if (!disciplinas.contains(d)) {
			return -2;
		} else {
			disciplinas.remove(d);
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "nome: " + getNome() + " matricula: " + matricula + "\n" + "curso: " + curso;
	}
}
