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
				<c:when test="${empty requestScope.images}"> 
				<div class="card-header">
                		
             	     <p class="category">Cet album est vide ... </p>
             	   
             	     <div class="font-icon-list col-lg-4 col-md-6 col-sm-8 col-xs-6 col-xs-6">
                    <div class="font-icon-detail">
                      <a href="<c:url value='/uploadImg?nomalbum=${album.nomAlbum}'/>"><i class="now-ui-icons ui-1_simple-add"> </i></a> 
                    	<p class="category">Ajoutez ici une nouvelle photo ... </p>
                    </div>
                  </div>
             	     <a class="btn btn-theme04" href="<c:url value='/deleteAlbum?id=${album.id}'/>  "> Supprimer l'album </a> 
             	     
                    
                  </div>
             	     
              </div>
              </c:when>  
               
              <c:otherwise>
              <div class="card-body all-icons">
                <div class="row">
                 
                  <c:forEach items="${requestScope.images }" var= "image">
                  <div class="font-icon-list col-lg-4 col-md-6 col-sm-8 col-xs-6 col-xs-6">
                    <div class="font-icon-detail">
                    	
                       <img src="<c:out value="data:;base64,${image.img}"/>"/>
                       <p class="category"><c:out value='${image.titre}'/></p>
                     
                    </div>
                  </div>
                  </c:forEach>
                  <div class="font-icon-list col-lg-4 col-md-6 col-sm-8 col-xs-6 col-xs-6">
                    <div class="font-icon-detail">
                      <a href="<c:url value='/uploadImg?nomalbum=${album.nomAlbum}'/>"><i class="now-ui-icons ui-1_simple-add"> </i></a> 
                    	<p class="category">Ajoutez ici une nouvelle photo ... </p>
                    </div>
                     <a class="btn btn-theme04" href="<c:url value='/deleteAlbum?id=${album.id}'/>  "> Supprimer l'album </a> 
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