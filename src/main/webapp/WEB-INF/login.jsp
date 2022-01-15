<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>
<body>
	<section class="vh-100 gradient-custom" style="background-color: #2779e2;">
		<div class="container py-5 h-100">
  			<div class="row justify-content-center align-items-center h-100">
      			<div class="col-12 col-lg-9 col-xl-7">
       				<div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          				<div class="card-body p-4 p-md-5">
          					<div class="col d-flex justify-content-center">
            					<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Connectez-vous</h3>
           					</div>
            				<form method="POST">
								<div class="row mb-3">
                  					<div class="form-outline">
    									<label class="form-label" for="login">Login</label>
                    					<input type="text" id="login" name="login"  value="${ login }" class="form-control form-control-lg" />            
                  					</div>
            					</div>
            					<div class="row mb-3">
                 					<div class="form-outline">
                  						<label class="form-label" for="pwd">Mot de passe</label>
                    					<input type="password" id="pwd" name="pwd" class="form-control form-control-lg" />   
                 					</div>
                				</div>
                				<div class="col d-flex justify-content-center">
				    				<div class="mt-4 pt-2">
				                		<input class="btn btn-primary btn-lg" type="submit" value="connexion" />
				              		</div>
              					</div>
         					</form>
         					
		    				<div class="col d-flex justify-content-center">
			   				 	Vous n'avez pas encore de compte? <br/>
			                    <a href="<c:url value='/inscription'/>"> Inscrivez vous!  </a> 
			  				</div>
			         	</div>
			        </div>
				</div>
			</div>
		</div>
	</section>
</body>


