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

public class StudentTest9 {

	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private Session session;
	
	@Before
	public void setUp() throws Exception {
		session=sessionFactory.openSession(); // 生成一个session
	    session.beginTransaction(); // 开启事务
	}

	@After
	public void tearDown() throws Exception {
		 session.getTransaction().commit(); // 提交事务
		 session.close(); // 关闭session
	}

	@Test
	public void testSaveClassAndStudent() {
		Class c=new Class();
	    c.setName("16电科");
	   
	    Student s1=new Student();
	    s1.setName("陈钰琪");
	    s1.setC(c);
	    
	    Student s2=new Student();
	    s2.setName("邓紫棋");
	    s2.setC(c);
	   
	    session.save(s1);
	    session.save(s2);
	    
	}
	
	@Test
	public void testLoadClass(){
		// Class c=(Class)session.load(Class.class, Long.valueOf(2));
		Class c=(Class)session.load(Class.class, Long.valueOf(1));
		System.out.println(c.getStudents());
	}
	
	@Test
	public void testGetClass(){
		// Class c=(Class)session.get(Class.class, Long.valueOf(2));
		Class c=(Class)session.get(Class.class, Long.valueOf(4));
		System.out.println(c.getStudents());
	}
	
	@Test
	public void testUpdateClass(){
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		Class c=(Class)session1.get(Class.class, Long.valueOf(2));
		session1.getTransaction().commit(); // 提交事务
		session1.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		c.setName("16电通1");
		session2.update(c);
		session2.getTransaction().commit(); // 提交事务
		session2.close();
	}
	
	@Test
	public void testSaveOrUpdateClass(){
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		Class c=(Class)session1.get(Class.class, Long.valueOf(3));
		session1.getTransaction().commit(); // 提交事务
		session1.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		c.setName("16电通2");
		
		Class c2=new Class();
		c2.setName("16电通3");
		session2.saveOrUpdate(c);
		session2.saveOrUpdate(c2);
		session2.getTransaction().commit(); // 提交事务
		session2.close();
	}
	
	@Test
	public void testMergeClass(){
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		Class c=(Class)session1.get(Class.class, Long.valueOf(4));
		session1.getTransaction().commit(); // 提交事务
		session1.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		
		Class c2=(Class)session2.get(Class.class, Long.valueOf(4));
		c.setName("16电通4");
	
		session2.merge(c);

		session2.getTransaction().commit(); // 提交事务
		session2.close();
	}
	
	@Test
	public void testDeleteStudent(){
		Student student=(Student)session.load(Student.class, Long.valueOf(5));
		session.delete(student);
	}
	
}
