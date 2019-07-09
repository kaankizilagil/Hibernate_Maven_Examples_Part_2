package edu.aydin.db.hibonetomanyuni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private int id;
	
	private String acctNumber;
	
	//@ManyToOne
	//private Employee employee;

	public int getId() {
		return id;
	}

	Account(){
		
	}
	
	Account(String acctNum){//, Employee emp){
		this.acctNumber = acctNum;
		//this.employee = emp;
	}
	
	/*public void setId(int id) {
		this.id = id;
	}*/

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	/*public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/
}
