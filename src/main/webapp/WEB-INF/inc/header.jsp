<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PhOTO NET</title>
		  <%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">  --%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<%-- <script type="text/javascript" src="<c:url value="/js/javascript.js"/>"> </script>  --%>
		<link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/assets/img/apple-icon.png"/>">
  		<!--     Fonts and icons     -->
  		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  		<!-- CSS Files -->
  		<link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet" />
  		<link href="<c:url value="/assets/css/now-ui-dashboard.css?v=1.5.0"/>" rel="stylesheet" />
  		<link href="<c:url value="/css/footer.css"/>" rel="stylesheet" />
	</head>
	<body>
		<div class="wrapper ">
		
   				<div class="sidebar" data-color="blue">
      				<div class="logo">
        				<a href="#photonet" class="simple-text logo-normal"> PHOTO NET <span>221</span></a>
        				
      				</div>
      				<div class="sidebar-wrapper" id="sidebar-wrapper">
      					<ul class="nav">
      					
      						<c:choose>
								<c:when test="${!empty sessionScope.utilisateur }">
									<c:if test="${sessionScope.utilisateur.userRole=='utilisateur simple'}"> 
										<li> <a href="<c:url value='/accueilUserSimple'/>"> <i class="now-ui-icons design_app"></i>  Fil d'actualites </a> </li>
					         		</c:if>
					         		<c:if test="${sessionScope.utilisateur.userRole=='administrateur'}"> 
										<li> <a href="<c:url value='/accueilAdmin'/>"> <i class="now-ui-icons design_app"></i>  Fil d'actualites </a> </li>
										<li><a href="<c:url value='/gererUser'/>"> <i class="now-ui-icons design_bullet-list-67"></i>Gestion Utilisateur</a></li>
									</c:if>
							          	<li><a href="<c:url value='/Albums'/>"><i class="now-ui-icons ui-1_bell-53"></i>Mes Albums </a></li>
							          	
								</c:when>
								<c:otherwise>
									
									<c:forEach items="${requestScope.categories }" var= "categorie">
									<ul class="nav">
										<li> <a href="<c:url value='/categorie?categorie=${categorie.id}'/>"> <c:out value='${categorie.libelle}'/></a></li>
										
										
									</ul>
									</c:forEach>
      						 </c:otherwise>
							</c:choose>
						</ul>
      				</div>
   				</div>
		
		<!-- navbar -->
		<div class="main-panel" id="main-panel">
		     <nav class="navbar navbar-expand-lg navbar-transparent  bg-dark  navbar-absolute">
		     
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
           <c:if test="${sessionScope.utilisateur.userRole=='utilisateur simple'}"> 
					<a class="navbar-brand" href="<c:url value='/accueilUserSimple'/>"><c:out value='${sessionScope.utilisateur.login}'/></a>
         		</c:if> 
         		<c:if test="${sessionScope.utilisateur.userRole=='administrateur'}"> 
					<a class="navbar-brand" href="<c:url value='/accueilAdmin'/>"><c:out value='${sessionScope.utilisateur.login}'/></a>
         		</c:if>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
           
            <ul class="navbar-nav">
            <c:choose>
           	 <c:when test="${!empty sessionScope.utilisateur }">
              <li class="nav-item"><a class="nav-link" href="<c:url value='/logout'/>"><i class="now-ui-icons users_single-02"></i> Deconnexion <p><span class="d-lg-none d-md-block"></span></p></a> </li>
              </c:when>
              <c:otherwise>
				<li class="nav-item"> <a class="nav-link" href="<c:url value='/login'/>"> Connexion </a> </li>
				<li class="nav-item"> <a class="nav-link" href="<c:url value='/inscription'/>"> Inscription </a> </li>
			</c:otherwise>
			</c:choose>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
    