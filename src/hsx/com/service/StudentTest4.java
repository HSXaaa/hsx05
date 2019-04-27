package hsx.com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Class;
import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

public class StudentTest4 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		//����һ��session
		Session session=sessionFactory.openSession();
		//��������
		session.beginTransaction();
		
		Class c=new Class();
		c.setName("16���");
		session.save(c);
		
		Student s1=new Student();
		s1.setName("������");
		s1.setC(c);
		
		Student s2=new Student();
		s2.setName("������");
		s2.setC(c);
		
		session.save(s1);
		session.save(s2);
		
		//�ύ����
		session.getTransaction().commit();
		//�ر�session
		session.close();
	}
}
