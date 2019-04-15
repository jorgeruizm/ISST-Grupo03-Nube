<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin View</title>
</head>
<body>
<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
</shiro:user>
<hr>
	<h2>Vista de administrador</h2>
	<shiro:lacksRole name="admin">
	No tienes permiso para ver el contenido de esta página
</shiro:lacksRole>
	<shiro:hasRole name="admin">
		<h3>Listado de usuarios</h3>
		<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Email</th>
				<th>Rol</th>
				<th>Acción requerida</th>
			</tr>
			<c:forEach items="${user_list}" var="user_i">
				<tr>
					<td>${user_i.name }</td>
					<td>${user_i.email }</td>
					<td>${user_i.role }</td>
					<td><form action="ChangeRoleServlet" method="post">
							<input type="hidden" name="email" value="${user_i.email}" />
							<button type="submit">Cambiar Rol</button>
					</form></td>
					<td><form action="DeleteUserServlet" method="post">
							<input type="hidden" name="email" value="${user_i.email}" />
							<button type="submit">Eliminar</button>
					</form></td>
				</tr>
			</c:forEach>	
		</table>
	</shiro:hasRole>
</body>
</html>