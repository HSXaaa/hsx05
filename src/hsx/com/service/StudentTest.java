package hsx.com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

/*XML版CRUD实现*/
public class StudentTest{

	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	private void add(){
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
	    Student s=new Student();
	    s.setName("周杰伦");
	    session.save(s);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	private void delete(){
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
	    Student student=(Student)session.get(Student.class, Long.valueOf(1));
	    session.delete(student);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	private void update(){
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
	    Student student=(Student)session.get(Student.class, Long.valueOf(2));
	    student.setName("张三2");
	    session.save(student);
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	private void getAllStudent(){
		/*生成一个session*/
		Session session=sessionFactory.openSession();
		/*开启事务*/
		session.beginTransaction();
		
	    String hql="from Student";
	    Query query=session.createQuery(hql);
	    @SuppressWarnings("unchecked")
		List<Student> studentList=query.list();
	    for(Student student:studentList){
	    	System.out.println(student);
	    }
		
		/*提交事务*/
		session.getTransaction().commit();
		/*关闭session*/
		session.close();
	}
	
	public static void main(String[] args) {
		StudentTest studentTest=new StudentTest();
		studentTest.add();
		//studentTest.delete();
		//studentTest.update();
	    //studentTest.getAllStudent();
	}
}
