<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"type="text/css" href="css/styles.css">
    <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Mentor</title>
</head>
<body>
 <div>
        <div class="topnav">
                <a class="active" href="#home">Mentor On Demand</a>
            <a href="#/searchMentor">Search Training</a>
            <a href="#compare">Current Training</a>
            <a href="#sectors">Completed Training</a>
            <a href="#others">Notification</a>
            <a href="#logout">Logout</a>
        </div>
 <form:form class="form-horizontal" method="POST" action="/searchMentor1" modelAttribute="search">
 <div class="form-group " align=right>
                    
                    <div class="col-sm-2" align=right>
                   
                        <form:input class="form-control" name="user" path="technology" type="text" />
                        <button class="btn btn-warning" type="submit" >
							<i class="fa fa-search"></i>
						</button>
                    </div>
                </div>
 </form:form>
    </div>
    <div class="copy">
        <footer>Copyrights &copy 2019</footer>
    </div>
</body>
</html>