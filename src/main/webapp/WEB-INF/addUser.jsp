<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:import url="inc/header.jsp" />	
			<c:if test="${ !empty form }">
			<div id="statusMessageBox" class="alert alert-${ form.status ? 'success' : 'danger'}">
				<span id="control" onclick="hideMessageBox()" title="fermer"> x </span>
				${ form.statusMessage  }
			</div>
		</c:if>
			
	<div class="panel-header panel-header-sm">
      </div>
      <div class="content">
      
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                <h5 class="title">Formulaire d'ajout d'un utilisateur</h5>
              </div>
              <div class="card-body">
                <form method="post">
                  <div class="row">
                    <div class="col-md-12">
                    <div class="form-group">
                        <label>Prenom</label>
                        <input type="text" class="form-control" name="prenom" value="${ form.utilisateur.prenom }">
                      	<span class="erreur"> ${ form.erreurs.prenom }</span>
                   </div> 
                  </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                    <div class="form-group">
                    	<label>Nom</label>
                        <input type="text" class="form-control" name="nom" value="${ form.utilisateur.nom }">
                      	<span class="erreur"> ${ form.erreurs.nom }</span>
                      </div>
                      </div>
                    </div>
                    <div class="row">
                    <div class="col-md-12">
                    	<div class="form-group">
                        <label>Login</label>
                        <input type="text" class="form-control" name="login" value="${ form.utilisateur.login}">
                      	<span class="erreur"> ${ form.erreurs.login}</span>
                      </div>
                      </div>
                    </div>
                  
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Mot de passe</label>
                      	<input type="password" class="form-control" name="pwd" value="${ form.utilisateur.password}">
                      	<span class="erreur"> ${ form.erreurs.pwd }</span>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Mot de passe de confirmation</label>
                        <input type="password" class="form-control" name="pwdBis" value="${ form.utilisateur.passwordBis}">
						<span class="erreur"> ${ form.erreurs.pwdBis }</span>
                      </div>
                    </div>
                  </div>
                  
                  <label>Role de L'utilisateur</label>
                 
                   <div class="col-md-4">
                   <div class="btn-group-vertical" role="group" aria-label="Basic radio toggle button group">
  						<input type="radio" class="btn-check" name="userRole" id="userRole" value="utilisateur simple"  autocomplete="off" >
 						 <label class="btn btn-outline-primary" for="userRole">utilisateur simple</label>

  						<input type="radio" class="btn-check" name="userRole" id="userRole1" value="administrateur"  autocomplete="off">
  						<label class="btn btn-outline-primary" for="userRole1">Administrateur</label>
                   </div>
                   <span class="erreur"> ${ form.erreurs.userRole }</span>
                   </div>
                  <div class="col-md-4" align="center">
                  		
                          <button class="btn btn-theme" >Ajouter</button>
                   
                   </div>
                </form>
              </div>
            </div>
          </div>
          </div>
        </div>	