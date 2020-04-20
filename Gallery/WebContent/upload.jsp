<%@page import="org.entity.Photos"%>
<%@page import="java.util.List"%>
<%@include file = "/include/header.jsp" %>









<div class = "main">
<div class = "wrapper">




<%
	response.setHeader("Cache-Control", "no-cache, no-store");
	
	Users user = null;
	
	List<Photos> photos = null;
	
	if(request.getSession().getAttribute("user")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
	else
	{
		user = (Users) request.getSession().getAttribute("user");
		photos = (List) request.getSession().getAttribute("photos");
		out.print("<h1>Hey "+user.getFirstName()+"("+user.getUserName()+") Let's upload some pics</h1>");
		String form = 
				"<form action='UserController?action=uploadOperation&username="+user.getUserName()+"' method='post'>"+
					"<input type = 'file' name = 'file'  multiple = 'multiple'/><br/>"+
					"<input type='submit' style = 'width: 20%' formenctype='multipart/form-data' value = 'Upload'/>"+
				"</form>";
		
		out.print(form);
	}
	
%>


</div>
</div>
</body>
</html>