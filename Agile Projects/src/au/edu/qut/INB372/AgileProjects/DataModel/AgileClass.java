package au.edu.qut.INB372.AgileProjects.DataModel;

import java.util.Set;
import java.util.HashSet;
import java.net.URL;
import java.net.MalformedURLException;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Id;


@Entity
public class AgileClass {
	@Id private int year;
	private int semester;
	private String projectTitle;
	@Basic private URL projectDescription;
	private Set<Team> teams;
	
	public AgileClass (int year, int semester, String projectTitle, String projectDescriptionURL, Set<Team> teams) {
		this.year = year;
		this.semester = semester;
		this.projectTitle = projectTitle;
		this.teams = new HashSet(teams);
	
		try {
			this.projectDescription = new URL(projectDescriptionURL);
		}
		catch (MalformedURLException e) {
			this.projectDescription = null;
		}
	}
	
	public AgileClass (int year, int semester, String projectTitle, String projectDescriptionURL) {
		this.year = year;
		this.semester = semester;
		this.projectTitle = projectTitle;
		this.teams = new HashSet();
	
		try {
			this.projectDescription = new URL(projectDescriptionURL);
		}
		catch (MalformedURLException e) {
			this.projectDescription = null;
		}
	}
	
	public int getYear() {
		return year;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public String getProjectTitle() {
		return projectTitle;
	}
	
	public URL getProjectDescription () {
		return projectDescription;
	}
	
	public Set<Team> getTeams() {
		return teams;
	}
	
	public void addTeam (Team newTeam) {
		teams.add(newTeam);
	}
	
	public void removeTeam (Team teamToRemove) {
		teams.remove(teamToRemove);
	}
	
}
