<%@ page import ="beans.Utilisateur " %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="inc/header.jsp"  %>	
		<div id="corps">
			<h1 id="titre-principal"> Formulaire de modification d'un utilisateur</h1>
			<form method="post">
				<div class="formItem">
					<label> Nom </label>
					<input type="text" name="nom" value="${requestScope.utilisateur.nom}" >
					<span class="erreur"> ${ form.erreurs.nom }</span>
				</div>
				<div class="formItem">
					<label>Prénom </label>
					<input type="text"name="prenom" value="${requestScope.utilisateur.prenom}">
					<span class="erreur"> ${ form.erreurs.prenom }</span>
				</div>
				<div class="formItem">
					<label>Login </label>
					<input type="text" name="login" value="${requestScope.utilisateur.login}">
					<span class="erreur"> ${ form.erreurs.login }</span>
				</div>
				<div class="formItem">
					<label>Mot de passe </label>
					<input type="password" name="pwd" value="${requestScope.utilisateur.password}">
				</div>
				<div class="formItem">
					<label>Role utilisateur </label>
					<input type="text" name="userRole" value="${requestScope.utilisateur.userRole}">
					<span class="erreur"> ${ form.erreurs.login }</span>
				</div>
				<div class="formItem">
					<input type="submit" value="Valider" >
				</div>
			</form>
		</div>
<%@include file="inc/footer.jsp"  %>	