package hsx.com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

/*XML��CRUDʵ��*/
public class StudentTest{

	private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	private void add(){
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
	    Student s=new Student();
	    s.setName("�ܽ���");
	    session.save(s);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	private void delete(){
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
	    Student student=(Student)session.get(Student.class, Long.valueOf(1));
	    session.delete(student);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	private void update(){
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
	    Student student=(Student)session.get(Student.class, Long.valueOf(2));
	    student.setName("����2");
	    session.save(student);
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
		session.close();
	}
	
	private void getAllStudent(){
		/*����һ��session*/
		Session session=sessionFactory.openSession();
		/*��������*/
		session.beginTransaction();
		
	    String hql="from Student";
	    Query query=session.createQuery(hql);
	    @SuppressWarnings("unchecked")
		List<Student> studentList=query.list();
	    for(Student student:studentList){
	    	System.out.println(student);
	    }
		
		/*�ύ����*/
		session.getTransaction().commit();
		/*�ر�session*/
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
