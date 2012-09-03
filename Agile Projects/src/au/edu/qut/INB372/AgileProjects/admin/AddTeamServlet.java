package au.edu.qut.INB372.AgileProjects.admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.qut.INB372.AgileProjects.DataModel.*;


public class AddTeamServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String teamName = request.getParameter("name");
        String projectTitle = request.getParameter("title");
        String projectURL = request.getParameter("projectURL");
        String repositoryURL = request.getParameter("repositoryURL");
        
        Team newTeam = new Team(teamName, projectTitle, projectURL, repositoryURL);
        
        EntityManager em = EMFSingleton.get().createEntityManager();
		AgileClass thisClass = null;
		try {
	        thisClass = em.find(AgileClass.class, "2012");
	        thisClass.addTeam(newTeam);
	        em.persist(thisClass);
        }
        finally {
        	em.close();
        }
        
        response.sendRedirect("/displayClass.jsp?classID=" + thisClass.getYear());
    }

}
