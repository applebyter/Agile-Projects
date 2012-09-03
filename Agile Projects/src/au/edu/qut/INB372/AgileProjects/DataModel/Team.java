package au.edu.qut.INB372.AgileProjects.DataModel;

import java.util.Set;
import java.util.HashSet;
import java.net.URL;
import java.net.MalformedURLException;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Key;


@Entity
public class Team {
	private Set<Student> members;
	private String name;
	private String projectTitle;
	@Basic private URL projectURL;
	@Basic private URL repositoryURL;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	public Team(String name, String projectTitle, String projectURL, String repositoryURL, Set<Student> members) {
		this.members = new HashSet(members);
		this.name = name;
		this.projectTitle = projectTitle;
		
		try {
			this.projectURL = new URL(projectURL);
		}
		catch (MalformedURLException e) {
			this.projectURL = null;
		}
		
		try {
			this.repositoryURL = new URL(repositoryURL);
		}
		catch (MalformedURLException e) {
			this.repositoryURL = null;
		}
		
	}
	
	public Team(String name, String projectTitle, String projectURL, String repositoryURL) {
		this.members = null;
		this.name = name;
		this.projectTitle = projectTitle;
		
		try {
			this.projectURL = new URL(projectURL);
		}
		catch (MalformedURLException e) {
			this.projectURL = null;
		}
		
		try {
			this.repositoryURL = new URL(repositoryURL);
		}
		catch (MalformedURLException e) {
			this.repositoryURL = null;
		}
		
	}
	
	public Set<Student> getMembers() {
		return members;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTitle() {
		return projectTitle;
	}
	
	public URL getProjectURL() {
		return projectURL;
	}
	
	public URL getRepositoryURL() {
		return repositoryURL;
	}
	
	public void addMember(Student newMember) {
		members.add(newMember);
	}
	
	public void removeMember(Student memberToRemove) {
		members.remove(memberToRemove);
	}
	
	public Key getKey() {
		return key;
	}
}
