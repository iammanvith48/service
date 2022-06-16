package springboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "task_seq")
	@SequenceGenerator(initialValue = 5, name = "task_seq", sequenceName = "employee_sequence")
	@Column(name="id")
	private Integer id;
	@Column(name="discrption")
	private String discrption;
	@Column(name="priority")
	private long priority;
	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDiscrption() {
		return discrption;
	}
	public void setDiscrption(String discrption) {
		this.discrption = discrption;
	}
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	public User(Integer id, String discrption, long priority) {
		super();
		this.id = id;
		this.discrption = discrption;
		this.priority = priority;
	}
	
	public User()
	{
		
	}

}