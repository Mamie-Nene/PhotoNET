<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	 <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
	<c:import url="inc/header.jsp" />	
       
      <div class="panel-header panel-header-sm">
      </div>
      <div class="content">
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                <h5 class="title">Ajout d'un Album</h5>
              </div>
              <div class="card-body">
                 <form method="post" >
                  <div class="row-md-6 ">
                      <div class="form-group">
                        <label>Nom Album:</label>
                        <input type="text" class="form-control" name="nomAlbum" value="${ album.nomAlbum }" >
                      </div>
                    </div>
                    
                    <div class="row-md-6 ">
                      <div class="form-group">
                        <label>Détail Album:</label>
                        <input type="text" class="form-control" name="detail" value="${ album.detail }" >
                      </div>
                    </div>
                    
                    <div class="row-md-6 ">
                    
                      <div class="form-group">
                        <label for="portee">Portée de l'album:</label>
                        <input type="text" class="form-control" name="portee" value="${ album.portee }">
                      </div>
                    
                  </div>
                   <div class="row">
                    <div class="col-md-6 px-1">
                      <div class="form-group">

                        <input type="submit" class="btn btn-primary btn-lg" value="ajouter">
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