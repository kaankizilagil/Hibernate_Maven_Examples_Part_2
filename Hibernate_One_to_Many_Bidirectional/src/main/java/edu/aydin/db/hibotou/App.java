package edu.aydin.db.hibotou;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.aydin.db.hibotou.entity.Student;
import edu.aydin.db.hibotou.util.HibernateUtil;
import edu.aydin.db.hibotou.entity.Phone;

public class App 
{
    public static void main( String[] args )
    {
        Student student1 = new Student("Mehmet", "Caliskan", "mehmet@gmail.com", new Phone("222-3456789"));
        Student student2 = new Student("Kaan", "Efendi", "kaan@gmail.com", new Phone("333-1234567"));
        
        Transaction transaction = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
       
        session.save(student1);
        session.save(student2);
        
        session.save(new Phone("111-1112233"));
        transaction.commit();
        
        session = HibernateUtil.getSessionFactory().openSession();
        List<Phone> phones = session.createQuery("from Phone", Phone.class).list();
        
        for(Phone phone: phones)
        	System.out.println(phone.getNumber());
    }
}
