<%@page import="org.entity.Photos"%>
<%@page import="java.util.List"%>





<%@include file = "/include/header.jsp" %>



<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="main">

	
	<%response.setHeader("Cache-Control", "no-cache, no-store");

	Users user = null; String name = null;
	
	if(request.getSession().getAttribute("user")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
	else
	{
		user = (Users)request.getSession().getAttribute("user");
		name = user.getFirstName();
		
		out.print("<h1 style = 'text-align:center;'>Welcome "+name+"</h1>");
		
	%>
		<c:choose>
			<c:when test="${photos.size()==0 }">
				<h1 style="text-align: center;">No Photos Found</h1>
			</c:when>
			
			<c:otherwise>
				<h1 style="text-align: center;"><%=name %>'s Gallery</h1>
				
				<table class = "center" border="1">
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
						<td><a href="${pageContext.request.contextPath }/UserController?action=view&id=${photo.getPhotoId()}"><img src="${myVar }" height= "200" width="300"></a> </td>
						<td>${photo.getPhotoName() }</td>
						<td>${photo.getPhotoLabel() }</td>
						<td>${photo.getPhotoCaption() }</td>
					</tr>
				</c:forEach>
				</table>
				
				
				
			</c:otherwise>
		
		</c:choose>
	
	
	
	<% }%>


</div>


</body>
</html>