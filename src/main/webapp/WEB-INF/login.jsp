<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="inc/header.jsp" />

<div id="corps">
    	<form method="POST">
        	<h2 class="form-login-heading"> Connectez-vous </h2>
        	<div class="formItem"> 
        		<label> Login</label>
            	<input type="text" name="login" value="${ login }"/> 
            </div>
            <div class="formItem"> 
            	<label> Mot de passe</label>
                <input  type="password"  name="pwd" />
            </div>
            <div class="formItem"> 
             	<input type="submit"  value="Connexion" /> 
            </div>
            <div class="registration">
                	Vous n'avez pas encore de compte? <br/>
                    <a href="<c:url value='/inscription'/>"> Inscrivez vous!  </a> 
            </div>
         </form>
    </div>


