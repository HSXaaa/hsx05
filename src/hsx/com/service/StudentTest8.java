package hsx.com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hsx.com.model.Class;
import hsx.com.model.Student;
import hsx.com.util.HibernateUtil;

public class StudentTest8 {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession(); // ����һ��session
	    session.beginTransaction(); // ��������
	    
	    /*
	            ��ʱ״̬(transient)������ new ��䴴������û�б��־û������Ҳ����� Sesssion �Ļ����С�������ʱ״̬ �� Java���󱻳�Ϊ��ʱ����
	           �־û�״̬(persistent)���Ѿ����־û������Ҽ��뵽 Session �Ļ����С����ڳ־û�״̬�� Java ���󱻳�Ϊ�־û�����
	           ɾ��״̬(removed)�����ٴ��� Session �Ļ����У����� Session �Ѿ��ƻ���������ݿ���ɾ��������ɾ��״̬�� Java ���󱻳�Ϊɾ������
	          ����״̬(detached)���Ѿ����־û��������ٴ��� Session �Ļ����С���������״̬�� Java ���󱻳�Ϊ�������
	    */
	    
	    Class c1=new Class(); // ��ʱ����1
	    c1.setName("16��ͨ");
	    
	    Class c2=new Class();  // ��ʱ����2
	    c2.setName("16��ͨ6b");
	    
	    session.save(c1); // �־û�����
	    session.save(c2); // �־û�����
	    
	    session.delete(c2); // ɾ������
	    
	    session.getTransaction().commit(); // �ύ����
	    session.close(); // �ر�session
	    
	    System.out.println(c1.getName()); // �������
	    System.out.println(c2.getName()); // ɾ������
	}
}
