package edu.aydin.db.hibotou.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String number;

	@OneToOne(mappedBy="phone")
	private Student student;
	
	public Phone(){
		
	}
	
	public Phone(String number){
		this.number = number;
	}
	
	public int getId() {
		return id;
	}

	/*
	public void setId(int id) {
		this.id = id;
	}
	*/

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
