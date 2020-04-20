<%@include file = "/include/header.jsp" %>

<div class="main">





<div class = "wrapper">

<%response.setHeader("Cache-Control", "no-cache, no-store");

	Users user = null; String name = null;
	
	if(request.getSession().getAttribute("user")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
	else
	{
		user = (Users) request.getSession().getAttribute("user");
		String url = (String)request.getSession().getAttribute("photoPath");
		
		out.print("<img  src='"+url+"' height = '500'/>");
		
		
}	%>
</div>
</div>
</body>
</html>