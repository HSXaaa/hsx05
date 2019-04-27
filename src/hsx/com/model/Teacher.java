package hsx.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*ע���CRUDʵ��*/
@Entity //ʵ��
@Table(name="t_teacher") //ӳ�䵽��t_teacher
public class Teacher {

	private long id;
	private String name;
	
	@Id   //��ʾ����
	@GeneratedValue(generator="_native")   
	@GenericGenerator(name="_native",strategy="native")//�������ɲ���
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
}
