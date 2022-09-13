package br.ufrn.imd.domain;

public class Curso {
	
	private int id;
	private String descricao;
	private int chMaxPorSemestre;
	
	public Curso() {
		this.chMaxPorSemestre = 360;
	}
	
	public Curso(String descricao) {
		this.descricao = descricao;
		this.chMaxPorSemestre = 360;
	}
	
	public Curso(String descricao, int chMaxPorSemestre) {
		this.descricao = descricao;
		this.chMaxPorSemestre = chMaxPorSemestre;
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

	public int getChMaxPorSemestre() {
		return chMaxPorSemestre;
	}

	public void setChMaxPorSemestre(int chMaxPorSemestre) {
		this.chMaxPorSemestre = chMaxPorSemestre;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
}
