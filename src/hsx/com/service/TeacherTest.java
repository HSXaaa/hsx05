package hsx.com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Teacher;
import hsx.com.util.HibernateUtil;


public class TeacherTest {

	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	public void add() {
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
	
	public void delete() {
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(1));
		session.delete(Teacher);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	public void update() {
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(2));
		Teacher.setName("GEM");
		session.save(Teacher);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	public void getAllTeacher() {
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
	
	public static void main(String[] args) {
		TeacherTest TeacherTest=new TeacherTest();
		//TeacherTest.add();
		//TeacherTest.delete();
		//TeacherTest.update();
		TeacherTest.getAllTeacher();
	}
}
