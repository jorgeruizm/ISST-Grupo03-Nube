<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Mi Perfil</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="css/demo.css" rel="stylesheet" />


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
                <li class="active">
                    <a href="ProfileServlet?email=${user.email }">
                        <i class="pe-7s-user"></i>
                        <p>Mi Perfil</p>
                    </a>
                </li>
                <li>
                    <a href="TableServlet?terminal=${user.business.tpv.id}">
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
                    <a class="navbar-brand" href="#">Mi Perfil</a>
                </div>
                <div class="collapse navbar-collapse">
                      <img src="images/logo2.png">

                    <ul class="nav navbar-nav navbar-right">
                        
                        <li>
                            <a href="LogoutView.jsp?email=${user.email}">
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
                    <div class="col-md-16">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Información acerca del perfil</h4>
                            </div>
                            <div class="content">
                                <form action= "UpdateProfileServlet" method= "post">
                                
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Nombre del negocio</label>
                                                <input type="text" class="form-control" disabled placeholder="nombre del negocio" value="${user.business.merchant}">
                                            </div>
                                        </div>
                                     </div>   
                                        
                                    <div class="row">    
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Código postal</label>
                                                <input type="text" class="form-control" placeholder="${user.business.zipCode}" value="${user.business.zipCode}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>CNAE</label>
                                                <input type="text" class="form-control" placeholder="${user.business.cnae}" value="${user.business.cnae}">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Contraseña</label>
                                                <input type="password" name= "password" class="form-control" placeholder="contraseña" value="qwerty">
                                            </div>
                                        </div>
                                    </div>    
                                        
                                    <div class="row">     
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Correo electrónico</label>
                                                <input type="text" class="form-control" disabled placeholder="correo" value="${user.email}">
                                            </div>
                                        </div>
                                    </div>

                                  
                                    <input type= "hidden" value="${user.email}" name ="email"/>
                                    <button type="submit" class="btn btn-info btn-fill pull-right">Actualizar perfil</button>
                                    <div class="clearfix"></div>
                                </form>
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