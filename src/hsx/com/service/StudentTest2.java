package hsx.com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

public class StudentTest2 {
    
	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
		Student s1=(Student)session.get(Student.class, Long.valueOf(1));
		Student s2=(Student)session.get(Student.class, Long.valueOf(2));
		Student s3=(Student)session.get(Student.class, Long.valueOf(1));
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
}
