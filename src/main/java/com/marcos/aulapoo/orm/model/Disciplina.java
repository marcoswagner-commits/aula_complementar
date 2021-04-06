package com.marcos.aulapoo.orm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DISCIPLINAS")
public class Disciplina {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="disciplina_id")
	private Integer id;
	
	@Column(name="nome_disciplina", nullable = false)
	private String nome;
	
	private Integer carga_horaria;
	
	@ManyToMany
	@JoinTable(name="DISCIPLINAS_ALUNOS", 
	           joinColumns = @JoinColumn(name="disciplina_id"),
	           inverseJoinColumns = @JoinColumn(name="aluno_id"))
	@JsonIgnore
	private List<Aluno> alunos = new ArrayList<>();
	
	public Disciplina() {
		
	}

	public Disciplina(Integer id, String nome, Integer carga_horaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.carga_horaria = carga_horaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCarga_horaria() {
		return carga_horaria;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
