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
  		<link rel="icon" type="image/png" href="<c:url value="/assets/img/favicon.png"/>">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  		 <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  		<!--     Fonts and icons     -->
  		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
  		<!-- CSS Files -->
  		<link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet" />
  		<link href="<c:url value="/assets/css/now-ui-dashboard.css?v=1.5.0"/>" rel="stylesheet" />
	</head>
	<body>
		
		<div class="wrapper ">
    <div class="sidebar" data-color="blue">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
      <div class="logo">
        <a href="#photonet" class="simple-text logo-normal">
          PHOTO NET
        </a>
      </div>
      <div class="sidebar-wrapper" id="sidebar-wrapper">
      
        <ul class="nav">
        <c:choose>
					<c:when test="${!empty sessionScope.utilisateur }">
          <li>
            <a href="#wait">
              <i class="now-ui-icons design_app"></i>
              <p>Fil d'actualité</p>
            </a>
          </li>
         
          <li>
            <a href="<c:url value='/Albums'/>">
              <i class="now-ui-icons ui-1_bell-53"></i>
              <p>Mon Album</p>
            </a>
          </li>
         
          <li>
            <a href="<c:url value='/list'/>">
              <i class="now-ui-icons design_bullet-list-67"></i>
               <p>Gérer utilisateurs</p>
            </a>
          </li>
          <li>
            <a href="<c:url value='/addUser'/>">
              <i class="now-ui-icons ui-1_simple-add"></i>
               <p>Ajouter Utilisateurs</p>
            </a>
          </li>
          			</c:when>
					<c:otherwise>
						<li> <a href="<c:url value='/login'/>"> Connexion </a> </li>
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
            <a class="navbar-brand" href="#pablo"><c:out value='${sessionScope.utilisateur.login}'/></a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
           
            <ul class="navbar-nav">
             
              <li class="nav-item">
                <a class="nav-link" href="#pablo">
                  <i class="now-ui-icons users_single-02"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Account</span>
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
    