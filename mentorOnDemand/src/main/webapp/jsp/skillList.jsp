<%@page import="com.example.mentorOnDemand.model.Skill"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>Stock</title>
</head>
<body>
	<div>
		<div class="topnav">
                <a class="active" href="#home">Mentor On Demand</a>
            <a href="/addSkill">Technology</a>
            <a href="/userdb">Users</a>
            <a href="/mentordb">Mentors</a>
            <a href="#others">Payments</a>
            <a href="#logout">Logout</a>
        </div>


	</div>
	<%
		List skillList = (List) request.getAttribute("skillList");
		System.out.println(skillList);
	%>
	<div>
		<h2 id="list">Technologies</h2>
	</div>
	<div>



		<table border="1" align="center" id="table"
			class="table table-bordered">

			<thead class="thead">
				<td>Id</td>
				<td>Technologies</td>
				<td>Fees</td>
				<td>Action</td>
			</thead>

			<%
				for (int i = 0; i < skillList.size(); i++) {
					Skill e = (Skill) skillList.get(i);
			%>
			<tr>
				<td><%=e.getSkillId()%></td>
				<td><%=e.getTechnology()%></td>
				<td><%=e.getFees()%></td>
				
				<td><div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a href="/update?skillId=<%=e.getSkillId()%>"
								class="btn btn-warning">Update</a> <a
								href="delete?id=<%=e.getSkillId()%>"
								class="btn btn-warning">Delete</a>
						</div>
					</div></td>
				


			</tr>
			<%
				}
			%>

		</table>
	</div>
	<div class="copy">
		<footer>
		<h5>Copyrights &copy 2019</h5>
		</footer>
	</div>
</body>
</html>