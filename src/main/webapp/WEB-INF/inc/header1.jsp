<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Accueil PhotoNET</title>
	<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="<c:url value='/asset/lib/bootstrap/css/bootstrap.min.css' /> " />
	<!--external css-->
		<link rel="stylesheet"  href=" <c:url value='/asset/lib/font-awesome/css/font-awesome.css' /> " />
	<!-- Custom styles for this template -->
		<link rel="stylesheet" href=" <c:url value='/asset/css/style.css' /> " />
		<link rel="stylesheet" href=" <c:url value='/asset/css/style-responsive.css' /> " />
	</head>
	<body>
		<section id="container">
			<!-- debut header -->
            <header class="header black-bg">
                <!--logo start-->
                <a href="<c:url value='/accueilAdmin'/>" class="logo"><b>PhotoNET<span>221</span></b></a>
                <!--logo end-->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                    <li><a class="log" href="<c:url value='/login'/>"> Connexion </a> </li>
                    <li><a href="<c:url value='inscription'/>" class="log1"> Inscription</a></li>
                    </ul>
                </div>
            </header>
            <!-- fin header -->
            <!-- debut conteneur -->
            <section id="main-content1">
                <section class="wrapper">
                    <h2 class="text-center"> Bienvenue à PhotoNET221 </h2>
                    <div class="row">
                        <div class="col-lg-9 "> 
                        
                        	<div class="pagination">
                            	<a class="lien" href="index.php?action=pagination"> <button type="button"> Suivant </button></a>        
                        	</div>
                        </div>
                        <div class= "ds">
                            
                            <h2>Catégories</h2>
                            
                        </div>
                    </div>
                </section>
            </section>
            <!-- fin conteneur-->
            </section>
            
		