<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp" />
<div class="panel-header panel-header-sm">
      </div>
      <div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
            
              
              <c:choose>
				<c:when test="${empty requestScope.albums }"> 
				<div class="card-header">
                		<h5 class="title">MES ALBUMS</h5>
             	     <p class="category">vous n'avez crées aucun album ... </p> 
              </div>
              </c:when>  
               
              <c:otherwise>
              <div class="card-header">
                <h5 class="title">MES ALBUMS</h5>
              </div>
              <div class="card-body all-icons">
                <div class="row">
                 
                  <c:forEach items="${requestScope.albums }" var= "album">
                  <div class="font-icon-list col-lg-4 col-md-6 col-sm-8 col-xs-6 col-xs-6">
                    <div class="font-icon-detail">
                    	
                       
                       <a href="<c:url value='/displayImg?idalbum=${album.id}'/>"><i class="now-ui-icons design_image"> </i></a> 
                       <p class="category"><c:out value='${album.nomAlbum}'/></p>
                     
                    </div>
                  </div>
                  </c:forEach>
                  <div class="font-icon-list col-lg-4 col-md-6 col-sm-8 col-xs-6 col-xs-6">
                    <div class="font-icon-detail">
                       <a href="<c:url value='/AddAlbum?loginuser=${sessionScope.utilisateur.login}'/>"><i class="now-ui-icons ui-1_simple-add"> </i></a> 
                    	<p class="category">Ajoutez ici un nouvel album ... </p>
                    </div>
                  </div>
                 </div>
                </div>
               </c:otherwise>
			 </c:choose >
                  </div>
                  </div>
                  </div>
                  </div>
</body>
</html>