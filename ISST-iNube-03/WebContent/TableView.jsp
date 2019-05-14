<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Tabla de datos</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="css/pe-icon-7-stroke.css" rel="stylesheet" />
    
</head>
<body>
   
<div class="wrapper">
    <div class="sidebar" data-color="blue">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a class="simple-text">
                    iNube
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="BasicServlet?email=${user.email}">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <shiro:hasRole name="premium"><li>
                    <a href="PremiumServlet?email=${user.email}">
                        <i class="pe-7s-graph"></i>
                        <p>Comparativa</p>
                    </a>
                </li></shiro:hasRole>
                <li>
                    <a href="ProfileServlet?email=${user.email}">
                        <i class="pe-7s-user"></i>
                        <p>Mi Perfil</p>
                    </a>
                </li>
                <li class="active">
                    <a href="TableServlet?email=${user.email}">
                        <i class="pe-7s-note2"></i>
                        <p>Table List</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>
    
    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Tabla de datos</a>
                    
                </div>
                <div class="collapse navbar-collapse">
                       <img src="images/logo2.png">
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li>
                            <a href="LogoutView.jsp?email=${user.email }">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg"></li>
                    </ul>
                </div>
            </div>
        </nav>
    
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Mis transacciones</h4>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>Hora</th>
                                        <th>D�a</th>
                                    	<th>Mes</th>
                                        <th>Importe</th>
                                    	<th>Cliente</th>
                                        <th>Edad</th>
                                    	<th>Sexo</th>
                                        <th>C�digo postal</th>
                                    </thead>
                                    <tbody>
                                      	<c:forEach items="${terminal.transactions}" var="transactioni">
											<tr>
												<td>${transactioni.time }:00</td>
												<td>${transactioni.day }</td>
												<td>${transactioni.month }</td>
												<td>${transactioni.amount } euros</td>
												<td>${transactioni.client }</td>
												<td>${transactioni.age } a�os</td>
												<td>${transactioni.sex }</td>	
												<td>${transactioni.zipCode }</td>
											</tr>
										</c:forEach>  
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    

</body>

 <!--   Core JS Files   -->
    <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

</html>