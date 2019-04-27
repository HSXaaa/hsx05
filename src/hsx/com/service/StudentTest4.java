package hsx.com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Class;
import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

public class StudentTest4 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		//生成一个session
		Session session=sessionFactory.openSession();
		//开启事务
		session.beginTransaction();
		
		Class c=new Class();
		c.setName("16电科");
		session.save(c);
		
		Student s1=new Student();
		s1.setName("陈钰琪");
		s1.setC(c);
		
		Student s2=new Student();
		s2.setName("邓紫棋");
		s2.setC(c);
		
		session.save(s1);
		session.save(s2);
		
		//提交事务
		session.getTransaction().commit();
		//关闭session
		session.close();
	}
}
