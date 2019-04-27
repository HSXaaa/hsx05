package hsx.com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

public class StudentTest3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
		Student s=new Student();
		s.setName("������");
		session.save(s);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
}
