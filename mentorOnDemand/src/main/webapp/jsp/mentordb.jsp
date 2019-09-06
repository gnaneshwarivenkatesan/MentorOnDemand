<%@page import="com.example.mentorOnDemand.model.User"%>
<%@page import="com.example.mentorOnDemand.model.Mentor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Mentor</title>
</head>
<body>
	<div>
		<div class="topnav">
			<a class="active" href="#home">Mentor On Demand</a> <a href="/addSkill">Technology</a>
			<a href="/userdb">Users</a> <a href="/mentordb">Mentors</a> <a
				href="#others">Payments</a> <a href="#logout">Logout</a>
		</div>
		<%
			List mentordb = (List) request.getAttribute("mentordb");
			System.out.println(mentordb);
		%>
		<div>
			<h2 id="list">List of Mentors</h2>
		</div>
		<div>



			<table border="1" align="center" id="table"
				class="table table-bordered">

				<thead class="thead">
					<td>RegCode</td>
					<td>Name</td>
					<td>Address</td>
					<td>Email</td>
					<td>Phone</td>
					<td>Technology</td>
					<td>Action</td>

				</thead>

				<%
					for (int i = 0; i < mentordb.size(); i++) {
						Mentor e = (Mentor) mentordb.get(i);
				%>
				<tr>
					<td><%=e.getRegCode()%></td>
					<td><%=e.getName()%></td>
					<td><%=e.getAddress()%></td>
					<td><%=e.getEmail()%></td>
					<td><%=e.getPhoneNumber()%></td>
					<td><%=e.getTechnology()%></td>
<% boolean b= e.isActive();
boolean a=false;
if(a==b)
{
%>
					<td><div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a href="/blockmentor?id=<%=e.getRegCode()%>" class="btn btn-warning">Block</a>


							</div>
						</div></td>
<%}else{ %>

<td><div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a href="/Unblockmentor?id=<%=e.getRegCode()%>" class="btn btn-warning">UnBlock</a>


							</div>
						</div></td><%} %>
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</div>
	<div class="copy">
		<footer>Copyrights &copy 2019</footer>
	</div>
</body>
</html>