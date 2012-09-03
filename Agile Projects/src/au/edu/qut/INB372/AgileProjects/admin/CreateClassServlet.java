package au.edu.qut.INB372.AgileProjects.admin;

import au.edu.qut.INB372.AgileProjects.DataModel.*;

import java.lang.NumberFormatException;
import java.io.IOException;
import javax.servlet.http.*;
import javax.persistence.EntityManager;


public class CreateClassServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String year = request.getParameter("year");
        String semester = request.getParameter("semester");
        String projectTitle = request.getParameter("title");
        String projectDescription = request.getParameter("description");
        
        int numericYear;
        int numericSemester;
        
        try {
        	numericYear = Integer.parseInt(year);
        }
        catch (NumberFormatException e) {
        	numericYear = -1;
        }
        try {
        	numericSemester = Integer.parseInt(semester);
        }
        catch (NumberFormatException e) {
        	numericSemester = 0;
        }
        
        AgileClass newClass = new AgileClass(numericYear, numericSemester, projectTitle, projectDescription);
        
        EntityManager em = EMFSingleton.get().createEntityManager();
        try {
	        em.persist(newClass);
        }
        finally {
        	em.close();
        }
        
        response.sendRedirect("/displayClass.jsp?classID=" + newClass.getYear());
    }

}
