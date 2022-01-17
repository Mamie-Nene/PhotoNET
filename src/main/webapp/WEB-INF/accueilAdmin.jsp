<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp" />
<div class="panel-header panel-header-sm">
</div>
      <div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
            <h4 class="text-center">Bienvenue à PhotoNET221 </h4>
            <c:choose>
				<c:when test="${empty requestScope.photo }"> 
				<div class="card-header">
                		
             	     <p class="category">Il n'y a pas de photos pour le moment ... </p> 
              </div>
              </c:when>  
                  
              <c:otherwise>
              <div class="card-header">
                <h5 class="title">Fil d'actualités </h5>
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
<c:import url="inc/footer.jsp" />

