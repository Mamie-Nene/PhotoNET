<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:import url="inc/header.jsp" />	
		<div id="corps">
			<c:if test="${ !empty form }">
			<div id="statusMessageBox" class="alert alert-${ form.status ? 'success' : 'danger'}">
				<span id="control" onclick="hideMessageBox()" title="fermer"> x </span>
				${ form.statusMessage  }
			</div>
		</c:if>
			<h1 id="titre-principal"> Formulaire d'inscription </h1>
			<form method="post">
				<div class="formItem">
					<label> Nom </label>
					<input type="text" name="nom" value="${ form.utilisateur.nom }" >
					<span class="erreur"> ${ form.erreurs.nom }</span>
				</div>
				<div class="formItem">
					<label>Prénom </label>
					<input type="text"name="prenom" value="${ form.utilisateur.prenom }" >
					<span class="erreur"> ${ form.erreurs.prenom }</span>
				</div>
				<div class="formItem">
					<label>Nom du'tilisateur </label>
					<input type="text" name="login" value="${ form.utilisateur.login}" >
					<span class="erreur"> ${ form.erreurs.login }</span>
				</div>
				<div class="formItem">
					<label>Mot de passe </label>
					<input type="password" name="pwd" >
					<span class="erreur"> ${ form.erreurs.pwd }</span>
				</div>
				<div class="formItem">
					<label>Confirmation du mot de passe  </label>
					<input type="password" name="pwdBis"  >
					<span class="erreur"> ${ form.erreurs.pwdBis }</span>
				</div>
				<div class="formItem">
					<input type="submit" value="Inscription" >
				</div>
			</form>
		</div> 
<c:import url="inc/footer.jsp" />	