<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iNube</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<shiro:guest>
<div id="container3">
    <img src="images/logo.png">
</div>



<div id="container1">

    <div id="container2-1">

    <div class="title">
        Iniciar sesión en iNube
    </div>
    <form id="loginF" action="LoginServlet" method="post">
        Correo electrónico: <input id="username" name="email">
        Contraseña: <input id="password" name="password" type="password">
        <button id="login" type="submit">Entrar</button>
    </form>
    </div>



    <div id="container2-2">

    <div class="title">Datos de la empresa</div>

   <form id="loginF" action="CreateUserServlet" method="post">
        <table class="users">
            <tr>
                <th>Nombre:</th>
                <td><input name="name" type="text" class="styledInput"/></td>
            </tr>
            <tr>
                <th>Correo electrónico:</th>
                <td><input name="email" type="text" class="styledInput"/></td>
            </tr>
            <tr>
                <th>Contraseña:</th>
                <td><input name="password" type="password" class="styledInput"/></td>
            </tr>
            <tr>
                <th>Nombre negocio:</th>
                <td><input name="merchant" type="text" class="styledInput"/></td>
            </tr>
            <tr>
                <th>CNAE:</th>
                <td><input name="cnae" type="text" class="styledInput"/></td>
            </tr>
            <tr>
                <th>Código postal:</th>
                <td><input name="zipCode" type="text" class="styledInput"/></td>
            </tr>
        </table>
        <button id="login">Registrarse</button>
    </form>
    </div>
  
</div>
</shiro:guest>

</body>
</html>