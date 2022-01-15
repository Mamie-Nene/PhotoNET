<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp" />

<section class="wrapper">
	<h2 class="text-center"> Bienvenue à PhotoNET221 </h2>
	Il n'y a pas de photos pour le moment
    <a class="lien" href="index.php?action=pagination"> <button type="button"> Suivant </button></a>        
    <h2>Catégories</h2>
    <c:choose>
		<c:when  test="${empty requestScope.users }"> Il n'y a pas d'album pour le moment.
		</c:when>
		<c:when  test="${!empty requestScope.users }">
		</c:when>
	</c:choose>
</section>
            
<c:import url="inc/footer.jsp" />	