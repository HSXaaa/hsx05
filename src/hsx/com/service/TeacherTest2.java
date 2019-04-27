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
	
	@Test
	public void testDelete() {
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(2));
	    session.delete(Teacher);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	@Test
	public void testUpdate() {
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
		Teacher Teacher=(Teacher)session.get(Teacher.class, Long.valueOf(3));
		Teacher.setName("张三2");
		session.save(Teacher);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	@Test
	public void testGetAllTeacher() {
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
}
