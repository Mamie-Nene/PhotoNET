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
				<c:when test="${empty requestScope.images}"> 
				<div class="card-header">
                		
             	     <p class="category">Il n'y a pas de photos pour le moment ... </p> 
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
                 
                 </div>
                </div>
               </c:otherwise>
			 </c:choose >
                  </div>
                  </div>
                  </div>
                  </div>
<c:import url="inc/footer.jsp" />

