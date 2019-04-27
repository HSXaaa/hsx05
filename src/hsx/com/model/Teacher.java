package hsx.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*注解版CRUD实现*/
@Entity //实体
@Table(name="t_teacher") //映射到表t_teacher
public class Teacher {

	private long id;
	private String name;
	
	@Id   //表示主键
	@GeneratedValue(generator="_native")   
	@GenericGenerator(name="_native",strategy="native")//主键生成策略
	
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
