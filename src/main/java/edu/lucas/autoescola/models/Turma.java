package edu.lucas.autoescola.models;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "turma_id")
	private Integer turmaId;
	
	@Column(name = "turma_horario")
	private Time horario;
	
	@Column(name = "turma_duracao")
	private Integer duracao;
	
	@Column(name = "turma_data_inicio")
	private Date dataInicio;
	
	@Column(name = "turma_data_fim")
	private Date dataFim;
	
	@ManyToOne
	@JoinColumn(name = "instrutor_id", referencedColumnName = "instrutor_id")
	private Instrutor instrutor;
	
	public Turma() {}
	
	public Turma(Time horario, Integer duracao, Date dataInicio, Date dataFim) {
		this.horario = horario;
		this.duracao = duracao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;				
	}
	
	
	
	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(instrutor, turmaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Turma other = (Turma) obj;
		return Objects.equals(instrutor, other.instrutor) && Objects.equals(turmaId, other.turmaId);
	}

	@Override
	public String toString() {
		return "Horario: " + this.horario +
				"\nDuracao: " + this.duracao +
				"\nData Início: " + this.dataInicio +
				"\nData Fim: " + this.dataFim + "\n\n";				
	}
}
