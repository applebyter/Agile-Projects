package au.edu.qut.INB372.AgileProjects.DataModel;

import com.google.appengine.api.datastore.Key;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student {
	private String studentNumber;
	private String firstName;
	private String surname;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	protected Student() { }
	
	public Student(String studentNumber, String firstName, String surname) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.surname = surname;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public Key getKey() {
		return key;
	}

}
