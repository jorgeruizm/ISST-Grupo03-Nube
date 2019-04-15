<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iNube</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div id="container">

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

    <div id="content">
        <div class="main">
            <div class="body">

                <span class="nTitle">Información a cerca del perfil</span>

                	
		
                
                    <form id="loginF" action="UpdateProfileServlet" method="post">
                <table class="users">
                    <tr>
                        <th>Nombre del negocio:</th>
                        <td>${user.business.merchant}</td>
                    </tr>
                    <tr>
                        <th>Código postal:</th>
                        <td><input name="zipCode" type="text" class="styledInput" value="${user.business.zipCode}"/></td>
                    </tr>
                    <tr>
                        <th>CNAE:</th>
                        <td><input name="cnae" type="text" class="styledInput" value="${user.business.cnae}"/></td>
                    </tr>
                    <tr>
                        <th>Contraseña:</th>
                        <td><input name="password" type="password" class="styledInput" value="qwerty"/></td>
                    </tr>
                    <tr>
                        <th>Correo electrónico:</th>
                        <td>${user.email}</td>
                    </tr>
                </table>
            </div>
        </div>


        <div id="front3">
            <span class="nTitle2">Editar perfil</span>
            <table class="filtro">
                <tr>
                    <th> 
                    <form id="loginF" action="UpdateProfileServlet" method="post">
                    		
                          <input type="hidden" value="${user.email }" name="email"/>
                          <button id="nButton" action="submit">Aceptar</button>
                  
                    </th>
                </tr>
            </table>
              </form>
        </div>
    </div>
</div>

</body>
</html>