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
        Student student1 = new Student("Fatih", "Citiriki", "fatih@gmail.com", new Phone("222-3456789"));
        Student student2 = new Student("Kivanc", "Yazici", "kivanc@gmail.com", new Phone("333-1234567"));
        
        Transaction transaction = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
       
        session.save(student1);
        session.save(student2);
        
        student1.setFirstName("Mehmet");
        student1.setLastName("Guvercin");
        
        session.delete(student1);
        
        transaction.commit();
        
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        
        for(Student stud: students)
        	System.out.println(stud.getFirstName());
    }
}
