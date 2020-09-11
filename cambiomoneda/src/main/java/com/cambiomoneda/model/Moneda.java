package com.cambiomoneda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "moneda")
public class Moneda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cod_moneda;	
	
	private double tipocambio;
	
	public Moneda () {
			
	}
	
	public Moneda(long cod_moneda, double tipocambio) {
		super();
		this.cod_moneda = cod_moneda;
		this.tipocambio = tipocambio;
	}
	
	public long getCod_moneda() {
		return cod_moneda;
	}
	public void setCod_moneda(long cod_moneda) {
		this.cod_moneda = cod_moneda;
	}
	public double getTipocambio() {
		return tipocambio;
	}
	public void setTipocambio(double tipocambio) {
		this.tipocambio = tipocambio;
	}
	
	
}
