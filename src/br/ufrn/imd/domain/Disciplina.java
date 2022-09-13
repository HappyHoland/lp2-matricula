package br.ufrn.imd.domain;

import java.util.Objects;

public class Disciplina {
	
	private int id;
	private String descricao;
	private int cargaHora;
	private Pessoa professor;
	private Curso curso;
	
	public Disciplina() {}
	
	public Disciplina(int id, String descricao, Pessoa professor, Curso curso) {
		this.descricao = descricao;
		this.professor = professor;
		this.curso = curso;
		this.cargaHora = 60;
		this.id = id;
	}
	
	public Disciplina(String descricao, Pessoa professor, Curso curso, int cargaHora) {
		this.descricao = descricao;
		this.professor = professor;
		this.curso = curso;
		this.cargaHora = cargaHora;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCargaHora() {
		return cargaHora;
	}
	public void setCargaHora(int cargaHora) {
		this.cargaHora = cargaHora;
	}

	public Pessoa getProfessor() {
		return professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return this.id + " - " + this.descricao + " - curso: " + this.curso + " docente: " + this.professor.getNome();
	}
	
}
