<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	 <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
	<c:import url="inc/header.jsp" />	
       
      <div class="panel-header panel-header-sm">
      </div>
      <div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h5 class="title">Ajout d'une image</h5>
              </div>
              <div class="card-body">
                 <form method="post" enctype="multipart/form-data">
                  <div class="row">
                    <div class="col-md-4 pr-1">
                      <div class="form-group">
                        <label>Nom Album:</label>
                        <input type="text" class="form-control" name="nomAlbum" value="${ album.nomAlbum }" disabled="">
                      </div>
                    </div>
                    <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>Détail Album:</label>
                        <input type="text" class="form-control" name="detail" value="${ album.detail }"  disabled="">
                      </div>
                    </div>
                    <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label for="portee">Portée de l'album:</label>
                        <input type="text" class="form-control" name="portee" value="${ album.portee }"  disabled="">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="form-group">
                        <label>Titre de la photo:</label>
                        <input type="text" class="form-control"  name="titre">
                      </div>
                    </div>
                    <div class="col-md-6 pl-1">
                      <div class="form-group">
                        <label>Mots Clés:</label>
                        <input type="text" class="form-control" name="mc">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Description : </label>
                        <input type="text" class="form-control" name="desc">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="form-group">
                        <label>hauteur:</label>
                        <input type="number" class="form-control" name="hauteur">
                      </div>
                    </div>
                    <div class="col-md-6 px-1">
                      <div class="form-group">
                        <label>largeur:</label>
                        <input type="number" class="form-control" name="largeur">
                      </div>
                      <div class="row">
                    <div class="col-md-6 px-1">
                      <div class="form-group">
                        <label>Choose Image: </label>
                        <input type="file" class="form-control-file" name="photo">
                      </div>
                    </div>
                  </div>
                   <div class="row">
                    <div class="col-md-6 px-1">
                      <div class="form-group">

                        <input type="submit" class="btn btn-primary btn-lg" value="ajouter">
                      </div>
                    </div>
                  </div>
                    </div>
                  </div>
                  
                   </form>   
                  </div>
                  </div>
                  </div>
                  </div>
                  </div>
              
                  
</body>
</html>