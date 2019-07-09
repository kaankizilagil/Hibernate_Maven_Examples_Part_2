package edu.aydin.db.hibonetomanyuni;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import edu.aydin.db.hibonetomanyuni.Employee;
//import edu.aydin.db.hibonetomanyuni.Account;

public class App 
{
    public static void main( String[] args )
    {
    	Transaction transaction = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        Account acct1 = new Account();
        acct1.setAcctNumber("acct1 number");
        
        Account acct2 = new Account();
        acct2.setAcctNumber("acct2 number");
        
        Account acct3 = new Account();
        acct3.setAcctNumber("acct3 number");
        
        Set<Account> acctsEmp1 = new HashSet<Account>();
        
        acctsEmp1.add(acct1);
        acctsEmp1.add(acct2);
        
        
        Set<Account> acctsEmp2 = new HashSet<Account>();
        acctsEmp2.add(acct3);
        
        Employee emp1 = new Employee("emp1@xxx.com", "emp1Name", acctsEmp1);
        Employee emp2 = new Employee("emp2@xxx.com", "emp2Name", acctsEmp2);
        
        //acct1.setEmployee(emp1);
        //acct2.setEmployee(emp1);
        //acct3.setEmployee(emp2);
        
        session.save(emp1);
        session.save(emp2);
       
        transaction.commit();
        
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> emps = session.createQuery("from Employee", Employee.class).list();
        
        for(Employee anEmp: emps) {
        	System.out.printf("%s, %s ", anEmp.getName(), anEmp.getEmail());
        	
        	for(Account acct: anEmp.getAccounts())
        		System.out.printf("%s\n", acct.getAcctNumber());
        }
    }
}
