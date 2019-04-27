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
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
		Teacher s=new Teacher();
		s.setName("邓紫棋");
		session.save(s);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	public void delete() {
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(1));
		session.delete(Teacher);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	public void update() {
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(2));
		Teacher.setName("GEM");
		session.save(Teacher);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	public void getAllTeacher() {
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
        String hql="from Teacher";
        Query query=session.createQuery(hql);
        @SuppressWarnings("unchecked")
		List<Teacher> TeacherList=query.list();
        for(Teacher Teacher:TeacherList) {
        	System.out.println(Teacher);
        }
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
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
