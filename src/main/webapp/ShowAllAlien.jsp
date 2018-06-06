<%@page import="com.alien.project.entity.Alien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! List<Alien> lAliens; 
		int index=0;
	%>
	<%
			/* 	out.println(request.getAttribute("AlienList")); */
				lAliens=(List<Alien>)request.getAttribute("Allalien");
		%>
		<table border=2>
			<tr>
					<td>Index</td>
					<td>Name</td>
					<td>Age</td>
					<td>Marks</td>
					<td>City</td>
			</tr>
			<%
					for(Alien alien:lAliens)
					{
				
			%>
				<tr>
						<td><%=++index %></td>
						<td><%=alien.getAlienName() %></td>
						<td><%=alien.getAge() %></td>
						<td><%=alien.getMarks() %></td>
						<td><%=alien.getCity() %></td>
				</tr>
			
			
			<%
					}
			index=0;
			%>
			
		</table>
		
		<form action="index.jsp">
	<input type="submit" value="Home">
	</form>

</body>
</html>