<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil Gestions utilisateurs</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
		<script type="text/javascript" src="<c:url value="/js/javascript.js"/>"> </script>
	</head>
	<body>
		<div id="entete"> Gestion des utilisateurs </div>
		<div id="menu">
			<ul>
				<li> <a href="<c:url value='/accueil'/>"> Accueil </a> </li>
				<c:choose>
					<c:when test="${!empty sessionScope.utilisateur }">
						<li> <a href="<c:url value='/list'/>"> Gerer Utilisateur </a> </li>
						<li> <a href="<c:url value='/list'/>"> Gerer Photo </a> </li>
						<li> <a href="<c:url value='/logout'/>"> Déconnexion </a> </li>
					</c:when>
					<c:otherwise>
						<li> <a href="<c:url value='/login'/>"> Connexion </a> </li>
						<li> <a href="<c:url value='/inscription'/>"> Inscription </a> </li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		