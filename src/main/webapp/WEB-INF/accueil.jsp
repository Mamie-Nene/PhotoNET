
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp" />
<div id="corps">
		<c:if test="${ status }">
			<div id="statusMessageBox" class="alert alert-success">
				<span id="control" onclick="hideMessageBox()" title="fermer"> x</span>
				${ param.message }
			</div>
		</c:if>
			<h1 id="titre-principal">  Liste des utilisateurs </h1>
			<c:choose>
				<c:when  test="${empty requestScope.users }"> La liste est vide </c:when>
				<c:when  test="${!empty requestScope.users }">
                	<table > 
						
							<tr>
								<th>id </th>
								<th>Nom</th>
								<th>Prenom </th>
								<th>Login </th>
								<th>Role </th>
								<th colspan=2>Actions </th> 
							</tr>
						
							<c:forEach items="${requestScope.users }" var= "utilisateur">
							<tr>
								<td><c:out value='${utilisateur.id}'/></td>
								<td><c:out value='${utilisateur.nom}'/> </td>
								<td><c:out value='${utilisateur.prenom}'/> </td>
								<td><c:out value='${utilisateur.login}'/> </td>
								<td><c:out value='${utilisateur.userRole}'/> </td>
								<td><a class="btn btn-theme" href="<c:url value='/updateUser?id=${utilisateur.id}'/>"> Modifier </a> </td>
								<td> <a class="btn btn-theme04" href="<c:url value='/deleteUser?id=${utilisateur.id}'/>  "> Supprimer </a> </td>
							</tr>
							</c:forEach>
						
					</table>
				</c:when>
			 </c:choose >	
		</div>
<c:import url="inc/footer.jsp" />	