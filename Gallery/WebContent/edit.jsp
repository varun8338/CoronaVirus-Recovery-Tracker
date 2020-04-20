<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>







<%@include file = "/include/header.jsp" %>


<div class = "main">
	<div class = "wrapper">
	
		<%
			response.setHeader("Cache-Control", "no-cache, no-store");
		
			Users user = null;
		
			if(request.getSession().getAttribute("user")==null)
			{
				response.sendRedirect("login.jsp");
			}
			
			else
			{
				user = (Users) request.getSession().getAttribute("user");
				%>
			
		<c:choose>
			<c:when test="${photos.size()==0 }">
				<h1 style="text-align: center;">No Photos Found</h1>
			</c:when>
			
			<c:otherwise>
				<h1 style="text-align: center;">Photos Found</h1>
				
				<table border="1" style = "float:center;">
					<tr>
						<th>ID</th>
						<th>Image</th>
						<th>Name</th>
						<th>Label</th>
						<th>Caption</th>
					</tr>
				
				<c:forEach items="${photos }" var="photo">	
				<c:set var="myVar" value="${path}${photo.getPhotoName()}" />
								
					<tr>
						<td>${photo.getPhotoId() }</td>
						<td><img src="${myVar }" height= "200"/> </td>
						<td>${photo.getPhotoName() }</td>
						<td>${photo.getPhotoLabel() }</td>
						<td>${photo.getPhotoCaption() }</td>
						<td>
							<form action="<%=request.getContextPath() %>/UserController?action=updateOperation&id=${photo.getPhotoId() }&user=${photo.getUserName() }" method="post">
								Label <input type = "text" name = "label" value = "${photo.getPhotoLabel() }"/>	
								Caption <input type = "text" name = "caption" value = "${photo.getPhotoCaption() }"/>
								<input type = "submit" value = "Update"/>
							</form>
						
						
						</td>
					</tr>
				</c:forEach>
				</table>
				
				
				
			</c:otherwise>
		
		</c:choose>
		
			
				
		<%	} %>
	
	
	
	
	
	
	</div>


</div>

</body>
</html>