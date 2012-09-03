<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="au.edu.qut.INB372.AgileProjects.DataModel.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.MalformedURLException" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.GeneratedValue" %>
<%@ page import="javax.persistence.GenerationType" %>
<%@ page import="javax.persistence.Id" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INB/INN372 Class</title>
</head>
<body>
	<%
		String year = request.getParameter("year");
		EntityManager em = EMFSingleton.get().createEntityManager();
		AgileClass thisClass = null;
        try {
	        thisClass = em.find(AgileClass.class, year);
        }
        finally {
        	em.close();
        }
	%>
	<h1 align="center">Agile Software Development <% thisClass.getYear(); %></h1>
	<h2 align="center"><% thisClass.getProjectTitle(); %></h2>
	<% if (thisClass.getProjectDescription() != null) { %>
		<p>The project description can be found at <a href="<% thisClass.getProjectDescription(); %>"><% thisClass.getProjectDescription(); %></a></p>
	<% } %>
	
	<%
		Set<Team> teams = thisClass.getTeams();
		for (Team team : teams) {
	%>
			<p><a href="<% team.getProjectURL(); %>">Team <% team.getName(); %></a> <br />
			With team members: <br />
			<%
				for (Student student : team.getMembers()) {
			%>
					&nbsp;&nbsp;<% student.getFirstName(); %> <% student.getSurname(); %><br />
			<% } %>
			</p>
	<% } %>
</body>
</html>