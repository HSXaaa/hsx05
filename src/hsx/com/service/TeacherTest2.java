package hsx.com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import hsx.com.model.Teacher;
import hsx.com.util.HibernateUtil;

public class TeacherTest2 {

	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	@Test
	public void testAdd() {
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
		Teacher s=new Teacher();
		s.setName("������");
		session.save(s);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	@Test
	public void testDelete() {
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(2));
	    session.delete(Teacher);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	@Test
	public void testUpdate() {
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(3));
		Teacher.setName("����2");
		session.save(Teacher);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	@Test
	public void testGetAllTeacher() {
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
        String hql="from Teacher";
        Query query=session.createQuery(hql);
        @SuppressWarnings("unchecked")
		List<Teacher> TeacherList=query.list();
        for(Teacher Teacher:TeacherList) {
        	System.out.println(Teacher);
        }
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();		
	}
}
