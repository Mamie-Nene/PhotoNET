<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  <head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
 </head>	
 <body>
		<c:if test="${ !empty form }">
			<div id="statusMessageBox" class="alert alert-${ form.status ? 'success' : 'danger'}">
				<span id="control" onclick="hideMessageBox()" title="fermer"> x </span>
				${ form.statusMessage  }
			</div>
		</c:if> 
		
		<section class="vh-100 gradient-custom" style="background-color: #2779e2;">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Formulaire d'inscription</h3>
            <form method="post">

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  <label class="form-label" for="prenom">Prénom</label>
                    <input type="text" id="prenom" name = "prenom" value="${ form.utilisateur.prenom }" class="form-control form-control-lg" />
                    <span class="erreur"> ${ form.erreurs.prenom }</span>
                  </div>


                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  <label class="form-label" for="nom">Nom</label>
                    <input type="text" id="nom" name = "nom" value="${ form.utilisateur.nom }" class="form-control form-control-lg" />
                    <span class="erreur"> ${ form.erreurs.nom }</span>
                  </div>

                </div>
              </div>
               
			<div class="row">
                <div class="col-12">

                 <div class="form-outline">
                  	<label class="form-label" for="login">Nom d'utilisateur </label>
                    <input type="text" id="login"  name="login" value="${ form.utilisateur.login}" class="form-control form-control-lg" />
                    <span class="erreur"> ${ form.erreurs.login }</span>
                  </div>

                </div>
              </div>
              
              <div class="row">
                	<div class="col-md-6 mb-4 pb-2">

                  		<div class="form-outline">
                  			<label class="form-label" for="pwd">Mot de passe </label>
                    		<input type="password" id="pwd"  name="pwd" class="form-control form-control-lg" />
                    		<span class="erreur"> ${ form.erreurs.pwd }</span>
                  		</div>
                	</div>
                <div class="col-md-6 mb-4 pb-2">


					<div class="form-outline">
                  		<label class="form-label" for="pwdBis">Mot de passe de confirmation </label>
                    	<input type="password" id="pwdBis"  name="pwdBis" class="form-control form-control-lg" />
                    	<span class="erreur"> ${ form.erreurs.pwdBis }</span>
                  	</div>

               </div>
              </div>

              <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Inscription" />
              </div>

         </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>