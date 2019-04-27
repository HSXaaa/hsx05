package hsx.com.service;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hsx.com.model.Class;
import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

public class StudentTest7 {

	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private Session session;
	
	@Before 
	public void setUp() throws Exception {
		session=sessionFactory.openSession(); // ����һ��session
	    session.beginTransaction(); // ��������
	}
	
	@After
	public void tearDown() throws Exception {
		 session.getTransaction().commit(); // �ύ����
		 session.close(); // �ر�session
	}
	
/*	@Test
	public void testSaveClassAndStudent() {
	Class c=new Class();
	c.setName("16ͨ��");
	
	Student s1=new Student();
	s1.setName("������1");
	
	Student s2=new Student();
	s2.setName("������1");
	
	c.getStudents().add(s1);
	c.getStudents().add(s2);
	
	session.save(c);
	    
	}
	
	@Test
	public void getStudentsByClass(){
		Class c=(Class)session.get(Class.class, Long.valueOf(3));
		Set<Student> students=c.getStudents();
		Iterator<Student> it=students.iterator();
		while(it.hasNext()){
			Student s=(Student)it.next();
			System.out.println(s);
		}
	}
	
	@Test
	public void testAdd(){
		Class c=new Class();
	    c.setName("16��ͨ");
	    
	    Student s1=new Student();
	    s1.setName("������2");
	    
	    session.save(c);
	    session.save(s1);
	}
	
	@Test
	public void testInverse(){
		Class c=(Class)session.get(Class.class, Long.valueOf(6));
		Student s=(Student)session.get(Student.class, Long.valueOf(10));
		
		s.setC(c);
		c.getStudents().add(s);
	}

	@Test
	public void testDeleteClassCascade(){
		Class c=(Class)session.get(Class.class, Long.valueOf(6));
		session.delete(c);
	}*/
}
	

