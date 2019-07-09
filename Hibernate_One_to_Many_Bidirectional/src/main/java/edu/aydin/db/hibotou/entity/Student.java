package edu.aydin.db.hibotou.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	//A property of Phone ONLY in the Student class
	//One to One relationship (unidirectional)
	//Unidirectional since the Phone class does not 
	//maintain any reference to the Student class
	//Each phone object can be reached from its respective
	//Student object but not vice versa.
	@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	private Phone phone;
	
	public Student(){
		
	}
	
	public Student(String fn, String ln, String em, Phone phone){
		this.firstName = fn;
		this.lastName = ln;
		this.email = em;
		this.phone = phone;
	}
	
	public Phone getPhone() {
		return phone;
	}
	
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	
	/*
	public void setId(int id) {
		this.id = id;
	}
	*/
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
