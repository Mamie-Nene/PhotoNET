<%@ page import ="beans.Utilisateur " %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="inc/header.jsp"  %>	
		<div class="panel-header panel-header-sm">
      </div>
      <div class="content">
      
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                <h5 class="title">Formulaire de modification d'un utilisateur</h5>
              </div>
              <div class="card-body">
                <form method="post">
                  <div class="row">
                    <div class="col-md-12">
                    <div class="form-group">
                        <label>Prenom</label>
                        <input type="text" class="form-control" name="prenom" value="${requestScope.utilisateur.prenom}">
                      	<span class="erreur"> ${ form.erreurs.prenom }</span>
                   </div> 
                  </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                    <div class="form-group">
                    	<label>Nom</label>
                        <input type="text" class="form-control" name="nom" value="${requestScope.utilisateur.nom}">
                      	<span class="erreur"> ${ form.erreurs.nom }</span>
                      </div>
                      </div>
                    </div>
                    <div class="row">
                    <div class="col-md-12">
                    	<div class="form-group">
                        <label>Login</label>
                        <input type="text" class="form-control" name="login" value="${requestScope.utilisateur.login}">
                      	<span class="erreur"> ${ form.erreurs.login}</span>
                      </div>
                      </div>
                    </div>
                  
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Mot de passe</label>
                      	<input type="password" class="form-control" name="pwd" value="${requestScope.utilisateur.password}">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Role[utilisateur simple - administrateur]</label>
                        <input type="text" class="form-control" name="userRole" value="${requestScope.utilisateur.userRole}">
						<span class="erreur"> ${ form.erreurs.userRole }</span>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-4">
                  		<div class="text-center">
                          <button class="btn btn-theme" >modifier</button>
                   </div>
                   </div>
                </form>
              </div>
            </div>
          </div>
          </div>
        </div>
      