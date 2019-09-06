<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
        integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
        integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <title>Signup</title>
</head>
<body>
<div class="container-fuild">
            <div class="topnav1">
                    <label class="active">Stock Market <i class="fa fa-line-chart" style="color:black"></i>
                    </label>
                </div>
                <div class="card" id="card">
                        <div class="card-body" id="cbody">
     <form:form class="form-horizontal" method="POST" action="/mentorRegister" modelAttribute="mentor">
            
             <div class="Absolute-Center is-Responsive"> 
                    
                    <h2 id="h3" style="margin-left: 220px;">SignUp</h2><br><br>
                <div class="form-group ">
                    <label class="control-label col-sm-2" for="id1">Name</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="name" type="text" />
                        
                    </div>
                </div>
                <div class="form-group ">
                    <label class="control-label col-sm-2" for="id">Address</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="address" type="text" />
                        
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id2">Email</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="email" type="text" id="email"/>
                       
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id2">Mobile Number</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="phoneNumber" type="text" id="mobile"/>
                        
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id2">LinkedIn Url</label>
                    <div class="col-sm-4">
                       <form:input class="form-control" path="linkedIn" type="text" id="linked"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id2">Experience</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="experience" type="text" id="mobile"/>
                        
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id2">Technology</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="technology" type="text" id="tech"/>
                        
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id2">slotTime</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="slotTime" type="text" id="slot"/>
                       
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id2">Password</label>
                    <div class="col-sm-4">
                        <form:input class="form-control" path="password" type="password" id="pwd"/>
                       
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                   
                    <input type="submit" id="save" value="SignUp" class="btn btn-warning">
                </div>
                </div>
                </div>
           
        </form:form>  </div></div>
    </div>
   
    <div class="copy">
        <footer><h3>Copyrights &copy 2019</h3></footer>
    </div>
</body>
</html>