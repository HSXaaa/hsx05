package hsx.com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

public class StudentTest3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
		Student s=new Student();
		s.setName("陈钰琪");
		session.save(s);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
}
