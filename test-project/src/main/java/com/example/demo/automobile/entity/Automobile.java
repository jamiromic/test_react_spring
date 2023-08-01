package com.example.demo.automobile.entity;

import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "automobili")
public class Automobile {
	
	//Attributi
	
	// Indichiamo la chiave primaria
	@Id
	
	@SequenceGenerator(allocationSize = 1, name = "automobili_seq", sequenceName = "automobili_seq")
	// Diciamo di generare la chiave primaria in autoincrement e unique
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "automobili_seq")
	
	@Column(name = "id")
    private Long id;
	
	@Column(name = "marca")
	private String marca = "";
	
	@Column(name = "alimentazione")
	private String alimentazione = "";
	
	@Column(name = "colore")
	private String colore = "";
	
	@Column(name = "annoImmatricolazione")
	private int annoImmatricolazione = 0;
	
	//Costruttore Vuoto
	public Automobile() {
		
	}
	
	//Costruttore
	public  Automobile(String marca, String alimentazione, String colore, int annoImmatricolazione ) {
		this.marca = marca;
		this.alimentazione = alimentazione;
		this.colore = colore;
		this.annoImmatricolazione = annoImmatricolazione;
	}
	
	//Getter e Setter
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	//Altri metodi
	@Override
	public int hashCode() {
		return Objects.hash(alimentazione, annoImmatricolazione, colore, marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automobile other = (Automobile) obj;
		return Objects.equals(alimentazione, other.alimentazione) && annoImmatricolazione == other.annoImmatricolazione
				&& Objects.equals(colore, other.colore) && Objects.equals(marca, other.marca);
	}

	@Override
	public String toString() {
		return "Automobile [marca=" + marca + ", alimentazione=" + alimentazione + ", colore=" + colore
				+ ", annoImmatricolazione=" + annoImmatricolazione + "]";
	}
	
	
	

}
