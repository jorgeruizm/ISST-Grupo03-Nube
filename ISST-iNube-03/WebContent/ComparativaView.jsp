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


    <div id="front2">
        <span class="nTitle">Filtrar por fecha</span>
        <table class="filtro">
            <tr>
                <th>Inicio:</th>
                <td><input type="text" class="datepicker"></td>
            </tr>
            <tr>
                <th>Final:</th>
                <td><input type="text" class="datepicker"></td>
            </tr>
        </table>
        <span class="nTitle">Filtrar por provincia</span>
        <table class="filtro">
            <tr>
                <th>Seleccionar:</th>
                <td>
                    <select>
                        <option value="0">A Coruña</option>
                        <option value="0">Álava</option>
                        <option value="0">Albacete</option>
                        <option value="0">Alicante</option>
                        <option value="0">Almería</option>
                        <option value="0">Asturias</option>
                        <option value="0">Ávila</option>
                        <option value="0">Badajoz</option>
                        <option value="0">Baleares</option>
                        <option value="0">Barcelona</option>
                        <option value="0">Burgos</option>
                        <option value="0">Cáceres</option>
                        <option value="0">Cádiz</option>
                        <option value="0">Cantabria</option>
                        <option value="0">Castellón</option>
                        <option value="0">Ciudad Real</option>
                        <option value="0">Córdoba</option>
                        <option value="0">Cuenca</option>
                        <option value="0">Girona</option>
                        <option value="0">Granada</option>
                        <option value="0">Guadalajara</option>
                        <option value="0">Gipuzkoa</option>
                        <option value="0">Huelva</option>
                        <option value="0">Huesca</option>
                        <option value="0">Jaén</option>
                        <option value="0">La Rioja</option>
                        <option value="0">Las Palmas</option>
                        <option value="0">León</option>
                        <option value="0">Lérida</option>
                        <option value="0">Lugo</option>
                        <option value="0">Madrid</option>
                        <option value="0">Málaga</option>
                        <option value="0">Murcia</option>
                        <option value="0">Navarra</option>
                        <option value="0">Ourense</option>
                        <option value="0">Palencia</option>
                        <option value="0">Pontevedra</option>
                        <option value="0">Salamanca</option>
                        <option value="0">Segovia</option>
                        <option value="0">Sevilla</option>
                        <option value="0">Soria</option>
                        <option value="0">Tarragona</option>
                        <option value="0">Santa Cruz de Tenerife</option>
                        <option value="0">Teruel</option>
                        <option value="0">Toledo</option>
                        <option value="0">Valencia</option>
                        <option value="0">Valladolid</option>
                        <option value="0">Vizcaya</option>
                        <option value="0">Zamora</option>
                        <option value="0">Zaragoza</option>
                    </select>
                </td>
            </tr>
        </table>
        <tr>
            <th> <button id="nButton2" action="submit">Filtrar</button></th>
        </tr>
        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
        <script src="/graficas_comparativa.js"></script>
    </div>
    <div id="graficas">
    <img src="images/6.1.PNG">
    <img src="images/6.2.PNG">
    <img src="images/7.PNG">
    <img src="images/9.PNG">
    <img src="images/8.PNG">
    <img src="images/10.PNG">
</div>
</div>
</body>
</html>