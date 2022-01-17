
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp" />

		<c:if test="${ status }">
			<div id="statusMessageBox" class="alert alert-success">
				<span id="control" onclick="hideMessageBox()" title="fermer"> x</span>
				${ param.message }
			</div>
		</c:if>
			<c:choose>
				<c:when  test="${empty requestScope.users }"> La liste est vide 
				<a href="<c:url value='/addUser'/>"> Ajouter un utilisateur</a> 
				</c:when>
				<c:when  test="${!empty requestScope.users }">
					<div class="panel-header panel-header-sm">
	      			</div>
	      			<div class="content">
	        			<div class="row">
	          				<div class="col-md-12">
	            				<div class="card">
	              					<div class="card-header">
	                					<h4 class="card-title"> Liste des utilisateurs</h4>
	              					</div>
	              					<div class="card-body">
	               						 <div class="table-responsive">
	                						<table class="table"> 
												<thead class=" text-primary">
													<tr>
														<th>id </th>
														<th>Nom</th>
														<th>Prenom </th>
														<th>Login </th>
														<th>Role </th>
														<th class="text-right" colspan=2>Actions </th> 
													</tr>
												 </thead>
												 <tbody>
													<c:forEach items="${requestScope.users }" var= "utilisateur">
													<tr>
														<td><c:out value='${utilisateur.id}'/></td>
														<td><c:out value='${utilisateur.nom}'/> </td>
														<td><c:out value='${utilisateur.prenom}'/> </td>
														<td><c:out value='${utilisateur.login}'/> </td>
														<td><c:out value='${utilisateur.userRole}'/> </td>
														<td class="text-right"> <a class="btn btn-theme" href="<c:url value='/updateUser?id=${utilisateur.id}'/>"> Modifier </a> </td>
														<td> <a class="btn btn-theme04" href="<c:url value='/deleteUser?id=${utilisateur.id}'/>  "> Supprimer </a> </td>
													</tr>
													 
													</c:forEach>
								
												 </tbody>
											</table>
											<a href="<c:url value='/addUser'/>"><i class="now-ui-icons ui-1_simple-add"></i>Ajouter Utilisateur</a>
											 </div>
							              </div>
							            </div>
							          </div>
							          </div>
							      </div>
					 
				</c:when>
			 </c:choose >	

		
<c:import url="inc/footer.jsp" />	