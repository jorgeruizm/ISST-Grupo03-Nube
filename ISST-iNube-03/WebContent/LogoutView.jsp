<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap-theme.min.css">
    
    <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/login.css">
    
</head>
<body>
<shiro:user>
<div id="containerMain">

    <div id="header">
        <div id="title">
            <a >iNube</a>
            <img src="images/logo2.png">
        </div>

        <div id="navBar">
            <div class="navBarItem"><a href="BasicServlet?email=${user.email }">Mis gráficas</a></div>
            <div class="navBarItem"><a href="ComparativaView.jsp">Comparativa mercado</a></div>
            
            <div class="navBarItem"><a href="ProfileServlet?email=${user.email }">Mi Perfil</a></div>	
            <div class="navBarItem"><a href="LogoutView.jsp">Logout</a></div>
        </div>
    </div>

    <div id="container">
        <div class="titleLogout">
            Cerrar sesión en iNube
        </div>

        <div class="forget">
        <form id="loginF" action="BasicView.jsp" method="post">
        <button id="login">Cancelar</button>
        </form>
        <form id="loginF" action="LogoutServlet">
         <button id="login">Aceptar</button>
        </form>
         
        </div>
    </div>

</div>
</shiro:user>
</body>
</html>