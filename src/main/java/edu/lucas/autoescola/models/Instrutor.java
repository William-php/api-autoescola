package edu.lucas.autoescola.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrutor")
public class Instrutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instrutor_id")
	private Integer instrutorId;
	
	@Column(name = "instrutor_rg")
	private Integer rg;
	
	@Column(name = "instrutor_nascimento")
	private Date nascimento;
	
	@Column(name = "instrutor_titulacao")
	private Integer titulacao;
	
	@OneToMany(mappedBy = "instrutor")
	List<Turma> turmaList = new ArrayList<Turma>();
	
	public Instrutor() {}
	
	public Instrutor(Integer rg, Date nascimento, Integer titulacao) {
		this.rg = rg;
		this.nascimento = nascimento;
		this.titulacao = titulacao;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Integer titulacao) {
		this.titulacao = titulacao;
	}

	public List<Turma> getTurmaList() {
		return turmaList;
	}

	public void setTurmaList(List<Turma> turmaList) {
		this.turmaList = turmaList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(instrutorId, rg, titulacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Instrutor other = (Instrutor) obj;
		return Objects.equals(instrutorId, other.instrutorId) && Objects.equals(rg, other.rg)
				&& Objects.equals(titulacao, other.titulacao);
	}
	
	@Override
	public String toString() {
		return "Instrutor\n==========================================" +
				"\nRG: " + this.getRg() +
				"\nData de nascimento: " + this.getNascimento() +
				"\nTitulação: " + this.getTitulacao() + 
				"\nTurmas: " + this.turmaList.toString();
	}
	
}
